package com.adaming.myapp.service;

import com.adaming.myapp.dao.impl.EquipeDaoImpl;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Tournois;

public class EquipeService implements IEquipeService {

	
	EquipeDaoImpl impl = new EquipeDaoImpl();
	
	@Override
	public void InitializationEquipe() {
		CreateEquipe("France");
		CreateEquipe("Angleterre");
		CreateEquipe("Espagne");
		CreateEquipe("Italie");
		CreateEquipe("Allemagne");
		CreateEquipe("Portugal");
		CreateEquipe("Bosnie");
		CreateEquipe("Pays-Bas");
		CreateEquipe("USA");
		CreateEquipe("Canada");
		CreateEquipe("Mexique");
		CreateEquipe("Brésil");
		CreateEquipe("Argentine");
		CreateEquipe("Chili");
		CreateEquipe("Paraguay");
		CreateEquipe("Perou");
		CreateEquipe("Chine");
		CreateEquipe("Japon");
		CreateEquipe("Corée");
		CreateEquipe("Australie");
		CreateEquipe("Russie");
		CreateEquipe("Nouvelle Zélande");
		CreateEquipe("Inde");
		CreateEquipe("Thailande");
		CreateEquipe("Cameroun");
		CreateEquipe("Nigeria");
		CreateEquipe("Algerie");
		CreateEquipe("Ghana");
		CreateEquipe("Namibie");
		CreateEquipe("Egypte");
		CreateEquipe("Sénégal");
		CreateEquipe("Afrique du Sud");
		
	}

	@Override
	public Equipe CreateEquipe(String nom) {
		
		return impl.CreateEquipe(nom);
	}

	@Override
	public Equipe getOne(String nom) {
		
		return impl.getOne(nom);
	}

	@Override
	public void getAll() {
		impl.getAll();
		
	}

	@Override
	public Equipe EliminerEquipe(String nom) {
		
		return impl.EliminerEquipe(nom);
	}

	@Override
	public Equipe UpdateEquipe(Integer id, String nom, Boolean pays,
			Boolean encore, Tournois t) {
		
		return impl.UpdateEquipe(id, nom, pays, t);
	}

}
