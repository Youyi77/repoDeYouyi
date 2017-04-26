package com.adaming.myapp.dao;

import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Match;

public interface IMatchDao {
	Match CreateMatch(Equipe e1, Equipe e2);
	

}
