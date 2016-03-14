package com.github.greboreda.example.model.telephone;

import com.github.greboreda.example.model.BusinessObject;

public class Telephone implements BusinessObject {

	private static final long serialVersionUID = -7747663676015130032L;

	private long id;
	private String number;

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

	public String toString() {
		//return ReflectionToStringBuilder.toString(this);
		return this.number;
	}
	
}
