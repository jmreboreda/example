package com.github.greboreda.example.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;
import com.github.greboreda.example.model.mappers.PersonMapper;
import com.github.greboreda.example.model.mappers.TelephonesMapper;
import com.github.greboreda.example.model.person.Person;
import com.github.greboreda.example.model.person.PersonDao;
import com.github.greboreda.example.model.person.PersonVO;
import com.github.greboreda.example.model.telephone.Telephone;
import com.github.greboreda.example.model.telephone.TelephoneDao;
import com.github.greboreda.example.model.telephone.TelephoneVO;

@Service
@Transactional
public class PersonsManager {

	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private TelephoneDao telephoneDao;

	public List<Person> findAllPersons() {
		
		List<Person> persons = personDao.findAllPersons();
		
		for(Person person : persons) {
			List<Telephone> telephones = this.findTelephonesByPersonId(person.getId());
			person.setTelephones(telephones);
		}
		
		return persons;
	}
	
	public Person findPersonById(Long id) {

		PersonVO personVO = null;
		
		try {
			personVO = personDao.find(id);
			
		} catch (InstanceNotFoundException e) {
			return null;
		}	
		
		List<TelephoneVO> telephonesVO = telephoneDao.findTelephonesByPersonId(id);
		
		Person person = PersonMapper.proccessVOBO(personVO, telephonesVO);
		
		return person;

	}
	
	public List<Telephone> findTelephonesByPersonId(Long personId) {
		
		List<TelephoneVO> telephonesVO = telephoneDao.findTelephonesByPersonId(personId);
		
		List<Telephone> telephones = new ArrayList<Telephone>();
		
		for(TelephoneVO telephoneVO : telephonesVO) {
			Telephone telephone = TelephonesMapper.proccessVOBO(telephoneVO);
			telephones.add(telephone);
		}
		
		return telephones;
	}
	
	public void createPerson(Person person) {

		if(person == null) {
			throw new NullPointerException("Person cannot be null");
		}	
		
		PersonVO personVO = PersonMapper.proccessBOVO(person);
		personDao.create(personVO);
				
		if( CollectionUtils.isEmpty(person.getTelephones()) == false ) {
			
			for(Telephone telephone : person.getTelephones()) {
				TelephoneVO telephoneVO = TelephonesMapper.proccessBOVO(telephone, personVO);
				telephoneDao.create(telephoneVO);
			}
			
		}
				
	}
	
	public void appendTelephoneToPerson(Person person, Telephone telephone) throws Exception {
		
		if(person == null) {
			throw new NullPointerException("Person cannot be null");
		}
		
		try {
			PersonVO personVO = personDao.find(person.getId());
			TelephoneVO telephoneVO = TelephonesMapper.proccessBOVO(telephone, personVO);
			telephoneDao.create(telephoneVO);
						
		} catch (InstanceNotFoundException e) {
			//No se debe nunca lanzar Exception pero ya hablaremos de eso
			throw new Exception("Person not found");
		}
	}
	
}
