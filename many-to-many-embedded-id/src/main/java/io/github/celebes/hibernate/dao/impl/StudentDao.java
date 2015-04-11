package io.github.celebes.hibernate.dao.impl;

import io.github.celebes.hibernate.dao.DaoImpl;
import io.github.celebes.hibernate.model.Student;

import java.util.Collection;

import javax.persistence.EntityManager;

public class StudentDao extends DaoImpl<Student> {
	
	public StudentDao(EntityManager em) {
		super(em);
	}

}
