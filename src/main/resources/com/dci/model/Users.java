package com.dci.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

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
    private long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "LOCKED")
    private boolean locked;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;
    
    public Collection<GrantedAuthority> getAuthorities() { 	
        List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        for (Role role : roles) {
            auth.add(new GrantedAuthorityImpl(role.getRole()));
        }
        //auth.add(new GrantedAuthorityImpl("ROLE_USER"));
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
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
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

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}