package com.adaming.myapp.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class TournoisMondial {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer IdTournoisMondial;
	@OneToMany(mappedBy="tournois")
	private List<Equipe> equipes= new ArrayList<Equipe>();
	public TournoisMondial() {
		super();
	}
	public Integer getIdTournoisMondial() {
		return IdTournoisMondial;
	}
	public void setIdTournoisMondial(Integer idTournoisMondial) {
		IdTournoisMondial = idTournoisMondial;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	@Override
	public String toString() {
		return "TournoisMondial [IdTournoisMondial=" + IdTournoisMondial + "]";
	}
	
	

}
