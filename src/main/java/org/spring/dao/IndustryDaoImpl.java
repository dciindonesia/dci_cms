/**
 * 
 */
package org.spring.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.spring.model.Countries;
import org.spring.model.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author rahadhitya
 *
 */
@Repository
public class IndustryDaoImpl implements IndustryDao {

	protected static Logger log = Logger.getLogger(IndustryDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	/* (non-Javadoc)
	 * @see org.spring.dao.IndustryDao#persist(org.spring.model.Industry)
	 */
	@Transactional
	@Override
	public void persist(Industry industry) {
		log.debug("save industry instance " + industry.getIndustryName());
		try {
			this.sessionFactory.getCurrentSession().persist(industry);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		throw re;
		}
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.IndustryDao#update(org.spring.model.Industry)
	 */
	@Transactional
	@Override
	public void update(Industry industry) {
		log.debug("update industry instance " + industry.getIndustryName());
		try {
			this.sessionFactory.getCurrentSession().update(industry);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
		throw re;
		}
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.IndustryDao#delete(org.spring.model.Industry)
	 */
	@Override
	public void delete(Industry industry) {
		log.debug("deleting industry instance");
		try {
			sessionFactory.getCurrentSession().delete(industry);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.IndustryDao#findById(int)
	 */
	@Transactional
	@Override
	public Industry findById(int industryId) {
		log.debug("getting Industry instance with id: " + industryId);
		return (Industry) sessionFactory.getCurrentSession().get(Industry.class, industryId);
	}

	/* (non-Javadoc)
	 * @see org.spring.dao.IndustryDao#findByName(java.lang.String)
	 */
	@Transactional
	@Override
	public Industry findByName(String industryName) {
		log.debug("getting Industry instance with name: " + industryName);
		try {
			Industry instance = (Industry) sessionFactory.getCurrentSession().createQuery(
					"from Industry i where i.industry_name='" + industryName + "'").uniqueResult();
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
	 * @see org.spring.dao.IndustryDao#getAllindustry()
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	@Override
	public List<Industry> getAllindustry() {
		log.debug("getting All Industry instance");
		
		try {
			return sessionFactory.getCurrentSession()
					.createQuery("from Industry").list();
		} catch (RuntimeException re) {
			log.error("get All Industry failed ", re);
			throw re;
		}
	}

}
