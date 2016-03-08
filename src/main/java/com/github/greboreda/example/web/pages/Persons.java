package com.github.greboreda.example.web.pages;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.web.components.AddPerson;
import com.github.greboreda.example.web.components.ShowPersons;
import com.github.greboreda.example.web.controllers.PersonsController;

@RequiresRoles("user")
public class Persons {
	
	@Inject
	private PersonsController personsController;
	
	@InjectComponent
	private AddPerson addPerson;

	@InjectComponent
	private ShowPersons showPersons;
	
	@Property
	List<Person> persons;
	
	void beginRender() {
		persons = personsController.findAllPersons();    	
	}
}
