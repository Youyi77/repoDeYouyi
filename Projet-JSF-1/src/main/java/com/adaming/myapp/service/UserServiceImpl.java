package com.adaming.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.adaming.myapp.dao.IUserDao;
import com.adaming.myapp.entities.User;

@Transactional(readOnly=true)
public class UserServiceImpl implements IUserService{
	@Inject
	private IUserDao daoUser;

	/**
	 * @param daoUser the daoUser to set
	 */
	public void setDaoUser(IUserDao daoUser) {
		this.daoUser = daoUser;
	}

	@Override
	@Transactional(readOnly=false)
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return daoUser.addUser(user);
	}

	@Override
	@Transactional(readOnly=false)
	public User deleteUser(Long idUser) {
		
		return daoUser.deleteUser(idUser);
	}

	@Override
	@Transactional(readOnly=false)
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return daoUser.updateUser(user);
	}

	@Override
	public User getOneById(Long idUser) {
		// TODO Auto-generated method stub
		return daoUser.getOneById(idUser);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return daoUser.getAll();
	}
	
	

}
