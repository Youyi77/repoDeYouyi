package com.adaming.myapp.entities;

import javax.persistence.*;

@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idVoiture;
	private String marque;
	private String couleur;
	public Voiture(String marque, String couleur) {
		super();
		this.marque = marque;
		this.couleur = couleur;
	}
	
	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	@Override
	public String toString() {
		return "Voiture [IdVoiture=" + idVoiture + ", marque=" + marque
				+ ", couleur=" + couleur + "]";
	}
	public Voiture() {
		// TODO Auto-generated constructor stub
	}
	
	

}
