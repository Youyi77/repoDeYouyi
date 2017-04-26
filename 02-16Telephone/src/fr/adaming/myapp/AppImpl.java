package fr.adaming.myapp;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppImpl implements IAppareil{

	private ArrayList<Contact> tabContact = new ArrayList<>();
	private ArrayList<Appel> tabAppel = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	@Override
	public int CalculerCout(int duree, int coutMin) {
		int cout=duree*coutMin;
		return cout;
	}
	
	@Override
	public void Ajouter(Contact c) {
		tabContact.add(c);
		
	}
	

	@Override
	public void CheckContactNum(String num) {
		List<Contact> tabtest=new ArrayList<>();
		for (Contact i : tabContact){
			if (i.getNumero().equals(num)){
				tabtest.add(i);
			}
		}
		if (tabtest.isEmpty()){
			System.out.println("Aucun contact trouvé");
		}
		else {System.out.println(tabtest);}
	}
	
	@Override
	public void CheckContactName(String nom) {
		List<Contact> tabtest=new ArrayList<>();
		for (Contact i : tabContact){
			if (i.getNom().contains(nom)){
				tabtest.add(i);
			}
		}
		if (tabtest.isEmpty()){
			System.out.println("Aucun contact trouvé");
		}
		else {System.out.println(tabtest);}
		
	}

	@Override
	public ArrayList<Contact> SeeAllContacts() {
		return tabContact;
	}
	
	@Override
	public ArrayList<Appel> SeeAllAppels() {
		return tabAppel;
	}

	@Override
	public void NouvelAppel(Contact c, Appel a) {
		c.setTabAppel(a);
		tabAppel.add(a);
	
		
	}

	public int CalculCoutContact(Contact c) {
		int w=0;
		for (Appel a:c.getTabAppel()){
			w=w+a.getCoutAppel();
		}
		System.out.println("Pour le contact "+c.getNom()+ " vous avez consommé au total " + w);
		return w;
	}

	@Override
	public int CalculCoutTotal() {
		int w=0;
		for (Contact c:tabContact){
			for (Appel a:c.getTabAppel() ){
				w=w+a.getCoutAppel();
							}
			}
		System.out.println("Vous avez consommé un total de "+w);
		return w;
	}

	@Override
	public int CalculCoutDate(Date d1, Date d2) {
		int w=0;
		for (Appel a:tabAppel){
			if (a.getDate().after(d1)&& a.getDate().before(d2)){
				w=w+a.getCoutAppel();
			}
		}
		System.out.println("Entre le " + sdf.format(d1) + " et le " + sdf.format(d2) +" vous avez consommé "+ w);
		return w;
	}



	

}
