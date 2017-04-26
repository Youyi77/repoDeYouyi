package com.adaming.myapp.dao.singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SingletonHibernate {
	
	private static SessionFactory sf;
	private static Session s;
	
	static {
		sf = new Configuration().configure().buildSessionFactory();
		s= sf.openSession();
	}

	public static SessionFactory getSessionFactory() {
		return sf;
	}

	public static Session getSession() {
		return s;
	}
	
	

}
