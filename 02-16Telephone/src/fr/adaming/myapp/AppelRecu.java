package fr.adaming.myapp;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppelRecu extends Appel {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	
	public AppelRecu() {
		super();
	}

	public AppelRecu(int idAppel,Date d, int duree) {
		super(idAppel,d, duree);
		this.coutMin=0;
		this.coutAppel=impl.CalculerCout(duree, coutMin);
	}

	@Override
	public String toString() {
		return "AppelRecu [idAppel=" + idAppel + ", date=" + sdf.format(date) + ", duree="
				+ duree + ", coutMin=" + coutMin + ", coutAppel=" + coutAppel+ "]";
	}



	
	
}
