package fr.adaming.myapp;

import java.text.ParseException;

public class Test {
	public static void main(String[] args) throws ParseException {
		ICatalogue impl = new AppImpl();
		
		impl.PgmPrincipal();
	}

}
