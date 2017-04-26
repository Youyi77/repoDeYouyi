package com.adaming.myapp.service;

import java.util.List;

import com.adaming.myapp.entities.User;

public interface IUserService {
	
	User addUser(User user);
	User deleteUser(Long idUser);
	User updateUser(User user);
	User getOneById(Long idUser);
	List<User> getAll();

}
