package com.dci.dao;
// Generated 03 Des 12 16:08:08 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import com.dci.model.Users;


/**
 * Home object for domain model class User.
 * @see .User
 * @author Hibernate Tools
 */
public interface UsersDao {
	
	void update(Users transientInstance);
	void persist(Users transientInstance);
	void attachDirty(Users instance);
	void attachClean(Users instance);
	void delete(Users persistentInstance);
	Users merge(Users detachedInstance);
	Users findById(java.lang.String id);
	@SuppressWarnings("rawtypes")
	List findByExample(Users instance);
	List<Users> getAllUser();
	Users findByName(java.lang.String name);
	Users getUserById(String uid);
}
