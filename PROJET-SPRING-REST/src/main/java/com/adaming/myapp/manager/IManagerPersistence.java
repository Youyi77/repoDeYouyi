package com.adaming.myapp.manager;

import java.util.List;

public interface IManagerPersistence <T,A> {

	T create (T t);
	
	T update (T t);
	
	T getOne (A a);
	
	void delete(A a);
	
	List<T> getAll();
	
}
