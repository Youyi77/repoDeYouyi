package com.adaming.myapp.service;

import java.util.Date;
import java.util.List;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;

public interface IServiceClient {
	Client AddClient(Client c) throws Exception;
	Voiture AddVoiture(Voiture v);
	Reservation addReservation(Reservation r) throws ClientNotFoundException;
	Client getOneClient(int id);
	Voiture getOneVoiture(int id);
	Reservation getOneReservation(int id);
	List<Client> getAllClient();
	List<Voiture> getAllVoiture();
	List<Reservation> getAllReservation();
	List<Voiture> DispoVoiture(Date debut, Date fin);

}
