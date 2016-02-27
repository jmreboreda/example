package com.github.greboreda.example.web.components;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.github.greboreda.example.web.controllers.PersonsController;

public class AddPerson {
	
	@Inject
	private PersonsController personsController;
	
	@Property
	private String firstName;
	
	@Property
	private String lastName;

	@InjectComponent("names")
	private Form form;
	
	@InjectComponent("firstName")
	private TextField firstNameField;
	
	@InjectComponent("lastName")
	private TextField lastNameField;
	
	
	void onValidateFromNames() {
		try {
			personsController.createPerson(firstName, lastName);
		} catch (Exception e) {
			form.recordError(firstNameField, "First Name is required.");
			form.recordError(lastNameField, "Lastname is required.");
		}
	}
}
