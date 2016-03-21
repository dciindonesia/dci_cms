package org.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.spring.model.Role;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "USER")

public class Users implements UserDetails, Serializable {

	    private static final long serialVersionUID = 2L;

	    @Id
	    @Column(name = "USER_ID", updatable=false, nullable=false)
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long userId;

	    @Column(name = "USERNAME")
	    private String username;

	    @Column(name = "PASSWORD")
	    private String password;

	    @Column(name = "NAME")
	    private String name;

	    @Column(name = "EMAIL")
	    private String email;
	    
	    @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
	             message="{invalid.phonenumber}")
	    private String phone;

	    @Column(name = "ENABLED")
	    private boolean enabled;
	    
	    @Column(name = "ACCOUNTNONEXPIRED")
	    private boolean accountNonExpired;
	    
	    @Column(name = "CREDENTIALNONEXPIRED")
	    private boolean credentialsNonExpired;
	    
	    @Column(name = "ACCOUNTNONLOCKED")
	    private boolean accountNonLocked;
	    
	    @ManyToOne(cascade = {CascadeType.ALL})
		@JoinColumn(name ="companyId")
		private Company company;

	  //bi-directional many-to-many association to Usergroup
	    @ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(
			name="USER_ROLE"
			, joinColumns={
				@JoinColumn(name="userId")
				}
			, inverseJoinColumns={
				@JoinColumn(name="roleId")
				}
			)
	    private Set<Role> roles;
	    
	    
	    
	    public Collection<GrantedAuthority> getAuthorities() { 	
	        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
	        for (Role role : this.getRoles()) {
	            auth.add(new GrantedAuthorityImpl(role.getRoleName()));
	        }        
	       return auth;
	    }
	/*
	    @Override
	    public GrantedAuthority[] getAuthorities() {
	        List<GrantedAuthorityImpl> list = new ArrayList<GrantedAuthorityImpl>(0);
	        for (Role role : roles) {
	            list.add(new GrantedAuthorityImpl(role.getRole()));
	        }
	        //Collection<GrantedAuthorityImpl> grantedAuthColl = list;
	       return (GrantedAuthority[]) list.toArray(new GrantedAuthority[list.size()]);
			//return grantedAuthColl;
	    }
	*/
	    
	    public Users() {}
	    
	    public long getUserId() {
	        return userId;
	    }

	    public void setUserId(long userId) {
	        this.userId = userId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }
	    
	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public boolean isEnabled() {
	        return enabled;
	    }
	    
	    public void setEnabled(boolean enabled) {
	    	this.enabled = enabled;
	    }
	    
	    public boolean isAccountNonExpired() {
	        return accountNonExpired;
	    }
	    
	    public void setAccountNonExpired(boolean accountNonExpired) {
	    	this.accountNonExpired = accountNonExpired;
	    }
	    
	    public boolean isCredentialsNonExpired() {
	        return credentialsNonExpired;
	    }
	    
	    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
	    	this.credentialsNonExpired = credentialsNonExpired;
	    }

	    public boolean isAccountNonLocked() {
	        return accountNonLocked;
	    }
	    
	    public void setAccountNonLocked(boolean accountNonLocked) {
	    	this.accountNonLocked = accountNonLocked;
	    }

	    public Set<Role> getRoles() {
	        return roles;
	    }

	    public void setRoles(Set<Role> roles) {
	        this.roles = roles;
	    }

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}


	}
