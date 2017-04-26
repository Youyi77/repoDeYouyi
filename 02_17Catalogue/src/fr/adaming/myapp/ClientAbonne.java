package fr.adaming.myapp;

public class ClientAbonne extends Client{
	double coef;

	public ClientAbonne() {
		super();
	}

	public ClientAbonne(int id, String nom, String prenom, String datDeNaissance) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datDeNaissance = datDeNaissance;
		this.coef=0.9;
	}

	@Override
	public String toString() {
		return "ClientAbonne [coef=" + coef + ", id=" + id + ", nom=" + nom
				+ ", prenom=" + prenom + ", datDeNaissance=" + datDeNaissance
				+ "]";
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}
	
	
	
	
}

