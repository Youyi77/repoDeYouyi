package com.adaming.myapp.entities;

import javax.persistence.*;


@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Boolean encoreEnLice = true;
	private Boolean paysOrganisateur;
	private String Nom;
	
	@ManyToOne
	@JoinColumn(name ="FK_Tournois")
	private Tournois tournois;
	
	
	
	public Equipe(  String nom) {
		super();
		this.encoreEnLice = encoreEnLice;
		this.Nom = nom;
	}



	public Equipe() {
		super();
	}



	public Integer getId() {
		return Id;
	}



	public void setId(Integer id) {
		Id = id;
	}



	public Boolean getEncoreEnLice() {
		return encoreEnLice;
	}



	public void setEncoreEnLice(Boolean encoreEnLice) {
		this.encoreEnLice = encoreEnLice;
	}



	public Boolean getPaysOrganisateur() {
		return paysOrganisateur;
	}



	public void setPaysOrganisateur(Boolean paysOrganisateur) {
		this.paysOrganisateur = paysOrganisateur;
	}



	public String getNom() {
		return Nom;
	}



	public void setNom(String nom) {
		Nom = nom;
	}



	public Tournois getTournois() {
		return tournois;
	}



	public void setTournois(Tournois tournois) {
		this.tournois = tournois;
	}



	@Override
	public String toString() {
		return "Equipe [Id=" + Id + "Nom=" + Nom
				+/*", encoreEnLice=" + encoreEnLice
				+ ", paysOrganisateur=" + paysOrganisateur +  ", tournois=" + tournois +*/ "]";
	}
	
	
	
	
	

}
