package com.adaming.myapp.ws;

import javax.xml.ws.Endpoint;

public class DriverWs {
	public static void main(String[] args) {
		final String URL="http://localhost:8093/";
		Endpoint endpoint = Endpoint.publish(URL, new MontantWs());
		System.out.println("Connection..." + URL);
		//http://localhost:8093/MontanWs?wsdl après run le projet entrer cette commande dans l'url de chrome
	}

}
