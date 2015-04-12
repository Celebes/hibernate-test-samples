package io.github.celebes.hibernate.model;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "student_course")
public class StudentCourse {

	private StudentCourseId id;
	private Student student;
	private Course course;
	
	public StudentCourse() {
		
	}

	@EmbeddedId
	public StudentCourseId getId() {
		return id;
	}

	public void setId(StudentCourseId id) {
		this.id = id;
	}
	
	@ManyToOne
	@MapsId("studentId")
	@JoinColumns({
		@JoinColumn(name = "student_id_1", referencedColumnName = "student_id_1", insertable = false, updatable = false),
		@JoinColumn(name = "student_id_2", referencedColumnName = "student_id_2", insertable = false, updatable = false)
	})
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name = "course_id", referencedColumnName = "course_id", insertable = false, updatable = false)
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		StudentCourse that = (StudentCourse) o;

		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		return (getId() != null ? getId().hashCode() : 0);
	}
	
}
