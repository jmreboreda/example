package com.github.greboreda.example.web.components;

import java.util.List;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;

public class Telephones {
	
	@Property
	@Parameter(required=true)
	private Long personId;
	
	@Property
	@Parameter(required=true)
	private List<Telephone> telephones;

	@Property
	private Person person;
	
	@Property
	private ShowTelephones telephonesToShow;
			
}
