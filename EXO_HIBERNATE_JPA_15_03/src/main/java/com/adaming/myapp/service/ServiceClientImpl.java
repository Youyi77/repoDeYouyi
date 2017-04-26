package com.adaming.myapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.CreateKeySecondPass;
import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.ClientImpl;
import com.adaming.myapp.dao.IClientDao;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;


@Transactional(readOnly=true)
public class ServiceClientImpl implements IServiceClient {
	
	private EntityManager entityManager;
	private IClientDao dao;
	private final Logger LOGGER =Logger.getLogger("ServiceClientImpl");
	
	
	
	/**
	 * @param dao the dao to set
	 */
	public void setDao(IClientDao dao) {
		this.dao = dao;
		LOGGER.info("Le TER n°78846 à destination de Montargis partira voie N, il deservira Melun, Bois le Roi, Fontainebleau, Thomery, Moret Veneux les Sablons, Saint Mammès etc..");
	}

	@Override
	@Transactional(readOnly=false)
	public Client AddClient(Client c) throws Exception {
		int x=0;
		List<Client> clients = getAllClient();
		for (Client client :clients){
			if (c.getNom().equalsIgnoreCase(client.getNom())&& c.getPrenom().equalsIgnoreCase(client.getPrenom())){
				x=1;
			}			
		}
		if (x==0){
			dao.AddClient(c);
			}
		else {
			throw new DuplicateClientException("Individu déjà enregistré !");
			}
		return c;
	}



	@Override
	@Transactional(readOnly=false)
	public Reservation addReservation(Reservation r) throws ClientNotFoundException{
	//	if (r.getClient()==entityManager.find(Client.class, r.getClient().getIdClient())){
			dao.addReservation(r);
	/*	}
		else { 
			throw new ClientNotFoundException("Client inexistant, merci de l'enregistrer au préalable");}*/
		return r;
	}

	@Override
	public Client getOneClient(int id) {
		// TODO Auto-generated method stub
		return dao.getOneClient(id);
	}



	@Override
	public Reservation getOneReservation(int id) {
		// TODO Auto-generated method stub
		return dao.getOneReservation(id);
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return dao.getAllClient();
	}



	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return dao.getAllReservation();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Voiture> DispoVoiture(Date debut, Date fin) {
		//Query query = s.createQuery("from Reservation r inner join Voiture v on r.voiture.idVoiture=v.idVoiture"); //where x not between dateDebut and dateFin and y not between dateDebut and dateFin");
		//Query query = s.createSQLQuery("select * from Reservation r inner join Voiture v on r.fk_voiture=v.idVoiture where x not between dateDebut and dateFin and y not between dateDebut and dateFin");
		//query.setParameter("x", debut).setParameter("y", fin);
	/*	List<Reservation> reservations = getAllReservation();
		List<Voiture> voituresDispo =getAllVoiture();
		List<Voiture> voituresIndispo=new ArrayList();
		for (Reservation r : reservations){
			if (!(debut.before(r.getDateDebut() )&& fin.before(r.getDateDebut()) || (debut.after(r.getDateFin()) && fin.after(r.getDateFin())))){
				voituresIndispo.add(r.getVoiture());
			}
		}
		voituresDispo.removeAll(voituresIndispo);
		return voituresDispo;*/
		return null;
	}

}
