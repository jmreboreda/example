package com.github.greboreda.example.security;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.greboreda.example.model.authorization.role.Role;
import com.github.greboreda.example.model.authorization.user.User;
import com.github.greboreda.example.model.exceptions.modelexceptions.NotFoundException;
import com.github.greboreda.example.services.UsersManager;

public class UserRealm extends AuthorizingRealm  {

	//@Autowired
	private UsersManager usersManager;

	private Logger logger = LoggerFactory.getLogger(UserRealm.class);
	
	public UserRealm() {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		this.usersManager = (UsersManager) context.getBean("usersManager");
		
		CredentialsMatcher appCredentialsMatcher = new AppCredentialsMatcher();
		this.setCredentialsMatcher(appCredentialsMatcher);
	}
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		String username = (String) principals.getPrimaryPrincipal();
		
		User user = null;
		
		try {
			user = usersManager.findByUsername(username);
		} catch (NotFoundException e) {
			logger.info("Not found User with username: " + username);
			return null;
		}
		
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		
		Set<String> roles = new HashSet<String>();
		for(Role role : user.getRoles()) {
			roles.add(role.getName());
		}
		
		authorizationInfo.setRoles(roles);
		authorizationInfo.setStringPermissions(user.getPermissions());
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String username = (String) token.getPrincipal();
		
		User user = null;
		
		try {
			user = usersManager.findByUsername(username);
		} catch (NotFoundException e) {
			logger.info("Not found User with username: " + username);
			return null;
		}
		
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				user.getUsername(),
				user.getHashedPassword(),
				ByteSource.Util.bytes(user.getSalt()),
				getName()
		);
		
		return authenticationInfo;
	}


}
