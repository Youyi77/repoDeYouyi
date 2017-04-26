package com.adaming.myapp;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.service.IServiceClient;
import com.adaming.myapp.service.IVoitureService;

//@Controller
public class VoitureController {
	
	private IVoitureService service;
	private EntityManager entityManager;

	
	
	@RequestMapping(value="/sauvegarderVoiture", method=RequestMethod.POST)
	public String save(Model model, String marque, String couleur){
		Voiture v= new Voiture(marque, couleur);

			service.AddVoiture(v);
		return "voiture";
	}
	
	@RequestMapping(value = "/page3", method = RequestMethod.GET)
	public String page3 ( Model model){
		
		return "home3";
	}
	
	
	
}
