package io.github.celebes.hibernate.dao;

import java.util.Collection;

public interface Dao<T> {
	void save(T t);
	void delete(T t);
	void update(T t);
	T findById(Object id);
	Collection<T> findAll();
}
