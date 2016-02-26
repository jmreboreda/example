package com.github.greboreda.example.web.components;

import java.util.List;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;

import com.github.greboreda.example.model.person.Person;

public class ShowPersons {
	
	@Parameter(required=true)
	@Property
	private List<Person> personsToShow;
	
	@Property
	private Person currentPerson;
		
}
