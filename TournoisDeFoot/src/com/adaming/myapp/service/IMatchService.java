package com.adaming.myapp.service;

import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Match;

public interface IMatchService {
	
	Match CreateMatch(Equipe e1, Equipe e2);
	void JouerMatch(Match m);

}
