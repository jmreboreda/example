package com.github.greboreda.example.model.telephone;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.greboreda.example.model.dao.GenericDaoHibernate;

@Repository("telephoneDao")
@Transactional
public class TelephoneDaoHibernate extends GenericDaoHibernate<TelephoneVO,Long> implements TelephoneDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<TelephoneVO> findTelephonesByPersonId(Long personId) {

		/**
		 * NOTA: Esto nunca se debería hacer así, no se debe preguntarle a la
		 * base de datos por listas arbitrariamente largas ya que puedes hacer
		 * consultas muy costosas.
		 * 
		 * Se debe hacer paginando, es decir, diciéndole in índice y un desplazamiento.
		 * 
		 * Por ahora lo hacemos así por motivos didácticos.
		 */
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select t from TelephoneVO t where t.person.id=:personId");
		query.setParameter("personId", personId);
		
		@SuppressWarnings("unchecked")
		List<TelephoneVO> telephones = (List<TelephoneVO>) query.list();
		
		return telephones;
		
	}

}
