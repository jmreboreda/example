package com.github.greboreda.example.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.services.PersonsManager;

@Service
public class TelephonesController {

	@Autowired
	PersonsManager personsManager;

	public void appendTelephoneToPerson(Person person, String telephone) throws Exception{
		
		if (telephone == null || telephone.trim().isEmpty()) {
			throw new Exception("telephone is null or empty");
		}
		
		try{ 
		    @SuppressWarnings("unused")
			int numero = Integer.parseInt(telephone); 
		}catch(NumberFormatException e){ 
			throw new Exception("This is not a telephone number: " + telephone);
		}  
		
		Telephone phone = new Telephone();
		phone.setNumber(telephone);
				
		try {
			personsManager.appendTelephoneToPerson(person, phone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
