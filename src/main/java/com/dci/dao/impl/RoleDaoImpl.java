/**
 * 
 */
package com.dci.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.dci.dao.RoleDao;
import com.dci.model.Role;
import com.dci.model.Users;

/**
 * @author rahadhitya
 *
 */
@Service
public class RoleDaoImpl implements RoleDao {

	protected static Logger log = Logger.getLogger(RoleDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.spring.security.dao.RoleDao#getListRole(com.spring.security.model.Users)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getListRole(Users users) {
		log.debug(String.valueOf(users.getRoles()));
		return (List<Role>) users.getRoles();
	}

}
