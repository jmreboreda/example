package com.github.greboreda.example.security;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.mindrot.jbcrypt.BCrypt;

public class AppCredentialsMatcher implements CredentialsMatcher {

	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;		
		String plainPassword = new String(usernamePasswordToken.getPassword());
		
		String hashedPassword = info.getCredentials().toString();
		
		boolean match = BCrypt.checkpw(plainPassword, hashedPassword);
		
		return match;
	}

}
