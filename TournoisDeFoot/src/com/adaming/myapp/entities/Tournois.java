package com.adaming.myapp.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
public class Tournois {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdTournois;
	private String nom;
	private String paysOrganisateur;
	@OneToMany(mappedBy="tournois")
	private List<Equipe> equipes = new ArrayList<Equipe>();
	
	

	public Tournois(String nom, String pays) {
		super();
		this.nom = nom;
		this.paysOrganisateur=pays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Tournois() {
		super();
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public Integer getIdTournois() {
		return IdTournois;
	}

	public String getPaysOrganisateur() {
		return paysOrganisateur;
	}

	public void setPaysOrganisateur(String paysOrganisateur) {
		this.paysOrganisateur = paysOrganisateur;
	}

	public void setIdTournois(Integer idTournois) {
		IdTournois = idTournois;
	}

	@Override
	public String toString() {
		return "Tournois [IdTournois=" + IdTournois + ", nom=" + nom
				+ ", paysOrganisateur=" + paysOrganisateur + "]";
	}
	
	

	

}
