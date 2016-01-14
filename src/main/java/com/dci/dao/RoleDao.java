/**
 * 
 */
package com.dci.dao;

import java.util.List;

import com.dci.model.Role;
import com.dci.model.Users;

/**
 * @author rahadhitya
 *
 */
public interface RoleDao {
	List<Role> getListRole(Users users);
}
