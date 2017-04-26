package com.adaming.myapp.disc.test;

import javax.xml.ws.Endpoint;

import com.adaming.myapp.disc.DiscriminantImpl;
import com.adaming.myapp.disc.IDiscriminant;

public class Driver {
	public static void main(String[] args) {
		final String URL="http://localhost:8091/";
		Endpoint endpoint = Endpoint.publish(URL, new DiscriminantWs());
		System.out.println("Connection..." + URL);
		//http://localhost:8098/MontanWs?wsdl après run le projet entrer cette commande dans l'url de chrome
	}


}
