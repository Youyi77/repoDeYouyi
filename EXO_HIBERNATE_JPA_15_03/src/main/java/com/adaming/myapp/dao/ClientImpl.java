package com.adaming.myapp.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

public class ClientImpl implements IClientDao {

	@PersistenceContext
	private EntityManager entityManager;
	private final Logger LOGGER = Logger.getLogger("ClientImpl");

	@Override
	public Client AddClient(Client c) {
		entityManager.persist(c);
		return c;
	}



	@Override
	public Reservation addReservation(Reservation r) {
		Client c= r.getClient();
		Voiture v=r.getVoiture();
		c.getVoitures().add(v);
		entityManager.merge(c);
		entityManager.persist(r);
		return r;
	}

	@Override
	public Client getOneClient(int id) {
		Client c=entityManager.find(Client.class, id);
		return c;
	}



	@Override
	public Reservation getOneReservation(int id) {
		Reservation r=entityManager.find(Reservation.class, id);
		return r;
	}

	@Override
	public List<Client> getAllClient() {
		javax.persistence.Query query = entityManager.createQuery("from Client");
		List<Client> clients = query.getResultList();
		return clients;

	}



	@Override
	public List<Reservation> getAllReservation() {
		javax.persistence.Query query = entityManager.createQuery("from Reservation");
		List<Reservation> reservations = query.getResultList();
		return reservations;

	}



	@Override
	public Client updateClient(Client c,int id) {
		c.setIdClient(id);
		entityManager.merge(c);
		return null;
	}

}
