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

	@InjectComponent("names")
	private Form form;
	
	@InjectComponent("firstName")
	private TextField firstNameField;
	
	
	void onValidateFromNames() {
		try {
			personsController.createPerson(firstName);
		} catch (Exception e) {
			form.recordError(firstNameField, "First Name is required.");
		}
	}
}
