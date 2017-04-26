package fr.adaming.myapp;
import java.util.*;
import java.text.*;

public class AppImpl implements ICatalogue{
	
	private ArrayList<Categorie> tabCat=new ArrayList<Categorie>();
	private ArrayList<Produit> tabProd=new ArrayList<Produit>();
	private ArrayList<Client> tabClient=new ArrayList<>();
	private ArrayList<Client> tabClienta=new ArrayList<>();
	private ArrayList<Client> tabClientnona=new ArrayList<>();
	private ArrayList<Achat> tabAchat= new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private Scanner clavier = new Scanner(System.in);
	private Scanner keyb = new Scanner(System.in);

	
	@Override
	public void NvlCat(int id, String nom) {
		tabCat.add(new Categorie(id, nom));
		
	}

	@Override
	public void NvProd(int id, String nom, double prix, int stock, String dateAjout) throws ParseException {
		Produit p1 = new Produit(id, nom, prix, stock, dateAjout);
		p1.setTabIntCat(setCategorie());
		tabProd.add(p1);
		
		System.out.println(tabProd);
	}
	
	@Override
	public Date setDate(String date) throws ParseException {
		Date d=sdf.parse(date);
		return d;
	}

	@Override
	public ArrayList<Categorie> setCategorie() {
		ArrayList<Categorie> tampon = new ArrayList<>();
		int reponse =1;
		do {
			System.out.println("Souhaitez-vous affecter une (autre) catégorie à ce produit? 0. pour quitter");
			reponse = clavier.nextInt();
			if (reponse !=0){
				System.out.println("A quelle catégorie appartient votre produit?");
				clavier.nextLine();
				String mot = clavier.nextLine();
				for (Categorie c:tabCat){
					if (c.getNom().equalsIgnoreCase(mot)){
						tampon.add(c);
					}
				}
			}
		} while (reponse!=0);
		return tampon;
	}
	
	
	
	@Override
	public void Initialisation() {
		NvlCat(1, "Informatique");
		NvlCat(2, "Périphérique");
		NvlCat(3, "Réseau");
		NvlCat(4, "Téléphone");
		System.out.println(tabCat);

	}

	@Override
	public void SupprimerProd(String référence) {
		ArrayList<Produit> tampon1 = new ArrayList<>();
		for (Produit p:tabProd){
			if (p.getNom().equalsIgnoreCase(référence)){
				tampon1.add(p);
			}
		}
		tabProd.removeAll(tampon1);
		System.out.println(tabProd);
	}

	@Override
	public void ModifierProd(Produit p) {
		System.out.println("Souhaitez vous modifier le prix ou le stock?");
		clavier.nextLine();
		String reponse1=clavier.nextLine();
		if (reponse1.equalsIgnoreCase("prix")||reponse1.equalsIgnoreCase("le prix")){
			System.out.println("Entrez le nouveau prix");
			int nvxprix = clavier.nextInt();
			p.setPrix(nvxprix);
			System.out.println("Le prix a été modifié.");
					
		}
		else if (reponse1.equalsIgnoreCase("stock")||reponse1.equalsIgnoreCase("le stock")){
				System.out.println("Le stock actuel est de "+ p.getStock() + " Entrez le nouveau stock");
				int nvxstock = clavier.nextInt();
				p.setStock(nvxstock);
				System.out.println("Le stock a été modifié. Entrez la date d'entrée du nouveau stock");
				String newdate= keyb.nextLine();
				try {
					p.setDateAjout(p.setDate(newdate));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}System.out.println(p);
		System.out.println(tabProd);
		
	}

	@Override
	public Produit RecupereProd(String nom) {
		Produit recup=null;
		for (Produit p:tabProd){
			if (p.getNom().equalsIgnoreCase(nom)){
				recup=p;
			}
		}
			return recup;
	}

	@Override
	public void PgmPrincipal() {
		Initialisation();
		int compteur=1;
		do {
			System.out.println("Que souhaitez-vous faire? 1. Gérer Produit. 2. ajouter categorie. 3. Consulter 4. Gérer les clients 5. Gérer les achats ");
			compteur = clavier.nextInt();
			if (compteur==1){
				System.out.println("Quel opération effectuer sur les produits? 1. Ajouter 2. Supprimer 3. Modifier 4. Consulter");
				int compteur1=clavier.nextInt();
				if (compteur1==1){
					System.out.println("Entrez l'id");
					int id = clavier.nextInt();
					System.out.println("Entrez le nom");
					String lenom=keyb.nextLine();
					System.out.println("Entrez le prix");
					double prix = clavier.nextDouble();	
					System.out.println("Entrez le stock");
					int stock =clavier.nextInt();
					System.out.println("Entrez la date au format jj-mm-aaaa");
					String ladate=keyb.nextLine();
					try {
						NvProd(id, lenom, prix, stock, ladate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Objet ajouté avec succès.");
				}
				else if (compteur1==2){
					System.out.println("Quel produit supprimer?");
					String motsupp=keyb.nextLine();
					SupprimerProd(motsupp);
					System.out.println("Le produit " + motsupp + " a été supprimé.");
				}
				else if (compteur1 ==3){
					System.out.println("Quel produit modifier?");
					String choix = keyb.nextLine();
					ModifierProd(RecupereProd(choix));
				}
				else if (compteur1==4){
					try {
						ChercheProduit();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			else if (compteur==2){
				System.out.println("Entrez l'id de la nouvelle catégorie");
				int idcat=clavier.nextInt();
				System.out.println("Entrez le nom de la nouvelle catégorie");
				String nomcat=keyb.nextLine();
				NvlCat(idcat, nomcat);
				System.out.println("Nouvelle catégorie crée avec succàs. Voici la nouvelle liste :");
				System.out.println(tabCat);
			}
			else if (compteur ==3){
				System.out.println("Que souhaitez-vous consulter? Les catégories ou les produits ou les produits par catégorie?");
				String repaffichage = keyb.nextLine();
				if (repaffichage.equalsIgnoreCase("categorie")||(repaffichage.equalsIgnoreCase("les categories"))){
					AfficherListCat();
				}
				else if (repaffichage.equalsIgnoreCase("produits")||(repaffichage.equalsIgnoreCase("les produits"))){
					AfficherListProd();
				}
				else{
					AfficherProdParCat();
				}
			}
			else if (compteur==4){
				System.out.println("Que souhaitez-vous faire? 1. ajouter client. 2. Consulter liste clients.");
				int reponse6=clavier.nextInt();
				if (reponse6==1){
					AjouterClient();
				}
				else if (reponse6==2){
					System.out.println("Quel liste souhaitez vous consulter?1. Clients abonnés. 2. Clients non abonnés. 3. Tous" );
					int reponse7=clavier.nextInt();
					if (reponse7==1){
						System.out.println(tabClienta);
					}
					else if (reponse7==2){
						System.out.println(tabClientnona);
					}
					else if (reponse7==3){
						System.out.println(tabClient);
					}
				}
			}
			else if (compteur==5){
				System.out.println("Que souhaitez vous faire? 1. Faire un achat 2. Consulter CA");
				int reponse8=clavier.nextInt();
				if (reponse8==1){
					System.out.println("Quel client effectue cet achat?");
					String leclient = keyb.nextLine();
					for (Client c:tabClient){
						if (c.getNom().equalsIgnoreCase(leclient)){
							tabAchat.add(FaireUnAchat(c));
						}
					}
					
				}
				else if (reponse8==2){
					calculerCA();
				}
			}
		
			
		}while (compteur!=0);
		
	}

	@Override
	public void AfficherListProd() {
		System.out.println(tabProd);
		
	}

	@Override
	public void AfficherListCat() {
		System.out.println(tabCat);
		
	}

	@Override
	public void AfficherProdParCat() {
		System.out.println("Quelle catégorie souhaitez-vous consulter?");
		String reponse4=keyb.nextLine();
		ArrayList<Produit> tempprod = new ArrayList<>();
		for (Produit p:tabProd){
			for (Categorie c: p.getTabIntCat()){
				if (c.getNom().equalsIgnoreCase(reponse4)){
					tempprod.add(p);
				}
			}
		}
		System.out.println("Voici les produits appartenant à la catégorie " + reponse4);
		System.out.println(tempprod);
	}

	@Override
	public void AjouterClient() {
		System.out.println("Le client est il abonné ou non?");
		String reponse5=keyb.nextLine();
		if (reponse5.equalsIgnoreCase("oui")){
			System.out.println("Entrez l'id");
			int id=clavier.nextInt();
			System.out.println("Entrez le nom");
			String nom = keyb.nextLine();
			System.out.println("Entrez le prénom");
			String prenom =keyb.nextLine();
			System.out.println("Entrez la date de naissance");
			String dateDeNaissance=keyb.nextLine();
			ArrayList<Client> tampon = new ArrayList<>();
			tampon.add(new ClientAbonne(id, nom, prenom, dateDeNaissance));
			tabClient.addAll(tampon);
			tabClienta.addAll(tampon);
			System.out.println("Le client abonné a été crée avec succès.");
			System.out.println(tabClient);
		}
		else if (reponse5.equalsIgnoreCase("non")){
			System.out.println("Entrez l'id");
			int id=clavier.nextInt();
			System.out.println("Entrez le nom");
			String nom = keyb.nextLine();
			System.out.println("Entrez le prénom");
			String prenom =keyb.nextLine();
			System.out.println("Entrez la date de naissance");
			String dateDeNaissance=keyb.nextLine();
			ArrayList<Client> tampon = new ArrayList<>();
			tampon.add(new Client(id, nom, prenom, dateDeNaissance));
			tabClient.addAll(tampon);
			tabClientnona.addAll(tampon);
			System.out.println("Le client non abonné a été crée avec succès.");
		}
	}

	@Override
	public Achat FaireUnAchat(Client c) {
		System.out.println("Quel produit acheter?");
		String achatprod=keyb.nextLine();
		System.out.println("Combien voulez vous en acheter?");
		int nbprod=clavier.nextInt();
		System.out.println("Entrer la date au format jj-mm-aaaa");
		Date d= null;
		try {
			d = sdf.parse(keyb.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Achat a= new Achat(c,d);
		for (int i=0;i<nbprod;++i){
			for (Produit p:tabProd){
				if (p.getNom().equalsIgnoreCase(achatprod)){
					a.getTabProdInterne().add(p);
					p.setStock(p.getStock()-1);
					if (p.getStock()<0){
						System.out.println("Attention le stock n'est pas suffisant ! Annulation de la transaction");
						p.setStock(p.getStock()+1);
						a.getTabProdInterne().remove(p);
					}
					else{
					System.out.println("le nouveau stock est de " + p.getStock());
						
					}
					
				}
			}
		}
		return a;
	}

	@Override
	public void calculerCA() {
		System.out.println("Pour quelle année souhaitez-vous afficher le CA?");
		int d2=clavier.nextInt();
		double CA=0;
		for (Achat a:tabAchat){
			for (Produit p : a.getTabProdInterne()){
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(a.getD());
				int year = cal.get(Calendar.YEAR);
				if (year==d2){
					CA = CA + a.getC().getCoef()*p.getPrix();
				}
			}
		}
		System.out.println("Pour l'année " + d2 + " votre chiffre d'affaire est de " + CA);
	}

	@Override
	public void ChercheProduit() throws Exception{
		System.out.println("Entrez le mot clé");
		String motcle=keyb.nextLine();
		ArrayList<Produit> tampon = new ArrayList<>();
		for (Produit p:tabProd){
			if (p.getNom().contains(motcle)){
				tampon.add(p);
			}
			
		}
		if (tampon.isEmpty()){
			throw new Exception ("Aucun élément trouvé !");
		}
		System.out.println(tampon);
		
	}

	

	
	
	
}
