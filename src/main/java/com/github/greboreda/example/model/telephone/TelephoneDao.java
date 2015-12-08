package com.github.greboreda.example.model.telephone;

import java.util.List;

import com.github.greboreda.example.model.dao.GenericDao;

public interface TelephoneDao extends GenericDao<TelephoneVO,Long> {

	public List<TelephoneVO> findTelephonesByPersonId(Long personId);	
}
