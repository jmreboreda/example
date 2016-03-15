package com.github.greboreda.example.web.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;

public class AppendTelephoneToPerson {

	@Property
	Person person;
	
	@Property
	String personToAppend;
	
	@Property
	Telephone telephone;
	
	@Property
	String newPhoneNumber;
	
	@OnEvent(value=EventConstants.ACTION, component="addPhoneForm")
	Object addTelephone() {
		System.out.println("Pulsado botón. Teléfono: " + newPhoneNumber + " de la persona: " + personToAppend);	
		return null;
	}
}
