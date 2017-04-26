package com.adaming.myapp;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.service.client.IClientService;

public class ClientTestU {
    
	private static ClassPathXmlApplicationContext context;
	private static IClientService serviceClient;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 context = new ClassPathXmlApplicationContext("app.xml");
	 serviceClient = (IClientService) context.getBean("serviceClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	  context.close();
	}

	@Test
	public void testCreateClient() {
		Client client = new Client("xx", "yy");
		serviceClient.createClient(client);
	}

	@Test
	public void testGetOneClient() {
		Client c = serviceClient.getOneClient(2L);
	    System.out.println(c);
	}

	@Test
	public void testDeleteClient() {
		serviceClient.deleteClient(3L);
	}

	@Test
	public void testUpdateClient() {
		Client c = serviceClient.getOneClient(2L);
		c.setNom("gggggggggg");
		serviceClient.updateClient(c);
	}

	@Test
	public void testGetAllClients() {
		System.out.println(serviceClient.getAllClients());
	}

}
