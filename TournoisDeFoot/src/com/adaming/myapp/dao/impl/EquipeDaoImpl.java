package com.adaming.myapp.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.adaming.myapp.dao.IEquipeDao;
import com.adaming.myapp.dao.singleton.SingletonHibernate;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Tournois;


public class EquipeDaoImpl implements IEquipeDao{

	Session s = SingletonHibernate.getSession();
	
	
	@Override
	public Equipe CreateEquipe(String nom) {
		Equipe e = new Equipe(nom);
		s.beginTransaction();
		s.save(e);
		s.getTransaction().commit();
		return e;
	}

	@Override
	public Equipe getOne(String nom) {
		Query query = s.createQuery("from Equipe where nom like:x");
		query.setParameter("x", "%"+nom+"%");
		List<Equipe> tampon = new ArrayList<Equipe>();
		tampon = query.list();
		Equipe e=null;
		for (Equipe p:tampon){
			e=p;
		}
		
		return e;
	}

	@Override
	public void getAll() {
		Query query =s.createQuery("from Equipe");
		System.out.println("Voici la liste des équipes participantes !");
		System.out.println(query.list());
		
	}

	@Override
	public Equipe EliminerEquipe(String nom) {
		Equipe e= getOne(nom);
		e.setEncoreEnLice(false);
		s.beginTransaction();
		s.update(e);
		s.getTransaction().commit();
		return e;
	}

	@Override
	public Equipe UpdateEquipe(Integer id, String nom, Boolean pays, Tournois t) {
		Equipe e= getOne(nom);
		e.setNom(nom);
		e.setPaysOrganisateur(pays);
		e.setTournois(t);
		s.beginTransaction();
		s.update(e);
		s.getTransaction().commit();
		return e;
	}



}
