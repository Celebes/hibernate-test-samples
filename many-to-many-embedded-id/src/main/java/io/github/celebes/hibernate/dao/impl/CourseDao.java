package io.github.celebes.hibernate.dao.impl;

import io.github.celebes.hibernate.dao.DaoImpl;
import io.github.celebes.hibernate.model.Course;

import java.util.Collection;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CourseDao extends DaoImpl<Course> {
	
	public CourseDao(EntityManager em) {
		super(em);
	}
	
}
