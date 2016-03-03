/**
 * 
 */
package org.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.spring.model.Company;
import org.spring.model.ContactPerson;
import org.spring.service.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * @author rahadhitya
 *
 */
@Repository
public class ContactPersonDaoImpl implements ContactPersonDao {
	protected static Logger log = Logger.getLogger(ContactPersonDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see org.spring.dao.ContactPersonDao#persist(org.spring.model.ContactPerson)
	 */
	@Transactional
	@Override
	public void persist(ContactPerson contactPerson) {
		log.debug("save ContactPerson instance " + contactPerson.getContactName());
		try {
			this.sessionFactory.getCurrentSession().persist(contactPerson);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ContactPerson> getAllContactPerson(Long contactId) {
		try {
			Company company = (Company) sessionFactory.getCurrentSession()
					//.createQuery("SELECT cp FROM ContactPerson cp, Company c WHERE cp.company.companyId = c.companyId "
					//		+ "AND c.companyId=" + clientId).list());
					.createQuery("FROM Company as c LEFT JOIN FETCH  c.contactPersons WHERE c.companyId= :pattern")
							.setParameter("pattern", contactId).uniqueResult();
			List<ContactPerson> cpList = new ArrayList<ContactPerson>(company.getContactPersons());
			log.debug(cpList.get(0).getContactName());
			return cpList;
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	// helpers
	
	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<ContactPerson> findHotels(SearchCriteria criteria, int firstResult, String orderBy, boolean ascending) {
	String pattern = getSearchPattern(criteria);
	orderBy = (orderBy != null) ? orderBy : "name";
	String orderDirection = (ascending) ? " ASC" : " DESC";
	return this.sessionFactory.getCurrentSession()
		.createQuery(
			"select h from Hotel h where lower(h.name) like :pattern or lower(h.city) like :pattern "
				+ "or lower(h.zip) like :pattern or lower(h.address) like :pattern order by h."
				+ orderBy + orderDirection).setParameter("pattern", pattern)
		.setMaxResults(criteria.getPageSize()).setFirstResult(firstResult).list();
    }
	
	@Transactional(readOnly = true)
    public int getNumberOfHotels(SearchCriteria criteria) {
	String pattern = getSearchPattern(criteria);
	Long count = (Long) this.sessionFactory.getCurrentSession()
		.createQuery(
			"select count(h.id) from Hotel h where lower(h.name) like :pattern or lower(h.city) like :pattern "
				+ "or lower(h.zip) like :pattern or lower(h.address) like :pattern")
		.setParameter("pattern", pattern).uniqueResult();
	return count.intValue();
    }

    public String getSearchPattern(SearchCriteria criteria) {
	if (StringUtils.hasText(criteria.getSearchString())) {
	    return "%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%";
	} else {
	    return "%";
	}
    }

    public ContactPerson findContactPerson(String username) {
	return (ContactPerson) this.sessionFactory.getCurrentSession().createQuery("select u from User u where u.username = :username")
		.setParameter("username", username).uniqueResult();
    }
    
    

}