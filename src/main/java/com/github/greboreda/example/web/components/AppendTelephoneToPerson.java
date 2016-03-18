package com.github.greboreda.example.web.components;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.PageActivationContext;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.services.PersonsManager;
import com.github.greboreda.example.web.controllers.PersonsController;

public class AppendTelephoneToPerson {
	
	@Inject
	private PersonsController personsController;
	
	@Inject
	private PageRenderLinkSource pageRenderLS;
	
	@PageActivationContext
	@Property
	private String personId;

	@Property
	Person person;
	
	@Parameter(required=true)
	@Property
	Long personToAppend;
	
	@Property
	Telephone telephone;
	
	@Property
	String newPhoneNumber;
	
	@OnEvent(value=EventConstants.ACTION, component="addPhoneForm")
	void addTelephone() throws Exception {
		personsController.newTelephoneAtPersonId(personId, newPhoneNumber);
	}
}
