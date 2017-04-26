package com.adaming.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.service.client.IClientService;

@RestController
public class ClientRest {
    
	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public Client addClient(@RequestBody Client c){
		return clientService.createClient(c);
	}
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public Client updateClient(@RequestBody Client c){
		return clientService.updateClient(c);
	}
	@RequestMapping(value = "/getOne/{id}",method = RequestMethod.GET)
	public Client getClient(@PathVariable Long id){
		return clientService.getOneClient(id);
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public void deleteClient(@PathVariable Long id){
		clientService.deleteClient(id);
	}
	
	@RequestMapping(value = "/getAll",method = RequestMethod.GET)
	public List<Client> getAll(){
		return clientService.getAllClients();
	}
	
	
}
