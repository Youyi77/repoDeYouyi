package com.adaming.myapp.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class ManagerServiceAbstrcat<T,A> implements IManagerService<T, A> {
    
	@Autowired
	@Qualifier("dao")
	private IManagerPersistence<T, A> dao;
	
	

	/**
	 * @param dao the dao to set
	 */
	public void setDao(IManagerPersistence<T, A> dao) {
		this.dao = dao;
		System.out.println("<---- injected----->");
	}

	@Override
	public T create(T t) {
		// TODO Auto-generated method stub
		return dao.create(t);
	}

	@Override
	public T update(T t) {
		// TODO Auto-generated method stub
		return dao.update(t);
	}

	@Override
	public T getOne(A a) {
		// TODO Auto-generated method stub
		return dao.getOne(a);
	}

	@Override
	public void delete(A a) {
	   dao.delete(a);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}
