package fr.adaming.myapp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public abstract class Appel {
	protected int idAppel;
	protected Date date;
	protected int duree;
	protected int coutMin;
	protected int coutAppel;
	IAppareil impl =new AppImpl();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	
	//Constructeur par défaut
	public Appel() {
	}
	//Constructeur paramétré
	public Appel(int idAppel,Date d, int duree) {
		super();
		this.idAppel = idAppel;
		
		this.date = d;
		this.duree = duree;
	}

	
	
	//Getters/Setters
	public int getIdAppel() {
		return idAppel;
	}

	public void setIdAppel(int idAppel) {
		this.idAppel = idAppel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getCoutMin() {
		return coutMin;
	}

	public void setCoutMin(int coutMin) {
		this.coutMin = coutMin;
	}

	public int getCoutAppel() {
		return coutAppel;
	}

	public void setCoutAppel(int coutAppel) {
		this.coutAppel = coutAppel;
	}
	
	
	
	

}
