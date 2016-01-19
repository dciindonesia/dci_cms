package com.dci.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dci.dao.UsersDao;
import com.dci.dao.impl.GetUsersDao;
import com.dci.dao.impl.UsersDaoImpl;
import com.dci.model.Person;
import com.dci.model.Role;
import com.dci.model.Users;

/**
 * A custom service for retrieving users from a custom datasource, such as a database.
 * <p>
 * This custom service must implement Spring's {@link UserDetailsService}
 */
//@Service("customUserDetailsService")
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
	
	protected static Logger logger = Logger.getLogger("service");
	
	@Autowired
	private UsersDao usersDao = new UsersDaoImpl();
	@Autowired
	private GetUsersDao getUsersDao;
	
	/**
	 * Retrieves a user record containing the user's credentials and access. 
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		// Declare a null Spring User
		UserDetails user = null;
		try {
			logger.debug("mlebu nang loadUserByUserName :" + username);
			// Search database for a user that matches the specified username
			// You can provide a custom DAO to access your persistence layer
			// Or use JDBC to access your database
			// DbUser is our custom domain user. This is not the same as Spring's User
			Users users = usersDao.getByName(username);				
			logger.debug("retrieve User : " + users.getName());
			
			// Populate the Spring User object with details from the dbUser
			// Here we just pass the username, password, and access level
			// getAuthorities() will translate the access level to the correct role type

			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			logger.debug(authorities.isEmpty());
			//logger.debug(users.getRoles());
		    //for (Role role : users.getRoles()) { // 
		    	
		      authorities.add(new GrantedAuthorityImpl(String.valueOf("ROLE_ADMIN")));//role.getRole()
		    //}
		    logger.debug("entuk authorities");
			user =  new User(
					users.getUsername(), 
					users.getPassword().toLowerCase(),
					true,
					true,
					true,
					true,
					authorities);
			 logger.debug("retrive paket User loadUserByUserName");
		} catch (Exception e) {
			logger.error("Error in retrieving user " + e.toString());
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		
		// Return user to Spring for processing.
		// Take note we're not the one evaluating whether this user is authenticated or valid
		// We just merely retrieve a user that matches the specified username
		return user;
	}
	
}
