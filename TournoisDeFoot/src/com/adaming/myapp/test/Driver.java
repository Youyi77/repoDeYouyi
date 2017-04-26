package com.adaming.myapp.test;

import java.util.Scanner;

import com.adaming.myapp.dao.impl.EquipeDaoImpl;
import com.adaming.myapp.dao.singleton.SingletonHibernate;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.service.EquipeService;
import com.adaming.myapp.service.TournoisService;

public class Driver {
	public static void main(String[] args) {
		EquipeService equipeimpl = new EquipeService();
		TournoisService tournoisimpl = new TournoisService();
		Scanner clavier = new Scanner(System.in);
		
		
		equipeimpl.InitializationEquipe();
		tournoisimpl.InitialisationTournois();
		//System.out.println("Prêts pour l'aventure?");
		//String mot1=clavier.nextLine();
		tournoisimpl.JouerTousLesTournois();
		
		//System.out.println("Prêts pour le mondial?");
		//String mot2=clavier.nextLine();
		tournoisimpl.JouerCDM();
		
		
		SingletonHibernate.getSession().close();
		SingletonHibernate.getSessionFactory().close();
		
	}

}
