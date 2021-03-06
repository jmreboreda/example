package com.github.greboreda.example.model.person;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.github.greboreda.example.model.BusinessObject;
import com.github.greboreda.example.model.telephone.Telephone;

public class Person implements BusinessObject {

	private static final long serialVersionUID = -3817506926597055935L;

	private Long id;
	private String name;
	private String lastName1;
	private String lastName2;
	private String nif;
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

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName) {
		this.lastName1 = lastName;
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

	public void setTelephones(List<Telephone> telephones) {
		this.telephones = telephones;
	}
	
	public void appendTelephone(Telephone telephone) {
		this.telephones.add(telephone);
	}
	
	public List<Telephone> getTelephones() {
		return this.telephones;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
