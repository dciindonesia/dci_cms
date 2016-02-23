package org.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.spring.model.Company;
import org.spring.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	protected static Logger log = Logger.getLogger(CompanyDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public int persist(Company company) {
		log.debug("save Registration instance " + company.getCompanyName());
		try {
			log.debug("persist successful");
			return (Integer) sessionFactory.getCurrentSession().save(company);
			
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
	public void delete(Company company) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(company);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}

	@Transactional(readOnly=true)
	@Override
	public Company findById(int companyId) {
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
	public List<Company> getAllCompany() {
		log.debug("getting All Company instance");
		try {
			@SuppressWarnings("unchecked")
			List<Company> companyList = (List<Company>) sessionFactory.getCurrentSession()
				.createQuery("from " + Company.class).list();
			return companyList;
		} catch (RuntimeException re) {
			log.error("get All Company failed ", re);
			throw re;
		}
	}

}
