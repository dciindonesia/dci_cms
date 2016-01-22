package org.spring.model;

import java.util.List;

public class UsersDTO {

	private Users users = new Users();
	private List<Role> roles;
	
	
	
	public UsersDTO(){};

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
