package com.github.greboreda.example.model.person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.github.greboreda.example.model.ValueObject;

@Entity
@Table(name = "Person")
public class PersonVO implements ValueObject {

	private static final long serialVersionUID = 8674188501454422360L;
	
	private Long id;
	private String name;
	private String lastName1;
	private String lastName2;
	private String nif;
	
	public PersonVO() {

	}
	
	@Id
	@SequenceGenerator(name="PersonIdGenerator", sequenceName="PersonIdSequence")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PersonIdGenerator")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
}
