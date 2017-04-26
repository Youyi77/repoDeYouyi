package fr.adaming.myapp;
import java.util.*;
import java.text.ParseException;

public interface ICatalogue {
	
	void NvlCat(int id, String nom);
	void NvProd(int id, String nom, double prix, int stock, String dateAjout)throws ParseException;
	void Initialisation();
	Date setDate(String date) throws Exception;
	ArrayList<Categorie> setCategorie();
	void SupprimerProd(String référence);
	void ModifierProd(Produit p);
	Produit RecupereProd(String nom);
	void PgmPrincipal();
	void AfficherListProd();
	void AfficherListCat();
	void AfficherProdParCat();
	void AjouterClient();
	Achat FaireUnAchat(Client c);
	void calculerCA();
	void ChercheProduit() throws Exception;
}
