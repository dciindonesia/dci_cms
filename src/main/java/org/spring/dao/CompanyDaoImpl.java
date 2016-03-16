package org.spring.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.spring.model.Company;
import org.spring.model.ContactPerson;
import org.spring.model.Registration;
import org.spring.model.Users;
import org.spring.service.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	protected static Logger log = Logger.getLogger(CompanyDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UsersDao usersDao;
	
	@Transactional
	@Override
	public Long persist(Company company) {
		log.debug("save Registration instance " + company.getCompanyName());
		try {
			log.debug("persist successful");
			
			return (Long) sessionFactory.getCurrentSession().save(company);
			
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;	
		}
	}
	
	@Transactional
	@Override
	public void update(Company company) {
		log.debug("update Registration instance " + company.getCompanyName());
		try {
			this.sessionFactory.getCurrentSession().update(company);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		throw re;
		}

	}

	@Transactional
	@Override
	public void delete(Long companyId) {
		log.debug("deleting User instance");
		try {
			Company company = (Company) this.sessionFactory.getCurrentSession().createQuery("FROM Company as p LEFT JOIN FETCH  p.contactPersons WHERE p.companyId = :companyId")
					.setParameter("companyId", companyId).uniqueResult();
			Set<ContactPerson> contactSet = company.getContactPersons();
			this.sessionFactory.getCurrentSession().delete(company);
			for (ContactPerson contact : contactSet) {
				this.sessionFactory.getCurrentSession().delete(contact);
			}
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	@Transactional(readOnly=true)
	@Override
	public Company findById(Long companyId) {
		log.debug("getting Company instance with id: " + companyId);
		return (Company) sessionFactory.getCurrentSession().get(Company.class, companyId);
	}

	@Transactional(readOnly=true)
	@Override
	public Company findByName(String companyName) {
		log.debug("getting Company instance with name: " + companyName);
		try {
			Company instance = (Company) sessionFactory.getCurrentSession().createQuery(
					"from " + Company.class.getName() + " c where c.companyName='" + companyName + "'").uniqueResult();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Transactional(readOnly=true)
	@Override
	public Company findByAdmin(String adminName) {
		try {
			Users users = usersDao.findByName(adminName);
			Company instance = (Company) sessionFactory.getCurrentSession().createQuery(
					"from " + Company.class.getName() + " c where c.users='" + users.getUserId() + "'").uniqueResult();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings({ "unchecked"})
	@Transactional(readOnly=true)
	@Override
	public List<Company> getAllCompany() {
		log.debug("getting All Company instance");
		try {
			List<Company> companyList = new ArrayList<Company>(this.sessionFactory
					.getCurrentSession()
					.createQuery("from " + Company.class.getName()).list());
			return companyList;
		} catch (RuntimeException re) {
			log.error("get All Company failed ", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Company> getAllCompSearch(String searching) {
		try{
			String pattern = getSearchPattern(searching);
			List<Company> companyList = new ArrayList<Company>(this.sessionFactory
					.getCurrentSession()
					.createQuery(
						"select c from " + Company.class.getName() + " as c "
								+ " where lower(c.companyName) like :pattern ")
//								+ "or (lower(c.companyDesc) like :pattern "
//								+ "or lower(c.companyService) like :pattern "
//								+ "or lower(c.companyHQ) like :pattern)")
							.setParameter("pattern", pattern).list());
					//.setMaxResults(criteria.getPageSize()).setFirstResult(firstResult).list();
			return companyList;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public String getSearchPattern(String criteria) { //SearchCriteria criteria) {
		if (StringUtils.hasText(criteria)) { //criteria.getSearchString())) {
		    return "%" + criteria.toLowerCase().replace('*', '%') + "%";//criteria.getSearchString().toLowerCase().replace('*', '%') + "%";
		} else {
		    return "%";
		}
	}

}
