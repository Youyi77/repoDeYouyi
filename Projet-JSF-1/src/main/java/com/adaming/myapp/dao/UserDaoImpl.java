package com.adaming.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.adaming.myapp.entities.User;

public class UserDaoImpl implements IUserDao{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User addUser(User user) {
		entityManager.persist(user);
		return user;
	}

	@Override
	public User deleteUser(Long idUser) {
		User user=getOneById(idUser);
		entityManager.remove(user);
		return null;
	}

	@Override
	public User updateUser(User user) {
		entityManager.merge(user);
		return user;
	}

	@Override
	public User getOneById(Long idUser) {
		User user=entityManager.find(User.class, idUser);
		return user;
	}

	@Override
	public List<User> getAll() {
		Query query=entityManager.createQuery("from User");
		List<User> users=query.getResultList();
		System.out.println(users);
		return users;
	}
	
	

}
