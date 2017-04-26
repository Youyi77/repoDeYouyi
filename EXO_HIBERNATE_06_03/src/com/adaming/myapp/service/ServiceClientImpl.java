package com.adaming.myapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.CreateKeySecondPass;

import com.adaming.myapp.dao.ClientImpl;
import com.adaming.myapp.entities.Client;
import com.adaming.myapp.entities.Reservation;
import com.adaming.myapp.entities.Voiture;
import com.adaming.myapp.singleton.Singleton;

public class ServiceClientImpl implements IServiceClient {
    Session s =  Singleton.getS();
	ClientImpl impl = new ClientImpl();
	
	@Override
	public Client AddClient(Client c) throws Exception {
		int x=0;
		List<Client> clients = getAllClient();
		for (Client client :clients){
			if (c.getNom().equalsIgnoreCase(client.getNom())&& c.getPrenom().equalsIgnoreCase(client.getPrenom())){
				x=1;
			}			
		}
		if (x==0){
			impl.AddClient(c);
			}
		else {
			throw new DuplicateClientException("Individu déjà enregistré !");
			}
		return c;
	}

	@Override
	public Voiture AddVoiture(Voiture v) {
		// TODO Auto-generated method stub
		return impl.AddVoiture(v);
	}

	@Override
	public Reservation addReservation(Reservation r) throws ClientNotFoundException{
		if (r.getClient()==s.get(Client.class, r.getClient().getIdClient())){
			impl.addReservation(r);
		}
		else { 
			throw new ClientNotFoundException("Client inexistant, merci de l'enregistrer au préalable");}
		return r;
	}

	@Override
	public Client getOneClient(int id) {
		// TODO Auto-generated method stub
		return impl.getOneClient(id);
	}

	@Override
	public Voiture getOneVoiture(int id) {
		// TODO Auto-generated method stub
		return impl.getOneVoiture(id);
	}

	@Override
	public Reservation getOneReservation(int id) {
		// TODO Auto-generated method stub
		return impl.getOneReservation(id);
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return impl.getAllClient();
	}

	@Override
	public List<Voiture> getAllVoiture() {
		// TODO Auto-generated method stub
		return impl.getAllVoiture();
	}

	@Override
	public List<Reservation> getAllReservation() {
		// TODO Auto-generated method stub
		return impl.getAllReservation();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Voiture> DispoVoiture(Date debut, Date fin) {
		//Query query = s.createQuery("from Reservation r inner join Voiture v on r.voiture.idVoiture=v.idVoiture"); //where x not between dateDebut and dateFin and y not between dateDebut and dateFin");
		//Query query = s.createSQLQuery("select * from Reservation r inner join Voiture v on r.fk_voiture=v.idVoiture where x not between dateDebut and dateFin and y not between dateDebut and dateFin");
		//query.setParameter("x", debut).setParameter("y", fin);
		List<Reservation> reservations = getAllReservation();
		List<Voiture> voituresDispo =getAllVoiture();
		List<Voiture> voituresIndispo=new ArrayList();
		for (Reservation r : reservations){
			if (!(debut.before(r.getDateDebut() )&& fin.before(r.getDateDebut()) || (debut.after(r.getDateFin()) && fin.after(r.getDateFin())))){
				voituresIndispo.add(r.getVoiture());
			}
		}
		voituresDispo.removeAll(voituresIndispo);
		return voituresDispo;
	}

}
