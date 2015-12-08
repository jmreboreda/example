package com.github.greboreda.example.model.person;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.greboreda.example.model.dao.GenericDaoHibernate;
import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;
import com.github.greboreda.example.model.mappers.PersonMapper;

@Repository("personDao")
@Transactional
public class PersonDaoHibernate extends GenericDaoHibernate<PersonVO,Long> implements PersonDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public PersonVO findPersonByName(String name) throws InstanceNotFoundException {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select p from PersonVO p where p.name=:name");
		query.setParameter("name", name);
		
		PersonVO person = (PersonVO) query.uniqueResult();
		
		if(person == null) {
			throw new InstanceNotFoundException(name, PersonVO.class.getSimpleName());
		}
		
		return person;
	}

	@Override
	public List<Person> findAllPersons() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from PersonVO");
		
		@SuppressWarnings("unchecked")
		List<PersonVO> personsVO = (List<PersonVO>) query.list();
		
		List<Person> persons = new ArrayList<Person>();
		for(PersonVO personVO : personsVO) {
			persons.add(PersonMapper.proccessVOBO(personVO, null));
		}
		
		return persons;
	}

}
