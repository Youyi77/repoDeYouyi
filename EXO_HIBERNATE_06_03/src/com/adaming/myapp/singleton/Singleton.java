package com.adaming.myapp.singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Singleton {
	
	private static SessionFactory sf;
	private static Session s;
	
	static
	{
		sf = new Configuration().configure().buildSessionFactory();
		s=sf.openSession();
	}

	public static SessionFactory getSf() {
		return sf;
	}

	public static void setSf(SessionFactory sf) {
		Singleton.sf = sf;
	}

	public static Session getS() {
		return s;
	}

	public static void setS(Session s) {
		Singleton.s = s;
	}
	
	

}
