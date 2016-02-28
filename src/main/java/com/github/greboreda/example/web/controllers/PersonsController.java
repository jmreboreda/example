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
	
	public void createPerson(String name, String lastName, String nif, String address, String postalCode, String location) throws Exception{
		
		if (name == null || name.trim().isEmpty()) {
			throw new Exception("name is null or empty");
		}
		
		if (lastName == null || lastName.trim().isEmpty()) {
			throw new Exception("Lastname is null or empty");
		}
		
		if (nif == null || nif.trim().isEmpty()) {
			throw new Exception("NIF is null or empty");
		}
		
		if (address == null || address.trim().isEmpty()) {
			throw new Exception("Address is null or empty");
		}
		
		if (postalCode == null || postalCode.trim().isEmpty()) {
			throw new Exception("Postal code is null or empty");
		}
		
		if (location == null || location.trim().isEmpty()) {
			throw new Exception("Location is null or empty");
		}
		
		Person p = new Person();
		p.setName(name);
		p.setLastName(lastName);
		p.setNif(nif);
		p.setAddress(address);
		p.setPostalCode(postalCode);
		p.setLocation(location);
		personsManager.createPerson(p);
	}
	
	public List<Person> findAllPersons() {
		return personsManager.findAllPersons();
	}
	
}
