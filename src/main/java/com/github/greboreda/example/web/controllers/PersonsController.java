package com.github.greboreda.example.web.controllers;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;
import com.github.greboreda.example.model.mappers.TelephonesMapper;
import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.person.PersonVO;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.model.telephone.TelephoneVO;
import com.github.greboreda.example.services.PersonsManager;

@Service
public class PersonsController {

	@Autowired
	PersonsManager personsManager;
	
	Logger logger = LoggerFactory.getLogger(PersonsController.class);
	
	public void createPerson(String name, String lastName1, String lastName2, String nif) throws Exception{
		
		if (name == null || name.trim().isEmpty()) {
			throw new Exception("name is null or empty");
		}
		
		if (lastName1 == null || lastName1.trim().isEmpty()) {
			throw new Exception("Lastname1 is null or empty");
		}
		
		if (lastName2 == null || lastName2.trim().isEmpty()) {
			throw new Exception("Lastname2 is null or empty");
		}
		
		if (nif == null || nif.trim().isEmpty()) {
			throw new Exception("NIF is null or empty");
		}
		
		Person p = new Person();
		p.setName(name);
		p.setLastName1(lastName1);
		p.setLastName2(lastName2);
		p.setNif(nif);
		personsManager.createPerson(p);
		
		logger.info(String.format("Created Person [%s]", p.toString()));
	}
	
	public List<Person> findAllPersons() {
		return personsManager.findAllPersons();
	}

	public List<Person> findPersonsByNamePattern(String namePattern) {
		
		List<Person> persons = null;
		
		if(StringUtils.isNotBlank(namePattern)) {
			persons = personsManager.findPersonsByNamePattern(namePattern);			
		}
		else {
			persons = personsManager.findAllPersons();			
		}
		
		return persons;
	}
		
	public Person findPersonById(Long id) {
		
		Person person = null;
		
		person = personsManager.findPersonById(id);			
		
		return person;
	}
	
	public void appendTelephoneToPerson(Person person, Telephone telephone) throws Exception {
		
		if(person == null) {
			throw new NullPointerException("Person cannot be null");
		}
		
		personsManager.appendTelephoneToPerson(person, telephone);
		
	}
	
	public void newTelephoneAtPersonId(String id, String newPhone) throws Exception{
		
		Person person = null;
		Long personId = Long.parseLong(id);
		
		person = findPersonById(personId);
		
		System.out.println("Pulsado botón. Teléfono: " + newPhone + " de la persona: "
		+ person.getLastName1() + " " + person.getLastName2() + ", " + person.getName());
		
		Telephone telephone = new Telephone();
		telephone.setId(personId);
		telephone.setNumber(newPhone);
		
		appendTelephoneToPerson(person, telephone);
	}
}
