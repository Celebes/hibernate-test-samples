package io.github.celebes.hibernate.dao;

import java.util.Collection;

public interface Dao<T> {
	void save(T t);
	void delete(T t);
	void update(T t);
	T findById(Integer id);
	Collection<T> findAll();
}
