package com.github.greboreda.example.model.dao;

import java.io.Serializable;

import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;



public interface GenericDao <E, PK extends Serializable>{

	void create(E entity);
		
	E find(PK id) throws InstanceNotFoundException;
	
	boolean exists(PK id);
	
	E update(E entity);

	void remove(PK id) throws InstanceNotFoundException;	
	
}
