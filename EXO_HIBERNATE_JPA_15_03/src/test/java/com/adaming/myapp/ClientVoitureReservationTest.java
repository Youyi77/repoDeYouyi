package com.adaming.myapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IServiceClient;
import com.adaming.myapp.service.IVoitureService;

public class ClientVoitureReservationTest {
	private static ClassPathXmlApplicationContext context;
	private static IServiceClient service;
	private static IVoitureService serviceV;
	
	public static void main(String[] args) {
		context= new ClassPathXmlApplicationContext("app.xml");
		service =(IServiceClient) context.getBean("clientService");
		serviceV=(IVoitureService) context.getBean("voitureService");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		 Date d1=null;
		 Date d2= null;
		 Date d3=null;
		 Date d4=null;
		 Date d5=null;
		 Date d6=null;
		 try {
			d1=sdf.parse("20-02-2017");
			d2=sdf.parse("06-03-2017");
			d3=sdf.parse("07-03-2017");
			d4=sdf.parse("09-03-2017");
			d5=sdf.parse("10-12-2017");
			d6=sdf.parse("12-12-2017");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
		
		Client c1=new Client("garip", "remi");
		Client c2=new Client("brault", "julie");
		Client c3=new Client("boumaza", "adel");
		Voiture v1= new Voiture("renault", "bleu");
		Voiture v2= new Voiture("renault", "rouge");
		Reservation r1=new Reservation(d1, d3, d1, c1, v2);
		Reservation r2=new Reservation(d2, d3, d1, c3, v1);
		try {
			service.AddClient(c1);
			service.AddClient(c2);
			service.AddClient(c3);
			serviceV.AddVoiture(v1);
			serviceV.AddVoiture(v2);
			service.addReservation(r1);
			service.addReservation(r2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(service.DispoVoiture(d5, d6));
		
		
		
		
		
		
	}
	
	
	
	

}
