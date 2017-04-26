package com.adaming.myapp.manager;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

public abstract class ManagerPersistenceAbstract<T,A> implements IManagerPersistence<T, A>{

	@PersistenceContext
	protected EntityManager entityManger;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public ManagerPersistenceAbstract() {
		this.clazz = (Class<T>)((ParameterizedType) (getClass().getGenericSuperclass())).getActualTypeArguments()[0];
	}
	
	public T create(T entity){
		entityManger.persist(entity);
		return entity;
	}
	
	public T update(T entity){
		T t = entityManger.merge(entity);
		return t;
	}
	
	public T getOne(A primaryKey){
		return entityManger.find(clazz, primaryKey);
	}
	
	public void delete(A primaryKey){
		T entity = getOne(primaryKey);
		entityManger.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll(){
		return entityManger.createQuery("from "+clazz.getName()).getResultList();
	}
	

	/**
	 * @return the clazz
	 */
	public Class<T> getClazz() {
		return clazz;
	}

	/**
	 * @param clazz the clazz to set
	 */
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}



	

	



	
	
	
	
}
