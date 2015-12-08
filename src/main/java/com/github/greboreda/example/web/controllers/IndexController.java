package com.github.greboreda.example.web.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.services.PersonsManager;

@Service
public class IndexController {

	@Autowired
	PersonsManager personsManager;
	
	public void createPerson(String name) {
		Person p = new Person();
		p.setName(name);
		personsManager.createPerson(p);
	}
	
	public List<Person> findAllPersons() {
		return personsManager.findAllPersons();
	}
	
	public void appendTelephoneToPerson(Person person, String phoneNumber) {
    	Telephone phone = new Telephone();
    	phone.setNumber(phoneNumber);
    	try {
			personsManager.appendTelephoneToPerson(person, phone);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void appendTelephoneToPersonByPersonId(Long personId, String phoneNumber) {
		Person person = personsManager.findPersonById(personId);
		if(person == null) {
			throw new RuntimeException("Person not found");
		}
		this.appendTelephoneToPerson(person, phoneNumber);
	}
}
