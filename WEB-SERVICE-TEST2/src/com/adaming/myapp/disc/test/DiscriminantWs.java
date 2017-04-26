package com.adaming.myapp.disc.test;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.adaming.myapp.disc.DiscriminantImpl;
import com.adaming.myapp.disc.IDiscriminant;

@WebService
public class DiscriminantWs {
	private IDiscriminant disc =new DiscriminantImpl();
	
	@WebMethod(operationName="calculerRacinesPolynomesWs")
	public List<String> CalculerRacinesPolynomes(int a, int b, int c){
		return disc.CalculerRacinesPolynomes(a, b, c);
	}


}
