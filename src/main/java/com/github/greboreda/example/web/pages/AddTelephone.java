package com.github.greboreda.example.web.pages;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.web.controllers.PersonsController;
import com.github.greboreda.example.web.controllers.TelephonesController;

public class AddTelephone {
	
	@Inject
	private TelephonesController telephonesController;

	@Inject
	private PersonsController personsController;
	
	@Property
	@Persist
	private Person personToAppendPhone;
		
	@Property
	private String telephoneNumber;
	
	private Logger logger = LoggerFactory.getLogger(AddTelephone.class);
	
	void onActivate(long personId) {
		personToAppendPhone = personsController.findPersonById(personId);
		logger.debug(personToAppendPhone.toString());
	}
		
	@OnEvent(value=EventConstants.VALIDATE, component="addTelephoneForm")
	void appendTelephoneToPerson(){
		logger.debug("personId: " + personToAppendPhone.getId() + " telephoneNumber: " + telephoneNumber);
		try {
			telephonesController.appendTelephoneToPerson(personToAppendPhone, telephoneNumber);
		} catch (Exception e) {
			logger.debug("Número de teléfono: " + telephoneNumber + " -> " + e.toString());
		}
	}
	
	Object onSuccess(){
		return Persons.class;		
	}
}