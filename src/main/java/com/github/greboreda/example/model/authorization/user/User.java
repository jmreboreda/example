package com.github.greboreda.example.model.authorization.user;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.mindrot.jbcrypt.BCrypt;

import com.github.greboreda.example.model.BusinessObject;
import com.github.greboreda.example.model.authorization.role.Role;

public class User implements BusinessObject {

	private static final long serialVersionUID = -8010061014257128365L;

	private Long id;
	private String username;
	private String password;
	private String hashedPassword;
	private String salt;
	
	private Set<Role> roles;
	private Set<String> permissions;
	
	
	public User() {
		this.roles = new HashSet<Role>();
	}
	
	public User(String username, String password) {
		this();
		this.username = username;
		this.password = password;
		this.salt = BCrypt.gensalt();
		this.hashedPassword = BCrypt.hashpw(this.password, this.salt);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getHashedPassword() {
		return hashedPassword;
	}
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void appendRole(Role role) {
		this.roles.add(role);
	}
	
	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}
