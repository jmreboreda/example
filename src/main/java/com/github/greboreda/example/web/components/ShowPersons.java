package com.github.greboreda.example.web.components;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.web.controllers.PersonsController;

public class ShowPersons {
	
	@Inject
	PersonsController personsController;

	@InjectComponent
	private Zone personsZone;	
	
	@Parameter(required=true)
	@Property
	private List<Person> personsToShow;
	
	@Property
	private Person currentPerson;
	
	Object onChangeSearchPersonsInput() {
		personsToShow = personsController.findPersonsByNamePattern("");
		return personsZone.getBody();
	}
}
