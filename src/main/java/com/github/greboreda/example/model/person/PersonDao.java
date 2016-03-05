package com.github.greboreda.example.model.person;

import java.util.List;

import com.github.greboreda.example.model.dao.GenericDao;
import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;

public interface PersonDao extends GenericDao<PersonVO,Long> {

	PersonVO findPersonByName(String name) throws InstanceNotFoundException;	
	
	List<PersonVO> findAllPersons();

	List<PersonVO> findPersonsByNamePattern(String namePattern);
}
