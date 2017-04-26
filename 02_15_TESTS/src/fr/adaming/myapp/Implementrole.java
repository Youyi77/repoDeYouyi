package fr.adaming.myapp;

import java.util.*;

public class Implementrole implements IRoles {

	private ArrayList<User> dataUser = new ArrayList<>();
	private ArrayList<Role> dataRole = new ArrayList<>();
	


	@Override
	public void addRole(Role r) {
		// TODO Auto-generated method stub
		dataRole.add(r);
		
	}

	@Override
	public void getAllUser() {
		// TODO Auto-generated method stub
		System.out.println(dataUser);
	}

	@Override
	public ArrayList<Role> getAllRole() {
		// TODO Auto-generated method stub
		System.out.println(dataRole);
		return dataRole;
	}

	@Override
	public void addUser(User u, int id) {
		// TODO Auto-generated method stub
		
		for (Role i : dataRole){
			if (i.getIdRole()==id){
			u.getTabRole().add(i);
			dataUser.add(u);}
			
			
		}
	}

	@Override
	public List<User> getUser(int idRole) throws Exception{
		// TODO Auto-generated method stub
		List<User> k= new ArrayList<User>();
		for (User u: dataUser){
			for (Role o:u.getTabRole()){
				if (o.getIdRole()==idRole){
					k.add(u);
				}
			}
		}
		if (k.isEmpty()){
			throw new Exception("Aucune personne ne possède le rôle n°"+idRole);
		}
		return k;
	}

	@Override
	public List<User> checkName(String mot) throws Exception{
		List<User> k= new ArrayList<User>();
		for (User u : dataUser){
			if (u.getPseudonyme().contains(mot)){
				k.add(u);
			}
		}
		if (k.isEmpty()){
			throw new Exception("Aucun utilisateur ne possède " + mot +" dans sont pseudo!");
		}
		// TODO Auto-generated method stub
		return k;
	}

	
}
