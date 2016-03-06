package com.github.greboreda.example.web.components;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.tapestry5.annotations.Property;

public class AppLayout {
	
	@Property
	private String username;
		
	void beginRender() {
		Subject currentUser = SecurityUtils.getSubject();
		//username = currentUser.getPrincipal().toString();
		username = "Not user";
	}

	void onActionFromLogout() {
		Subject currentUser = SecurityUtils.getSubject();
		//currentUser.logout();
	}
}
