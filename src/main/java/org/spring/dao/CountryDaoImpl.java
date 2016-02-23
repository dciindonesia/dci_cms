/**
 * 
 */
package org.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.spring.model.Countries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rahadhitya
 *
 */
@Repository
public class CountryDaoImpl implements CountryDao {

	protected static Logger log = Logger.getLogger(CountryDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/* (non-Javadoc)
	 * @see org.spring.dao.CountryDao#persist(org.spring.model.Country)
	 */
	@Transactional
	@Override
	public void persist(Countries country) {
		log.debug("save Country instance " + country.getCountryName());
		try {
			this.sessionFactory.getCurrentSession().persist(country);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		throw re;
		}
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.CountryDao#update(org.spring.model.Country)
	 */
	@Transactional
	@Override
	public void update(Countries country) {
		log.debug("update Country instance " + country.getCountryName());
		try {
			this.sessionFactory.getCurrentSession().update(country);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		throw re;
		}
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.CountryDao#delete(org.spring.model.Country)
	 */
	@Transactional
	@Override
	public void delete(Countries country) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(country);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.CountryDao#findById(int)
	 */
	@Transactional
	@Override
	public Countries findById(int countryId) {
		log.debug("getting Company instance with id: " + countryId);
		return (Countries) sessionFactory.getCurrentSession().get(Countries.class, countryId);
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.CountryDao#findByName(java.lang.String)
	 */
	@Transactional
	@Override
	public Countries findByName(String countryName) {
		log.debug("getting Country instance with name: " + countryName);
		try {
			Countries instance = (Countries) sessionFactory.getCurrentSession().createQuery(
					"from " + Countries.class.getName() + " c where c.country_name='" + countryName + "'").uniqueResult();
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

	/* (non-Javadoc)
	 * @see org.spring.dao.CountryDao#getAllCountry()
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Countries> getAllCountry() {
		log.debug("getting All Country instance");
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from Countries").list();
		} catch (RuntimeException re) {
			log.error("get All Country failed ", re);
			throw re;
		}
	}

}