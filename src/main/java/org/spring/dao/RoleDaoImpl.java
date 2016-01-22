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
		log.debug("persisting Usergroup instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Role instance) {
		log.debug("attaching dirty Usergroup instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Role instance) {
		log.debug("attaching clean Usergroup instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Role persistentInstance) {
		log.debug("deleting Usergroup instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Role merge(Role detachedInstance) {
		log.debug("merging Usergroup instance");
		try {
			Role result = (Role) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Role findById(java.lang.String id) {
		log.debug("getting Usergroup instance with id: " + id);
		try {
			Role instance = (Role) sessionFactory.getCurrentSession()
					.get(Role.class, id);
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
	public List findByExample(Role instance) {
		log.debug("finding Usergroup instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Usergroup").add(Example.create(instance))
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
	public List<Role> getAllRoles() {
		log.debug("get all Usergroup by List");
		Session session = sessionFactory.getCurrentSession();
		try {
			List<Role> roleList = (List<Role>) session
				.createQuery("from " + Role.class.getName()).list();
				//.createQuery( "select i from Item i");
				//.find("from " + Role.class.getName());
			log.debug("find all usergroup successful, result size: "
				+ roleList.size());
			return roleList;
		} catch (RuntimeException re) {
			log.error("find all usergroup failed", re);
			throw re;
		}
	}

	@Override
	public List<Role> findByUsers(String uid) {
		log.debug("get all Usergroup join with User");
		List<Role> groupList = new ArrayList<Role>();
		Users users = usersDao.getUserById(uid);
		for (Role grp : users.getRoles()) {
			groupList.add(grp);
		}
		return groupList;
	}
	
	
	
}
