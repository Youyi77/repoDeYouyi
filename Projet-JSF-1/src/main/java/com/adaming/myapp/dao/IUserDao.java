package com.adaming.myapp.dao;

import java.util.List;

import com.adaming.myapp.entities.User;

public interface IUserDao {
	
	User addUser(User user);
	User deleteUser(Long idUser);
	User updateUser(User user);
	User getOneById(Long idUser);
	List<User> getAll();

}
