package com.adaming.myapp.disc;

import java.util.ArrayList;
import java.util.List;

public class DiscriminantImpl implements IDiscriminant{

	public List<String> CalculerRacinesPolynomes(int a, int b, int c) {
		List<String> reponses=new ArrayList<String>();
		int delta=(b*b)-(4*a*c);
		if (delta>0){
			double x=((-b-Math.sqrt(delta)))/(2*a);
			double y=((-b+Math.sqrt(delta)))/(2*a);
			reponses.add(String.valueOf(x) );
			reponses.add(Double.toString(y));
			System.out.println("Pour le polynome "+a+"x²+"+b+"x+"+c+" il existe deux racines réelles qui sont : "+reponses);
		}
		else if (delta==0){
			double x=(-b)/(2*a);
			reponses.add(Double.toString(x));
			System.out.println("Pour le polynome "+a+"x²+"+b+"x+"+c+" il existe une unique racine réelle qui est :"+reponses);
		}
		else if (delta<0){
			String x=Double.toString(-b).concat("+").concat(Double.toString(Math.sqrt(-delta))).concat("i)/(2*").concat(Integer.toString(a)).concat(")");
			String y=Double.toString(-b).concat("-").concat(Double.toString(Math.sqrt(-delta))).concat("i)/(2*").concat(Integer.toString(a)).concat(")");
			reponses.add(x);
			reponses.add(y);
			System.out.println("Pour le polynome "+a+"x²+"+b+"x+"+c+" il existe deux racines complexes qui sont :"+reponses);
			
		}
		
		return reponses;
		
	}
	
	

}
