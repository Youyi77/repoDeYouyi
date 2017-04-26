package com.adaming.myapp.dao;

import com.adaming.myapp.entities.*;

public interface IEquipeDao {
	
	Equipe CreateEquipe(String nom);
	Equipe getOne(String nom);
	void getAll();
	Equipe EliminerEquipe(String nom);
	Equipe UpdateEquipe(Integer id, String nom, Boolean pays,  Tournois t);

}
