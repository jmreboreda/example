package com.github.greboreda.example.web.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.services.PersonsManager;

@Service
public class PersonsController {

	@Autowired
	PersonsManager personsManager;
	
	public void createPerson(String name, String lastName) throws Exception{
		
		if (name == null || name.trim().isEmpty()) {
			throw new Exception("name is null or empty");
		}
		
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new Exception("Lastname is null or empty");
		}
		
		Person p = new Person();
		p.setName(name);
		p.setLastName(lastName);
		personsManager.createPerson(p);
	}
	
	public List<Person> findAllPersons() {
		return personsManager.findAllPersons();
	}
	
}
