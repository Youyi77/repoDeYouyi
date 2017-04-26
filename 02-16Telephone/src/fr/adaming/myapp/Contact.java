package fr.adaming.myapp;
import java.util.*;
public class Contact {
	
	private int id;
	private String nom;
	private String numero;
	private ArrayList<Appel> tabAppel=new ArrayList<Appel>();
	
	//Constructeur par défaut
	public Contact() {
	}


	//Constructeur paramétré
	public Contact(int id, String nom, String numero) {
		super();
		this.id = id;
		this.nom = nom;
		this.numero = numero;
	}
	
	
	//Getters Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public ArrayList<Appel> getTabAppel() {
		return tabAppel;
	}
	public void setTabAppel(Appel a) {
		/*ArrayList<Appel> t = new ArrayList<>();
		t.add(a);*/
		this.tabAppel.add(a);
	}


	@Override
	public String toString() {
		return "Contact [id=" + id + ", nom=" + nom + ", numero=" + numero
				+ "]";
	}
	
	
}
