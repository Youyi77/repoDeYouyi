package fr.adaming.myapp;
import java.util.*;

public interface IAppareil {

	int CalculerCout(int duree, int coutMin);
	void Ajouter(Contact c);
	ArrayList<Contact> SeeAllContacts();
	ArrayList<Appel> SeeAllAppels();
	void CheckContactNum(String num);
	void CheckContactName(String nom);
	void NouvelAppel(Contact c, Appel a);
	int CalculCoutContact(Contact c);
	int CalculCoutTotal();
	int CalculCoutDate(Date d1, Date d2);
}
