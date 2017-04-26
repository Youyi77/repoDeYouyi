package com.adaming.myapp;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaming.myapp.entities.User;
import com.adaming.myapp.service.IUserService;

public class UserServiceTestUnitaire {

	private static ClassPathXmlApplicationContext context;
	private final Logger LOGGER=Logger.getLogger("UserServiceTestUnitaire");
	@Inject
	private static IUserService service;

	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("app.xml");
		service=(IUserService)context.getBean("userService");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testAddUser() {
		User u=service.addUser(new User("Rémi","youyi"));
		assertTrue(u.getIdUser()==1);
		LOGGER.info("Ajout réussi");
		
	}
	@Ignore
	@Test
	public void testDeleteUser() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testUpdateUser() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testGetOneById() {
		fail("Not yet implemented");
	}
	@Ignore
	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
