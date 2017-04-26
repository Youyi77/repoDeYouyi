package com.adaming.myapp.service;

import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Tournois;

public interface IEquipeService {
	
	void InitializationEquipe();
	Equipe CreateEquipe(String nom);
	Equipe getOne(String nom);
	void getAll();
	Equipe EliminerEquipe(String nom);
	Equipe UpdateEquipe(Integer id, String nom, Boolean pays, Boolean encore, Tournois t);

}
