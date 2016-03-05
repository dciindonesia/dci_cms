package org.spring.dao;
// Generated 03 Des 12 16:08:08 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.springmvc.security.dao.UsersGroupDao;
import org.spring.model.Users;

/**
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */
@Repository
public class UsersDaoImpl implements UsersDao{

	protected static Logger log = Logger.getLogger(UsersDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void update(Users transientInstance) {
		try {
			sessionFactory.getCurrentSession().update(transientInstance);
		} catch (RuntimeException re) {
			log.error("update failed", re);
		}
	}
	
	@Transactional
	public void persist(Users transientInstance) {
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	@Transactional
	public void attachDirty(Users instance) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public void attachClean(Users instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public void delete(Users persistentInstance) {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Users merge(Users detachedInstance) {
		try {
			Users result = (Users) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Users findById(java.lang.String id) {
		try {
			Users instance = (Users) sessionFactory.getCurrentSession().createQuery(
					"from " + Users.class.getName() + " u where u.firstName='" + id + "'").uniqueResult();
			/*
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			*/
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional
	@SuppressWarnings("rawtypes")
	public List findByExample(Users instance) {
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("User").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@Transactional
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Users> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Users> userx = (List<Users>) session
				.find("from " + Users.class.getName());
		return userx;
	}
	
	@Transactional
	public Users findByName(java.lang.String name) {
		Users useren = new Users();
		try {
			List<Users> users = this.getAllUser();
			
			for(Users userfor : users) {
				if ( userfor.getUsername().equals(name)  == true ) {					
					useren = userfor;
				}
			}
			return useren;
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional
	@Override
	public Users getUserById(String uid) {
		Session session = sessionFactory.getCurrentSession();
		return (Users) session.get(Users.class, uid);
	}
}
