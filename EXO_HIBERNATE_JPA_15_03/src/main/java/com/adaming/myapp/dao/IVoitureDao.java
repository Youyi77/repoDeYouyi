package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.Voiture;

public interface IVoitureDao {
	
	Voiture AddVoiture(Voiture v);
	Voiture getOneVoiture(int id);
	List<Voiture> getAllVoiture();

}
