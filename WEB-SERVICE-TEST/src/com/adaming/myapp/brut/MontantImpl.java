package com.adaming.myapp.brut;

public class MontantImpl implements IMontant {

	public double brutToNet(double mt) {
		double result=mt*0.77;
		return result;
	}

	public double netToBrut(double mt) {
		double result=mt/0.77;
		return result;
	}

}
