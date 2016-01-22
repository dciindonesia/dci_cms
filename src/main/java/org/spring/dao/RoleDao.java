package org.spring.dao;
// Generated 03 Des 12 16:08:08 by Hibernate Tools 3.4.0.CR1

import java.util.List;

import org.spring.model.Role;

/**
 * Home object for domain model class Usergroup.
 * @see .Usergroup
 * @author Hibernate Tools
 */
public interface RoleDao {

	void persist(Role transientInstance);
	void attachDirty(Role instance);
	void attachClean(Role instance);
	void delete(Role persistentInstance);
	Role merge(Role detachedInstance);
	Role findById(java.lang.String id);
	@SuppressWarnings("rawtypes")
	List findByExample(Role instance);
	List<Role> getAllRoles();
	List<Role> findByUsers(String uid);
}
