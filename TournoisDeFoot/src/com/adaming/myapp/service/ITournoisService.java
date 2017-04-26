package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Tournois;
import com.adaming.myapp.entities.TournoisMondial;

public interface ITournoisService {
	
	void InitialisationTournois();
	Tournois CreateTournoisQualif(String nom,String paysHote, String nomEquipe1, String nomEquipe2, String nomEquipe3, String nomEquipe4 ,String nomEquipe5,
			String nomEquipe6, String nomEquipe7, String nomEquipe8);
	List<Equipe> JouerTournois(Tournois t);
	void JouerTousLesTournois();
	TournoisMondial CreateCDM();
	void JouerCDM();
	

}
