package com.github.greboreda.example.web.components;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.web.controllers.PersonsController;

@Import(library = "context:js/utils.js")
public class ShowPersons {
	
	@Inject
	private PersonsController personsController;
	
	@Parameter(required=true)
	@Property
	private List<Person> personsToShow;
	
	@Property
	private Person currentPerson;

	@Property
	private String personsPattern;
	
	@InjectComponent
	private Zone personsZone;

	
	@OnEvent(value=EventConstants.ACTION, component="searchPersonsForm")
	Object searchPersons() {
		personsToShow = personsController.findPersonsByNamePattern(personsPattern);
		return personsZone.getBody();		
	}
	
	
}
