package com.adaming.myapp.service.client;



import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.client.IClientDao;
import com.adaming.myapp.entities.Client;

@Transactional
public class ClientServiceImpl implements IClientService{
    
	private IClientDao dao;

	
	public void setDao(IClientDao dao) {
		this.dao = dao;
		System.out.println("<----dao client injected---->");
	}

	@Override
	public Client createClient(Client c) {
		// TODO Auto-generated method stub
		return dao.create(c);
	}

	@Override
	public Client getOneClient(Long id) {
		// TODO Auto-generated method stub
		return dao.getOne(id);
	}

	@Override
	public void deleteClient(Long id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Client updateClient(Client c) {
		// TODO Auto-generated method stub
		return dao.update(c);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
