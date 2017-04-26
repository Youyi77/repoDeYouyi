package com.adaming.myapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

import com.adaming.myapp.dao.impl.EquipeDaoImpl;
import com.adaming.myapp.dao.impl.TournoisDaoImpl;
import com.adaming.myapp.dao.singleton.SingletonHibernate;
import com.adaming.myapp.entities.Equipe;
import com.adaming.myapp.entities.Match;
import com.adaming.myapp.entities.Tournois;
import com.adaming.myapp.entities.TournoisMondial;

public class TournoisService implements ITournoisService{
	
	TournoisDaoImpl tourImpl = new TournoisDaoImpl();
	EquipeDaoImpl equipeImpl = new EquipeDaoImpl();
	MatchService matchImpl = new MatchService();
	Session s = SingletonHibernate.getSession();
	Scanner clavier = new Scanner(System.in);
	
	
	@Override
	public void InitialisationTournois() {
		CreateTournoisQualif("Coupe d'Afrique des Nations","Afrique du Sud", "Egypte", "Cameroun", "Ghana", "Algerie", "Afrique du Sud", "Nigeria", "Namibie", "Sénégal");
		CreateTournoisQualif("Euro de Football", "France", "France", "Angleterre", "Allemagne", "Pays-Bas", "Espagne", "Portugal", "Italie", "Bosnie");
		CreateTournoisQualif("Coupe d'Asie","Corée", "Chine", "Japon", "Corée", "Nouvelle Zélande", "Inde", "Russie", "Australie", "Thailande");
		CreateTournoisQualif("America Cup","Brésil", "USA", "Canada", "Mexique", "Brésil", "Argentine", "Paraguay", "Chili", "Pérou");
	}

	@Override
	public Tournois CreateTournoisQualif(String nom,String paysHote, String nomEquipe1,
			String nomEquipe2, String nomEquipe3, String nomEquipe4,
			String nomEquipe5, String nomEquipe6, String nomEquipe7,
			String nomEquipe8) {
		Tournois t = tourImpl.CreateTournoisQualif(nom, paysHote, nomEquipe1, nomEquipe2, nomEquipe3, nomEquipe4, nomEquipe5, nomEquipe6, nomEquipe7, nomEquipe8);
		Equipe e1 = equipeImpl.getOne(nomEquipe1);
		Equipe e2 = equipeImpl.getOne(nomEquipe2);
		Equipe e3 = equipeImpl.getOne(nomEquipe3);
		Equipe e4 = equipeImpl.getOne(nomEquipe4);
		Equipe e5 = equipeImpl.getOne(nomEquipe5);
		Equipe e6 = equipeImpl.getOne(nomEquipe6);
		Equipe e7 = equipeImpl.getOne(nomEquipe7);
		Equipe e8 = equipeImpl.getOne(nomEquipe8);
		List<Equipe> tampon = new ArrayList<Equipe>();
		tampon.add(e1);
		tampon.add(e2);
		tampon.add(e3);
		tampon.add(e4);
		tampon.add(e5);
		tampon.add(e6);
		tampon.add(e7);
		tampon.add(e8);
		for (Equipe e:tampon){
			Integer id= e.getId();
			String lenom = e.getNom();
			if (e.getNom().equalsIgnoreCase(paysHote)){					
				equipeImpl.UpdateEquipe(id, lenom, true, t);
				}
			else {
				equipeImpl.UpdateEquipe(id, lenom, false, t);
			}
		}
		return t;
	}

	@Override
	public List<Equipe> JouerTournois(Tournois t) {
		List<Equipe> equipes =new ArrayList<Equipe>();
		equipes = t.getEquipes();
		Collections.shuffle(equipes);
		int i =0;
		List<Equipe> tampon = new ArrayList<Equipe>();
		for (Equipe e:equipes){
			++i;
			if (i>4){
				tampon.add(e);
			}			
		}
		for (Equipe e : tampon){
			String nomequipe = e.getNom();
			equipeImpl.EliminerEquipe(nomequipe);
		}
		return null;
	}

	@Override
	public void JouerTousLesTournois() {
		Tournois t1 = s.get(Tournois.class,1);
		Tournois t2 = s.get(Tournois.class,2);
		Tournois t3 = s.get(Tournois.class,3);
		Tournois t4 = s.get(Tournois.class,4);
		JouerTournois(t1);
		JouerTournois(t2);
		JouerTournois(t3);
		JouerTournois(t4);
		
	}

	@Override
	public TournoisMondial CreateCDM() {

		return tourImpl.CreateCDM();
	}

	@Override
	public void JouerCDM() {
		CreateCDM();
		TournoisMondial CDM= s.get(TournoisMondial.class, 1);
		List<Equipe> tampon = new ArrayList<Equipe>();
		tampon = CDM.getEquipes();
		Collections.shuffle(tampon);
		int i=0;
		Equipe e1 =null;
		Equipe e2=null;
		for (Equipe e:tampon) {
			++i;
			if (i==1){
				//System.out.println("L'équipe de " + e.getNom()+ " remporte cette édition !");
				e1=e;
			}
			else if (i==2){
				//System.out.println("L'équipe de " + e.getNom()+ " fini deuxième !");
				e2=e;
			}
			else if (i==3){
				System.out.println("L'équipe de " + e.getNom()+ " fini troisième !");
			}	
			
		}
		//System.out.println("Prêts pour la finale?");
		//String mot3=clavier.nextLine();
		Match m = matchImpl.CreateMatch(e1, e2);
		matchImpl.JouerMatch(m);
		
	}

}
