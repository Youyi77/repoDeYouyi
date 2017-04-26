package com.adaming.myapp.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdClient;
	private String nom;
	private String prenom;
	@OneToMany
	@JoinTable(name = "tb_voiture")
	private List<Voiture> voitures;
	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public int getIdClient() {
		return IdClient;
	}

	public void setIdClient(int idClient) {
		IdClient = idClient;
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

	public List<Voiture> getVoitures() {
		return voitures;
	}

	public void setVoitures(List<Voiture> voitures) {
		this.voitures = voitures;
	}

	@Override
	public String toString() {
		return "Client [IdClient=" + IdClient + ", nom=" + nom + ", prenom="
				+ prenom + ", voitures=" + voitures + "]";
	}
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	

}
