package com.adaming.myapp.entities;

import java.util.*;

import javax.persistence.*;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdRes;
	private Date dateDebut;
	private Date dateFin;
	private Date dateReserv;
	@OneToOne
	@JoinColumn
	private Client client;
	@OneToOne
	@JoinColumn(name = "fk_voiture")
	private Voiture voiture;
	public Reservation(Date dateDebut, Date dateFin, Date dateReserv,
			Client client, Voiture voiture) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateReserv = dateReserv;
		this.client = client;
		this.voiture = voiture;
	}
	public int getIdRes() {
		return IdRes;
	}
	public void setIdRes(int idRes) {
		IdRes = idRes;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateReserv() {
		return dateReserv;
	}
	public void setDateReserv(Date dateReserv) {
		this.dateReserv = dateReserv;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
	@Override
	public String toString() {
		return "Reservation [IdRes=" + IdRes + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", dateReserv=" + dateReserv
				+ ", client=" + client + ", voiture=" + voiture + "]";
	}
	

	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
