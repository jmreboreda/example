package com.github.greboreda.example.web.pages;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.web.controllers.IndexController;

public class Index {

	@Inject
	private Logger logger;
	
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
    
    private Person personToAddPhone;
    
    private Long personIdToAddPhone;
    
    @Property
    private int personsIndex;
    
    @Property
    private Telephone telephone;
        
    @Property
    private String personPhone;
    
    void onActivate() {
    	//persons = indexController.findAllPersons();
    }
    
    void beginRender() {
    	persons = indexController.findAllPersons();    	
    }
    
    void onValidateFromNames() {
        if (firstName == null || firstName.trim().equals("")) {
            form.recordError(firstNameField, "First Name is required.");
        }
        indexController.createPerson(firstName);
    }
    
    /*
    void onSelectedFromAddPhone(Person p) {
    	personToAddPhone = p;
    }
    void onSelectedFromAddPhone(Long id) {
    	personIdToAddPhone = id;
    }
	*/
    void onSelectedFromAddPhone(EventContext context) {
    	
    	StringBuilder builder = new StringBuilder();
    	for(String s : context.toStrings()) {
    	    builder.append(s + ", ");
    	}
		logger.debug("Context: " + builder.toString());
		logger.debug("CurrentPerson: " + currentPerson);
		logger.debug("personsIndex: " + personsIndex);
    }

    void onValidateFromPhones() {
    	//indexController.appendTelephoneToPerson(personToAddPhone, personPhone)
    	//indexController.appendTelephoneToPersonByPersonId(personIdToAddPhone, personPhone);
    }  
    
    /*
    Object onSuccess() {
    	return Index.class;
    }
    */
    
}