package com.adaming.myapp.entities;

import javax.persistence.*;

@Entity
@Table(name="TB_Match")
public class Match {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMatch;
	@OneToOne
	@JoinColumn
	private Equipe equipe1;
	@OneToOne
	@JoinColumn
	private Equipe equipe2;
	
	
	public Match(Equipe equipe1, Equipe equipe2) {
		super();
		this.equipe1 = equipe1;
		this.equipe2 = equipe2;
	}
	public Integer getIdMatch() {
		return idMatch;
	}
	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}
	public Equipe getEquipe1() {
		return equipe1;
	}
	public void setEquipe1(Equipe equipe1) {
		this.equipe1 = equipe1;
	}
	public Equipe getEquipe2() {
		return equipe2;
	}
	public void setEquipe2(Equipe equipe2) {
		this.equipe2 = equipe2;
	}
	@Override
	public String toString() {
		return "Match [idMatch=" + idMatch + ", equipe1=" + equipe1.getNom()
				+ ", equipe2=" + equipe2.getNom() + "]";
	}
	
	
	
	
}
