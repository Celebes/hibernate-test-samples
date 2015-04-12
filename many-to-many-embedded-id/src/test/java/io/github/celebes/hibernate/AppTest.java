package io.github.celebes.hibernate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import io.github.celebes.hibernate.dao.impl.CourseDao;
import io.github.celebes.hibernate.dao.impl.StudentDao;
import io.github.celebes.hibernate.model.Course;
import io.github.celebes.hibernate.model.Student;
import io.github.celebes.hibernate.model.StudentCourse;
import io.github.celebes.hibernate.model.StudentId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("h2-db");
	private EntityManager em;
	private CourseDao courseDao;
	private StudentDao studentDao;

	@Before
	public void initEntityManager() throws Exception {
		em = emf.createEntityManager();
		courseDao = new CourseDao(em);
		studentDao = new StudentDao(em);
	}

	@After
	public void closeEntityManager() throws Exception {
		if (em != null) {
			em.close();
		}
	}

	@Test
	public void shouldCreateCourse() throws Exception {
		System.out.println("Course test");
		String courseName = "Matematyka-" + System.nanoTime();
		int numOfCoursesBefore = courseDao.findAll().size();
		
		Course course = new Course(courseName);
		courseDao.save(course);
		
		course = courseDao.findById(course.getId());
		System.out.println("Znaleziono: " + course);
		assertNotNull(course);
		assertEquals(course.getName(), courseName);
		
		int numOfCoursesAfter = courseDao.findAll().size();
		assertEquals(1, numOfCoursesAfter - numOfCoursesBefore);
	}
	
	@Test
	public void shouldCreateStudent() throws Exception {
		System.out.println("Student test");
		String studentName = "Krzysztof Liczbowy-" + System.nanoTime();
		int nextId = studentDao.findAll().size() + 1;
		StudentId sid = new StudentId(nextId, nextId);
		
		Student student = new Student(sid, studentName);
		
		studentDao.save(student);
		
		student = studentDao.findById(student.getId());
		System.out.println("Znaleziono: " + student);
		assertNotNull(student);
		assertEquals(student.getName(), studentName);
	}
	
	@Test
	public void shouldCreateBoth() throws Exception {
		System.out.println("Both test");
		
		String courseName = "Matematyka-" + System.nanoTime();
		Course course = new Course(courseName);
		courseDao.save(course);
		
		String studentName = "Krzysztof Liczbowy-" + System.nanoTime();
		int nextId = studentDao.findAll().size() + 1;
		StudentId sid = new StudentId(nextId, nextId);
		Student student = new Student(sid, studentName);
		studentDao.save(student);
		
		StudentCourse sc = new StudentCourse();
		sc.setCourse(course);
		sc.setStudent(student);
		
		em.getTransaction().begin();
		em.persist(sc);
		em.getTransaction().commit();
		
	}

}
