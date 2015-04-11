package io.github.celebes.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

@Embeddable
public class StudentId implements Serializable {
	
	private static final long serialVersionUID = -1453918799320211647L;

	@Column(name = "student_id_1", nullable = false)
	private int id1;
	
	@Column(name = "student_id_2", nullable = false)
	private int id2;
	
	public StudentId() {
		
	}

	public StudentId(int id1, int id2) {
		this.id1 = id1;
		this.id2 = id2;
	}

	public int getId1() {
		return id1;
	}

	public void setId1(int id1) {
		this.id1 = id1;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}
	
	@Override
	public String toString() {
		return "StudentId [id1=" + id1 + ", id2=" + id2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id1;
		result = prime * result + id2;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentId other = (StudentId) obj;
		if (id1 != other.id1)
			return false;
		if (id2 != other.id2)
			return false;
		return true;
	}
	
}
