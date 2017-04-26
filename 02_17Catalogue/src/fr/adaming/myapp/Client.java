package fr.adaming.myapp;

public class Client {
	int id;
	String nom;
	String prenom;
	String datDeNaissance;
	double coef;
	
	
	public Client() {
	}


	public Client(int id, String nom, String prenom, String datDeNaissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datDeNaissance = datDeNaissance;
		this.coef=1.0;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", datDeNaissance=" + datDeNaissance +  "]";
	}


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


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getDatDeNaissance() {
		return datDeNaissance;
	}


	public void setDatDeNaissance(String datDeNaissance) {
		this.datDeNaissance = datDeNaissance;
	}


	public double getCoef() {
		return coef;
	}


	public void setCoef(double coef) {
		this.coef = coef;
	}
	
	
	
}
