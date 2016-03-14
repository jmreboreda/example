package com.github.greboreda.example.web.components;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import com.github.greboreda.example.model.telephone.Telephone;

public class ShowTelephones {

	@Parameter(required=true)
	@Property
	List<Telephone> telephonesToShow;
	
	@Property
	Telephone telephone;
	
	@Property
	String newPhoneNumber;
	
	@OnEvent(value=EventConstants.ACTION, component="addPhoneButton")
	Object addTelephone() {
		System.out.println("Pulsado botón. Teléfono: " + newPhoneNumber);	
		return null;
	}
}
