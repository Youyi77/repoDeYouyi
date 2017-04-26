package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.*;

public interface IClientDao {
	Client AddClient(Client c);
	
	Reservation addReservation(Reservation r);
	Client getOneClient(int id);
	Reservation getOneReservation(int id);
	List<Client> getAllClient();
	List<Reservation> getAllReservation();
	Client updateClient(Client c, int id);

}
