package io.github.celebes.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	
	private static final long serialVersionUID = -3341539157336246087L;
	
	@EmbeddedId
	private StudentId id;
	
	private String name;
	
	public Student() {
		
	}

	public Student(StudentId id, String name) {
		this.id = id;
		this.name = name;
	}

	public StudentId getId() {
		return id;
	}

	public void setId(StudentId id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
