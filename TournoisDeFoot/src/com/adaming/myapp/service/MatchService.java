package com.adaming.myapp.service;

import java.util.Random;

import com.adaming.myapp.dao.IMatchDao;
import com.adaming.myapp.dao.impl.MatchDaoImpl;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Match;

public class MatchService implements IMatchService{

	IMatchDao impl = new MatchDaoImpl();
	
	@Override
	public Match CreateMatch(Equipe e1, Equipe e2) {
		
		return impl.CreateMatch(e1, e2);
	}

	@Override
	public void JouerMatch(Match m) {
		Equipe e1 = m.getEquipe1();
		Equipe e2=m.getEquipe2();
		int score1=0;
		int score2=0;
		int tampon=0;
		Random r = new Random();
		do {
			tampon = r.nextInt(100);
			if (tampon>33){
				score1++;
			}
		}while (tampon>33);
		do {
			tampon = r.nextInt(100);
			if (tampon>33){
				score2++;
			}
		}while (tampon>33);
		
		if (score1==score2){
			tampon = r.nextInt()*100;
			if (tampon>49){
				score1++;
				System.out.println("L'équipe " + e1.getNom()+" l'emporte " + score1 + " à " +score2 + " contre "+ e2.getNom()+" après but en or !");
			}
			else {
				score2++;
				System.out.println("L'équipe " + e2.getNom()+" l'emporte " + score2 + " à " +score1 + "contre " + e1.getNom() +" après but en or !");
			}
		}
		else if (score1>score2){
			System.out.println("L'équipe " + e1.getNom()+" l'emporte " + score1 + " à " +score2 + "contre "+ e2.getNom()+" !");
		}
		else {
			System.out.println("L'équipe " + e2.getNom()+" l'emporte " + score2 + " à " +score1 + "contre " + e1.getNom()+" !");
		}
		
	}

}
