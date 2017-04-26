package com.adaming.myapp.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;

import com.adaming.myapp.dao.ITournoisDao;
import com.adaming.myapp.dao.singleton.SingletonHibernate;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Tournois;
import com.adaming.myapp.entities.TournoisMondial;

public class TournoisDaoImpl implements ITournoisDao{

	Session s = SingletonHibernate.getSession();
	EquipeDaoImpl impl = new EquipeDaoImpl();
	
	@Override
	public Tournois CreateTournoisQualif(String nom,String paysHote, String nomEquipe1,
			String nomEquipe2, String nomEquipe3, String nomEquipe4,
			String nomEquipe5, String nomEquipe6, String nomEquipe7,
			String nomEquipe8) {
		Tournois t = new Tournois(nom, paysHote);
		List<Equipe> lesequipes = new ArrayList<Equipe>();
		Equipe e1 = impl.getOne(nomEquipe1);
		Equipe e2 = impl.getOne(nomEquipe2);
		Equipe e3 = impl.getOne(nomEquipe3);
		Equipe e4 = impl.getOne(nomEquipe4);
		Equipe e5 = impl.getOne(nomEquipe5);
		Equipe e6 = impl.getOne(nomEquipe6);
		Equipe e7 = impl.getOne(nomEquipe7);
		Equipe e8 = impl.getOne(nomEquipe8);
		lesequipes.add(e1);
		lesequipes.add(e2);
		lesequipes.add(e3);
		lesequipes.add(e4);
		lesequipes.add(e5);
		lesequipes.add(e6);
		lesequipes.add(e7);
		lesequipes.add(e8);
		t.setEquipes(lesequipes);
		s.beginTransaction();
		s.save(t);
		s.getTransaction().commit();
		return t;
	}

	@Override
	public TournoisMondial CreateCDM() {
		TournoisMondial CDM = new TournoisMondial();
		List<Equipe> tampon = new ArrayList<Equipe>();
		Query query = s.createQuery("from Equipe where EncoreEnLice=1");
		tampon = query.list();
		CDM.setEquipes(tampon);
		s.beginTransaction();
		s.save(CDM);
		s.getTransaction().commit();
		
		return CDM;
	}



}
