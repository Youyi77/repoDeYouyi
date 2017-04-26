package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Voiture;

public interface IVoitureService {
	
	Voiture AddVoiture(Voiture v);
	Voiture getOneVoiture(int id);
	List<Voiture> getAllVoiture();

}
