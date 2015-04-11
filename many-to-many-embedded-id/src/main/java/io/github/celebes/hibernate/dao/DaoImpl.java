package io.github.celebes.hibernate.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

import javax.persistence.EntityManager;

public abstract class DaoImpl<T> implements Dao<T> {
	
	protected EntityManager em;
	private Class<T> type;
	
	public DaoImpl(EntityManager em) {
		initType();
		this.em = em;
	}
	
	private void initType() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	public void save(T t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
	
	public void delete(T t) {
		em.getTransaction().begin();
	    em.remove(em.contains(t) ? t : em.merge(t));
	    em.getTransaction().commit();
	}
	
	public void update(T t) {
		save(t);
	}
	
	public T findById(Object id) {
		return em.find(type, id);
	}
	
	public Collection<T> findAll() {
		return em.createQuery("SELECT e FROM " + type.getSimpleName() + " e").getResultList();
	}
	
}
