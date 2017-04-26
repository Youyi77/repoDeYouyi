package com.adaming.myapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.singleton.Singleton;

public class ClientImpl implements IClientDao{
	
	Session s = Singleton.getS();
	@Override
	public Client AddClient(Client c) {
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
		return c;
	}

	@Override
	public Voiture AddVoiture(Voiture v) {
		s.beginTransaction();
		s.save(v);
		s.getTransaction().commit();
		return v;
	}

	@Override
	public Reservation addReservation(Reservation r) {
		s.beginTransaction();
		s.save(r);
		s.getTransaction().commit();
		return r;
	}

	@Override
	public Client getOneClient(int id) {
		Client c = s.get(Client.class, id);
		return c;
	}

	@Override
	public Voiture getOneVoiture(int id) {
		Voiture v = s.get(Voiture.class, id);
		return v;
	}

	@Override
	public Reservation getOneReservation(int id) {
		Reservation r = s.get(Reservation.class,id);
		return r;
	}

	@Override
	public List<Client> getAllClient() {
		Query query = s.createQuery("from Client");
		List<Client> clients = query.list();
		return clients;
		
	}

	@Override
	public List<Voiture> getAllVoiture() {
		Query query = s.createQuery("from Voiture");
		List<Voiture> voitures = query.list();
		return voitures;
		
	}

	@Override
	public List<Reservation >getAllReservation() {
		Query query = s.createQuery("from Reservation");
		List<Reservation> reservations = query.list();
		System.out.println(reservations);
		return reservations;
		
	}

}
