package fr.adaming.myapp;
import java.util.*;
import java.text.*;

public class Test {

	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	IAppareil impl = new AppImpl();
	Scanner clavier = new Scanner(System.in);
	/*
	Contact remi=new Contact(1, "Rémi Garip", "0642184882");
	impl.Ajouter(remi);
	Contact jean=new Contact(1, "Jean Breton", "0642184883");
	impl.Ajouter(jean);
	
	

		Appel app1 = new AppelEmis(1,sdf.parse("10-02-2017 10:12:56"), 1);
		Appel app2=new AppelEmis(2,sdf.parse("11-02-2017 10:12:56"), 1);
		Appel app3=new AppelEmis(2,sdf.parse("12-02-2017 10:12:56"), 1);
		Appel app4=new AppelEmis(2,sdf.parse("13-02-2017 10:12:56"), 1);
		Appel app5=new AppelEmis(2,sdf.parse("14-02-2017 10:12:56"), 1);
		//System.out.println(sdf.format(app2.getDate()));
		

		
		
		impl.SeeAllContacts();
		impl.NouvelAppel(remi, app1);
		impl.NouvelAppel(remi, app2);
		impl.NouvelAppel(remi, app3);
		impl.NouvelAppel(remi, app4);
		impl.NouvelAppel(remi, app5);
		System.out.println(remi.getTabAppel());
		impl.CalculCoutContact(remi);
		impl.CalculCoutTotal();
		impl.CalculCoutDate(sdf.parse("13-02-2017 10:12:56"), sdf.parse("20-02-2017 10:12:56"));
		
		*/
	public void ProjetFinal()throws ParseException {{
	int compteurglobal = 0;
	do {
			System.out.println("Que souhaitez vous faire? 1. Gérer contacts. 2. Gérer appels. 3. Suivre vos dépenses. 4. Quitter");
			int k=0;
			do {
				k=clavier.nextInt();
				if (k<1 || k>4){
					System.out.println("Veuillez entre un nombre entre 1 et 4 !");
				}
			} while (k<1 || k>4);
			
			if (k==4){
				compteurglobal=100;
			}
			
			
			
			
			
			else if (k==1){
				System.out.println("Que souhaitez vous faire? 1. Ajouter un contact. 2.Voir les contacts 3. Chercher un contact.");
				int k2=0;
				do {
					k2=clavier.nextInt();
						if (k2<1 || k2>3){
							System.out.println("Veuillez entre un nombre entre 1 et 3 !");
						}
					} while (k2<1 || k2>3);
				if (k2==1){
					System.out.println("Veuillez entrer un id");
					int id=clavier.nextInt();
					clavier.nextLine();
					System.out.println("Veuillez entrer un nom");
					String nom=clavier.nextLine();
					System.out.println("Veuillez entrez le numéro");
					String num=clavier.nextLine();
					impl.Ajouter(new Contact(id, nom, num));
					
				}
				else if (k2==2){
					System.out.println(impl.SeeAllContacts());
				}
			
				else if (k2==3){
					System.out.println("Comment souhaitez-vous procéder? 1.Par nom. 2. Par numéro");
					int k3=0;
					do{
						k3=clavier.nextInt();
						if (k3<1 || k3>2){
							System.out.println("Veuillez entre un nombre entre 1 et 2 !");
						}
						
					}while (k3<1 || k3>2);
					clavier.nextLine();
					String lenom = clavier.nextLine();
					if (k3==1){
						impl.CheckContactName(lenom);
					}
					else if (k3==2){
						impl.CheckContactNum(lenom);
					}
					
				}
			
				
				
				
				
			}
			else if (k==2){
				System.out.println("Que voulez-vous faire? 1. Créer un appel. 2.Voir votre historique.");
				clavier.nextLine();
				int k2=0;
				do {
					k2=clavier.nextInt();
					if (k2<1 || k2>2) {
						System.out.println("Veuillez entre un nombre entre 1 et 2 !");
					}
				}while (k2<1 || k2>2);
				clavier.nextLine();
				if (k2==1){
					System.out.println("Quel type d'appel? 1. Emis  2. Recu");
					int typeAppel=clavier.nextInt();
					System.out.println("Qui souhaitez vous appeler? Taper son numéro id");
					int idcheck =clavier.nextInt();
					ArrayList<Contact> tabContact=impl.SeeAllContacts();
					Contact c=new Contact();
					for (Contact i:tabContact){
						if (i.getId()==idcheck){
							c=i;
						}
					}
					
					System.out.println("Entrez le num de l'appel");
					int id=clavier.nextInt();
					System.out.println("Entrez une durée (en secondes)");
					int duree=clavier.nextInt();
					clavier.nextLine();
					System.out.println("Entrez une date au format jj-mm-aaaa hh:mm:ss");
					Date d= sdf.parse(clavier.nextLine());
					if (typeAppel==1){
						impl.NouvelAppel(c, new AppelEmis(id, d, duree));
						
					}
					else if (typeAppel==2){
						impl.NouvelAppel(c, new AppelRecu(id,d,duree));
					}
				}
				else if (k2==2){
				System.out.println(impl.SeeAllAppels());
				}
				
			}
			
			else if (k==3){
				System.out.println("Que voulez vous faire? 1. Voir dépense totale. 2. Voir la dépense d'un contact. 3.Voir la dépense par date.");
				int k2=0;
				do {
					k2=clavier.nextInt();
					if (k2<1 || k2>3){
						System.out.println("Veuillez entrer un nom entre 1 et 3 !");
					}
				} while (k2<1 || k2>3);
				//Debut du code
				if (k2==1){
					impl.CalculCoutTotal();
					
				}
				else if (k2==2){
					System.out.println("Pour quel contact souhaitez vous connaître les dépenses? (Entrez son id)");
					clavier.nextLine();
					int idcheck=clavier.nextInt();
					ArrayList<Contact> tabContact=impl.SeeAllContacts();
					Contact c=new Contact();
					for (Contact i:tabContact){
						if (i.getId()==idcheck){
							c=i;
						}
					}
					impl.CalculCoutContact(c);
				}
				else if (k2==3){
					clavier.nextLine();
					System.out.println("Entrez la première date la plus ancienne au format jj-mm-aaaa hh:mm:ss");
					Date d1= sdf.parse(clavier.nextLine());
					System.out.println("Entrez la deuxième date la plus récente au format jj-mm-aaaa hh:mm:ss ");
					Date d2= sdf.parse(clavier.nextLine());
					impl.CalculCoutDate(d1, d2);
				} //Fin du code
			}
			
			
			
		} while (compteurglobal==0);
		
		
		
		
		
		
		
		
	
	}
	
	
	
	
	
	
	
}
}
