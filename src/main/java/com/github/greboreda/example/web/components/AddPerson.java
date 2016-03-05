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
	private String lastName1;
	
	@Property
	private String lastName2;	
	
	@Property
	private String nif;
	
	@Property
	private String address;
	
	@Property
	private String postalCode;
	
	@Property
	private String location;

	@InjectComponent("names")
	private Form form;
	
	@InjectComponent("firstName")
	private TextField firstNameField;
	
	@InjectComponent("lastName1")
	private TextField lastName1Field;
	
	@InjectComponent("lastName2")
	private TextField lastName2Field;
	
	@InjectComponent("nif")
	private TextField nifField;
	
	@InjectComponent("address")
	private TextField addressField;
	
	@InjectComponent("postalCode")
	private TextField postalCodeField;
	
	@InjectComponent("location")
	private TextField locationField;
	
	void onValidateFromNames() {
		try {
			personsController.createPerson(firstName, lastName1, lastName2, nif, address, postalCode, location);
		} catch (Exception e) {
			form.recordError(firstNameField, "First Name is required.");
			form.recordError(lastName1Field, "Lastname1 is required.");
			form.recordError(lastName2Field, "Lastname2 is required.");
			form.recordError(nifField, "NIF is required.");
			form.recordError(addressField, "Address is required.");
			form.recordError(postalCodeField, "Postal code is required.");
			form.recordError(locationField, "Location is required.");
		}
	}
}
