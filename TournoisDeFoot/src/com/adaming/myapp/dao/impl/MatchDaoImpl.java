package com.adaming.myapp.dao.impl;

import org.hibernate.Session;

import com.adaming.myapp.dao.IMatchDao;
import com.adaming.myapp.dao.singleton.SingletonHibernate;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Match;

public class MatchDaoImpl implements IMatchDao{

	Session s= SingletonHibernate.getSession();
	
	@Override
	public Match CreateMatch(Equipe e1, Equipe e2) {
		s.beginTransaction();
		Match m = new Match(e1,e2);
		s.save(m);
		s.getTransaction().commit();
		
		return m;
	}

}
