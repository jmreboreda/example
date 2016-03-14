package com.github.greboreda.example.web.components;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.web.controllers.PersonsController;

public class Telephones {
	
	@Autowired
	PersonsController personsController;

	@Property
	@Parameter(required=true)
	Long personId;
	
	@Property
	@Parameter(required=true)
	List<Telephone> telephones;

	@Property
	Person person;
	
	@InjectComponent
	ShowTelephones telephonesToShow;
	
	void beginRender() {
		person = personsController.findPersonById(personId);
//		telephones = person.getTelephones();
	}
	
}
