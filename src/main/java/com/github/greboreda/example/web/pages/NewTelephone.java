package com.github.greboreda.example.web.pages;

import org.apache.tapestry5.annotations.Property;

public class NewTelephone {
	
	@Property
	String newTelephone;

	public Object onActivate() {
		return AppendTelephone.class;
	}
}
