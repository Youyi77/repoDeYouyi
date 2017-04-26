package com.adaming.myapp.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.dao.IVoitureDao;
import com.adaming.myapp.entities.Voiture;

public class VoitureServiceImpl implements IVoitureService {
	
	private EntityManager entityManager;
	private IVoitureDao daov;
	private final Logger LOGGER =Logger.getLogger("ServiceClientImpl");
	
	
	
	/**
	 * @param daov the daov to set
	 */
	public void setDaov(IVoitureDao daov) {
		this.daov = daov;
	}


	
	
	
	
	
	@Override
	@Transactional(readOnly=false)
	public Voiture AddVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return daov.AddVoiture(v);
	}
	
	@Override
	public Voiture getOneVoiture(int id) {
		// TODO Auto-generated method stub
		return daov.getOneVoiture(id);
	}
	
	@Override
	public List<Voiture> getAllVoiture() {
		// TODO Auto-generated method stub
		return daov.getAllVoiture();
	}
	
	

}
