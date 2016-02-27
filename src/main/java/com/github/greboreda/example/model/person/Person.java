package com.github.greboreda.example.model.person;

import java.util.ArrayList;
import java.util.List;

import com.github.greboreda.example.model.BusinessObject;
import com.github.greboreda.example.model.telephone.Telephone;

public class Person implements BusinessObject {

	private static final long serialVersionUID = -3817506926597055935L;

	private Long id;
	private String name;
	private String lastName;
	private List<Telephone> telephones;

	public Person() {
		this.telephones = new ArrayList<Telephone>();
	}
	
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
	
	public void appendTelephone(Telephone telephone) {
		this.telephones.add(telephone);
	}
	
	public List<Telephone> getTelephones() {
		return this.telephones;
	}
	
	
}
