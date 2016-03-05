package org.spring.dao;
// Generated 03 Des 12 16:08:08 by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;





//import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.spring.dao.RoleDaoImpl;
import org.spring.model.Role;
import org.spring.model.Users;

/**
 * Home object for domain model class Usergroup.
 * @see .Usergroup
 * @author Hibernate Tools
 */
@Service
@Transactional
public class RoleDaoImpl implements RoleDao{

	private static final Log log = LogFactory.getLog(RoleDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UsersDao usersDao;


	public void persist(Role transientInstance) {
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Role instance) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Role instance) {
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Role persistentInstance) {
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Role merge(Role detachedInstance) {
		try {
			Role result = (Role) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Role findById(java.lang.String id) {
		try {
			Role instance = (Role) sessionFactory.getCurrentSession()
					.get(Role.class, id);
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

	@SuppressWarnings("rawtypes")
	public List findByExample(Role instance) {
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Usergroup").add(Example.create(instance))
					.list();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<Role> getAllRoles() {
		log.debug("get all Usergroup by List");
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Role> roleList = (List<Role>) session
				.createQuery("from " + Role.class.getName()).list();
			return roleList;
		} catch (RuntimeException re) {
			log.error("find all usergroup failed", re);
			throw re;
		}
	}

	@Override
	public List<Role> findByUsers(String uid) {
		List<Role> groupList = new ArrayList<Role>();
		Users users = usersDao.getUserById(uid);
		for (Role grp : users.getRoles()) {
			groupList.add(grp);
		}
		return groupList;
	}
	
	
	
}
