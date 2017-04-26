package com.adaming.myapp.dto;

import java.util.List;

public class ClientDTO {

	private Long id;
	private String nom;
	private String prenom;
	private List<ProduitDTO> produits;
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
	public List<ProduitDTO> getProduits() {
		return produits;
	}
	/**
	 * @param produits the produits to set
	 */
	public void setProduits(List<ProduitDTO> produits) {
		this.produits = produits;
	}
	
	
}
