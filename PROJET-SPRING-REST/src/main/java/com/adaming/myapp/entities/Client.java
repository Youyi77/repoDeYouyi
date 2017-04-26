package com.adaming.myapp.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@Table(name = "client")
@SuppressWarnings("serial")
public class Client implements Serializable {
    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String nom;
	private String prenom;
	

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_CLI_PRO")
	private List<Produit> produits;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Client( String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}



	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the produits
	 */
	@JsonIgnore
	public List<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	@JsonSetter
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
	
}
