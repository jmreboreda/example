package com.github.greboreda.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.greboreda.example.model.authorization.role.RoleDao;
import com.github.greboreda.example.model.authorization.user.User;
import com.github.greboreda.example.model.authorization.user.UserDao;
import com.github.greboreda.example.model.authorization.user.UserVO;
import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;
import com.github.greboreda.example.model.exceptions.modelexceptions.NotFoundException;
import com.github.greboreda.example.model.mappers.UserMapper;

@Service
@Transactional
public class UsersManager {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	public void createUser(User user) {
		UserVO userVO = UserMapper.proccessBOVO(user);
		userDao.create(userVO);
		user.setId(userVO.getId());
	}
	
	public User findByUsername(String username) throws NotFoundException {

		UserVO userVO = null;
		
		try {
			userVO = userDao.findByUsername(username);
		} catch (InstanceNotFoundException e) {
			throw new NotFoundException("username", username, User.class);
		}
		
		User user = UserMapper.proccessVOBO(userVO);
		
		return user;
	}

}
