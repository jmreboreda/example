package com.github.greboreda.example.model.mappers;

import com.github.greboreda.example.model.authorization.role.Role;
import com.github.greboreda.example.model.authorization.role.RoleVO;
import com.github.greboreda.example.model.authorization.user.User;
import com.github.greboreda.example.model.authorization.user.UserVO;

public class UserMapper {

	public static User proccessVOBO(UserVO userVO) {
		
		if(userVO == null) return null;
		
		User user = new User();
		user.setId(userVO.getId());
		user.setUsername(userVO.getUsername());
		user.setHashedPassword(userVO.getPassword());
		user.setSalt(userVO.getSalt());
				
		for(RoleVO roleVO : userVO.getRoles()) {
			Role role = Role.fromId(roleVO.getId());
			user.appendRole(role);
		}
	
		return user;
	}
	
	public static UserVO proccessBOVO(User user) {
		return null;
	}
}
