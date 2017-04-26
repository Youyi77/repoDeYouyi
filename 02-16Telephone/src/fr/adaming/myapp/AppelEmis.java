package fr.adaming.myapp;

import java.text.SimpleDateFormat;
import java.util.Date;


public class AppelEmis extends Appel{
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	public AppelEmis() {
		super();
	}

	
	
	
	public AppelEmis(int idAppel, Date d, int duree) {
		super(idAppel, d, duree);
		this.coutMin=2;
		this.coutAppel=impl.CalculerCout(duree, coutMin);
	}



	@Override
	public String toString() {
		return "AppelEmis [idAppel=" + idAppel + ", date=" + sdf.format(date) + ", duree="
				+ duree + ", coutMin=" + coutMin + ", coutAppel=" + coutAppel+"]";
	}


	
	
	

}
