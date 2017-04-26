package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IClientDao {
	Client AddClient(Client c);
	Voiture AddVoiture(Voiture v);
	Reservation addReservation(Reservation r);
	Client getOneClient(int id);
	Voiture getOneVoiture(int id);
	Reservation getOneReservation(int id);
	List<Client> getAllClient();
	List<Voiture> getAllVoiture();
	List<Reservation> getAllReservation();

}
