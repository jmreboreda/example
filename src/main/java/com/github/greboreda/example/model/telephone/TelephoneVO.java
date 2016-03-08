package com.github.greboreda.example.model.telephone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.greboreda.example.model.ValueObject;
import com.github.greboreda.example.model.person.PersonVO;

@Entity
@Table(name = "Telephone")
public class TelephoneVO implements ValueObject {

	private static final long serialVersionUID = 3130039446016833439L;

	private long id;	
	private PersonVO person;
	private String number;

	public TelephoneVO() {
		
	}
	
	@Id
	@SequenceGenerator(name="TelephoneIdGenerator", sequenceName="TelephoneIdSequence")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TelephoneIdGenerator")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	@ManyToOne
	@JoinColumn(name = "personId", nullable = false)
	@org.hibernate.annotations.ForeignKey(name = "fk_person")
	public PersonVO getPerson() {
		return person;
	}
	public void setPerson(PersonVO person) {
		this.person = person;
	}

	
}
