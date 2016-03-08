package com.github.greboreda.example.model.authorization.role;

import java.util.Arrays;
import java.util.List;

import com.github.greboreda.example.model.BusinessObject;

public enum Role implements BusinessObject {
	
	ADMIN(0, "admin"),
	USER(1, "user");
		
	private static final long serialVersionUID = 5976326692086277409L;
	
	private static final List<Role> possibleRoles = Arrays.asList(Role.values());
	
	private long id;
	private String name;
	
	private Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Role fromName(String name) {		
		for(Role role : possibleRoles) {
			if(role.getName().equals(name)) {
				return role;
			}
		}
		return null;
	}
	
	public static Role fromId(long id) {		
		for(Role role : possibleRoles) {
			if(role.getId() == id) {
				return role;
			}
		}
		return null;
	}
	
}
