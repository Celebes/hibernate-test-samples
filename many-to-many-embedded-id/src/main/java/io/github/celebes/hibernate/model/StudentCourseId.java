package io.github.celebes.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class StudentCourseId implements Serializable {

	private static final long serialVersionUID = 7046586609089058502L;

	private StudentId studentId;
	private int courseId;

	public StudentId getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

}
