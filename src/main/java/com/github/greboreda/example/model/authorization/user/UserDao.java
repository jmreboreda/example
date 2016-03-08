package com.github.greboreda.example.model.authorization.user;

import com.github.greboreda.example.model.dao.GenericDao;
import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;

public interface UserDao extends GenericDao<UserVO, Long> {

	UserVO findByUsername(String username) throws InstanceNotFoundException;
}
