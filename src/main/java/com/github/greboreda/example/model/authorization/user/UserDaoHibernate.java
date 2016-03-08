package com.github.greboreda.example.model.authorization.user;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.greboreda.example.model.dao.GenericDaoHibernate;
import com.github.greboreda.example.model.exceptions.daoexceptions.InstanceNotFoundException;

@Repository("userDao")
@Transactional
public class UserDaoHibernate extends GenericDaoHibernate<UserVO, Long> implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public UserVO findByUsername(String username) throws InstanceNotFoundException {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from UserVO u where u.username =:username");
		query.setParameter("username", username);
		
		UserVO userVO = (UserVO) query.uniqueResult();
		
		if(userVO == null) {
			throw new InstanceNotFoundException(username, UserVO.class.getSimpleName());
		}
		
		return userVO;
		
	}

}
