package org.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.spring.model.Users;

@Entity
@Table(name="ROLE")
public class Role implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ROLE_ID")
    private long roleId;
	
    @Column(name="ROLENAME")
    private String roleName;
	
	//bi-directional many-to-many association to Userx
	@ManyToMany(mappedBy="roles", fetch=FetchType.LAZY)
	private Set<Users> users;
	
	@Override
    public int hashCode() {
        return new String(String.valueOf(roleId)).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (! (obj instanceof Role)) {
            return false;
        }
        return this.roleId == ((Role)obj).getRoleId();
    }
    
    public Role () {}

    public Role (Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public Set<Users> getUsers() {
		return this.users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
    
}
