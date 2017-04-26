package com.adaming.myapp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.Produit;
import com.adaming.myapp.service.produit.IProduitService;

public class ProduitTestU {

	    
		private static ClassPathXmlApplicationContext context;
		private static IProduitService serviceProduit;
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		 context = new ClassPathXmlApplicationContext("app.xml");
		 serviceProduit = (IProduitService) context.getBean("serviceProduit");
		}

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		  context.close();
		}

		@Test
		public void testCreateProduit() {
			Produit Produit = new Produit("produit");
			serviceProduit.createProduit(Produit);
		}

		@Test
		public void testGetOneProduit() {
			Produit c = serviceProduit.getOneProduit(2L);
		    System.out.println(c);
		}

		@Test
		public void testDeleteProduit() {
			serviceProduit.deleteProduit(3L);
		}

		@Test
		public void testUpdateProduit() {
			Produit produit = serviceProduit.getOneProduit(1L);
			produit.setLabel("Produit 2");
			serviceProduit.updateProduit(produit);
		}

		@Test
		public void testGetAllProduits() {
			System.out.println(serviceProduit.getAllProduits());
		}
	
}
