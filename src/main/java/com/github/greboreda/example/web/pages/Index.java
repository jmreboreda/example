package com.github.greboreda.example.web.pages;

import java.util.List;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.web.controllers.IndexController;

public class Index {

	//@Inject
	//private Logger logger;
	
    @Property
    private String firstName;

    @InjectComponent("names")
    private Form form;

    @InjectComponent("firstName")
    private TextField firstNameField;
    
    @Inject
    private IndexController indexController;
    
    @Property
    private List<Person> persons;
    
    @Property
    private Person currentPerson;
        
    
    void beginRender() {
    	persons = indexController.findAllPersons();    	
    }
    
    void onValidateFromNames() {
        try {
			indexController.createPerson(firstName);
		} catch (Exception e) {
            form.recordError(firstNameField, "First Name is required.");
		}
        
    }
    
}