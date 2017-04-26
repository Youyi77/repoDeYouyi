package com.adaming.myapp.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.adaming.myapp.brut.IMontant;
import com.adaming.myapp.brut.MontantImpl;



@WebService
public class MontantWs {
	private IMontant mService=new MontantImpl();
	
	@WebMethod(operationName="brutToNetWs")
	public double brutToNetWs(double mt){
		return mService.brutToNet(mt);
	}
	
	@WebMethod(operationName="netToBrutWs")
	public double NetToBrutWs(double mt){
		return mService.netToBrut(mt);
	}

}
