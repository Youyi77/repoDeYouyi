package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.adaming.myapp.entities.Voiture;

public class VoitureImpl implements IVoitureDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	private final Logger LOGGER = Logger.getLogger("ClientImpl");

	@Override
	public Voiture AddVoiture(Voiture v) {
		entityManager.persist(v);
		return v;
	}

	@Override
	public Voiture getOneVoiture(int id) {
		Voiture v=entityManager.find(Voiture.class, id);
		return v;
	}

	@Override
	public List<Voiture> getAllVoiture() {
		javax.persistence.Query query = entityManager.createQuery("from Voiture");
		List<Voiture> voitures = query.getResultList();
		return voitures;

	}
	


}
