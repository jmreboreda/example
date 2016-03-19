package com.github.greboreda.example.web.pages;

import org.apache.tapestry5.annotations.Property;

public class AppendTelephone {
	
	@Property
	String newTelephone;

	void beginRender() {
		newTelephone = null;    	
	}
}
