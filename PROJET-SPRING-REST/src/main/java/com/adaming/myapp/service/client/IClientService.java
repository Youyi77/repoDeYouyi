package com.adaming.myapp.service.client;

import java.util.List;

import com.adaming.myapp.entities.Client;

public interface IClientService {

	Client createClient(Client c);
	
	Client getOneClient(Long id);
	
	void deleteClient(Long id);
	
	Client updateClient(Client c);
	
	List<Client> getAllClients();
	
}
