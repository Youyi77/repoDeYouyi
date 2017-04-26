package com.adaming.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.service.IServiceClient;

/**
 * Handles requests for the application home page.
 */
/*@SessionAttributes("mClients")*/
@Controller
public class HomeController {
	
	@Inject
	private IServiceClient service;
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		
		return "home";
	}
	
	@RequestMapping(value = "/calculer", method = RequestMethod.POST)
	public String getValue(Model model, String nbr1, String nbr2){
		System.out.println("nbr1"+" "+"nbr2");
		int nbr1ToInt=Integer.parseInt(nbr1);
		int nbr2ToInt=Integer.parseInt(nbr2);
		int result=nbr1ToInt+nbr2ToInt;
		model.addAttribute("nbr1",nbr1ToInt);
		model.addAttribute("nbr2",nbr2ToInt);
		model.addAttribute("monCalcul",result);
		model.addAttribute("mClients", service.getAllClient());
		
		/*return "redirect:/get";*/
		return "home";
	}
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String get ( Model model){
		
		return "home2";
	}
	
	
	
	@RequestMapping(value="/sauvegarder", method=RequestMethod.POST)
	public String save(Model model, @RequestParam ("nomClient")String nom, String prenomClient){
		Client c= new Client(nom,prenomClient);
	/*	String nom=(request.getParameter("nomClient"));
		String prenom=(request.getParameter("prenomClient"));
		c.setNom(nom);
		c.setPrenom(prenom);*/
		try {
			service.AddClient(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}
	
	
	@RequestMapping(value="/seeAll", method=RequestMethod.POST)
	public String SeeAll(Model model){
		model.addAttribute("mClients", service.getAllClient());
		return "home";
	}
	
	@RequestMapping(value="/getOneById", method=RequestMethod.POST)
	public String GetOneById(Model model, String idGetOne){
		int id=Integer.parseInt(idGetOne);
		model.addAttribute("clientById", service.getOneClient(id));
		return "home2";
	}
	
}
