package com.adaming.myapp.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Session;
import org.jboss.jandex.Main;

import com.adaming.myapp.dao.ClientImpl;
import com.adaming.myapp.service.ClientNotFoundException;
import com.adaming.myapp.service.ServiceClientImpl;
import com.adaming.myapp.singleton.Singleton;

public class Test {
	public static void main(String[] args) {;
		 ServiceClientImpl impl = new ServiceClientImpl();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		 Date d1=null;
		 Date d2= null;
		 Date d3=null;
		 Date d4=null;
		 try {
			d1=sdf.parse("20-02-2017");
			d2=sdf.parse("06-03-2017");
			d3=sdf.parse("07-03-2017");
			d4=sdf.parse("09-03-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		 Client a = new Client("Garip", "Rémi");
		 try {
			impl.AddClient(a);
			impl.AddClient(new Client("Brault", "Julie"));
			impl.AddClient(new Client("Boumaza", "Adel"));
			impl.AddClient(new Client("Boumaza", "Adel"));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
			Voiture b = new Voiture("Renault", "Rouge");
			 impl.AddVoiture(b);
			 impl.AddVoiture(new Voiture("Peugeot", "Bleue"));
			 Reservation r = new Reservation(d1, d2, d1, impl.getOneClient(1), impl.getOneVoiture(1));
			 try {
				impl.addReservation(r);
			} catch (ClientNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(impl.DispoVoiture(d3, d4));
			 
		
	
	
	
         Singleton.getS().close();
		 Singleton.getSf().close();
		
	}

}
