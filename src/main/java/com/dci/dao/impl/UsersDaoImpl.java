package com.dci.dao.impl;
// Generated 03 Des 12 16:08:08 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.dao.UsersDao;
import com.dci.model.Users;

/**
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */
@Service
@Transactional
public class UsersDaoImpl implements UsersDao{

	protected static Logger log = Logger.getLogger(UsersDaoImpl.class);
	
	@Autowired
	//private SessionFactory sessionFactory;
//	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	
	
	public void update(Users transientInstance) {
		log.debug("Progress Update User instance");
		try {
			sessionFactory.getCurrentSession().update(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
		}
	}
	
	public void persist(Users transientInstance) {
		log.debug("persisting User instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	
	
	public void attachDirty(Users instance) {
		log.debug("attaching dirty User instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void attachClean(Users instance) {
		log.debug("attaching clean User instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public void delete(Users persistentInstance) {
		log.debug("deleting User instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public Users merge(Users detachedInstance) {
		log.debug("merging User instance");
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
	
	public Users findById(long id) {
		log.debug("getting User instance with id: " + String.valueOf(id));
		try {
			//Userx instance = (Userx) sessionFactory.getCurrentSession().get(
			//		"User", id);
			Users instance = (Users) sessionFactory.getCurrentSession().createQuery(
					"from " + Users.class.getName() + " u where u.id='" + id + "'").uniqueResult();
					//.addEntity("com.jsfsample.model.Userx").list();
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
	
	public Users getByName(String username) {
		log.debug("getting User instance with id: " + String.valueOf(username));
		try {
			//Userx instance = (Userx) sessionFactory.getCurrentSession().get(
			//		"User", id);
			Users instance = (Users) sessionFactory.getCurrentSession().createQuery(
					"from " + Users.class.getName() + " u where u.username='" + username + "'").uniqueResult();
					//.addEntity("com.jsfsample.model.Userx").list();
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

	@SuppressWarnings("rawtypes")
	public List findByExample(Users instance) {
		log.debug("finding User instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("User").add(Example.create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Users> getAllUser() {
		Session session = sessionFactory.getCurrentSession();
		
		List<Users> userx = (List<Users>) session
				//.createQuery("from User").list();
				//.createQuery( "select i from Item i");
				.find("from " + Users.class.getName());
		return userx;
	}
	
	@SuppressWarnings("null")
	public Users findByName(String username) {
		log.debug("getting User instance with name: " + username);
		Session session = sessionFactory.getCurrentSession();
		
		try {
			/*
			Users instance = (Users) sessionFactory.getCurrentSession().createQuery(
					"from " + Users.class.getName() + " u where u.username='" + username + "'").uniqueResult();
			
			Users instance = (Users) session.createQuery(
					"from " + Users.class.getName() + " u where u.username='" + username + "'").uniqueResult();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			transaction.commit();
			return instance;
			*/
			Query query = session.createQuery(
					"FROM Users where username = :username");
			query.setString("username", username);
			return (Users) query.uniqueResult();
			
		} catch (RuntimeException re) {
			//log.error("get failed", re);
			//throw re;		
			log.error(" ERROR Exception in findByName(String userName ", re);
			return null;		
		}
		
			/*
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		*/
		/*
		Users useren = new Users();
		try {
			List<Users> users = this.getAllUser();
			
			for(Users userfor : users) {
				if ( userfor.getName().equals(name)  == true ) {					
					useren = userfor;
				}
			}
			return useren;
			
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
		*/
	}

	@Override
	public Users getUserById(String uid) {
		log.debug("getting User instance with id: " + uid);
		Session session = sessionFactory.getCurrentSession();
		return (Users) session.get(Users.class, uid);
	}
}
