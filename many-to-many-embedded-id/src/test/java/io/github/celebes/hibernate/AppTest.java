package io.github.celebes.hibernate;

import io.github.celebes.hibernate.dao.impl.CourseDao;
import io.github.celebes.hibernate.dao.impl.StudentDao;
import io.github.celebes.hibernate.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
		String courseName = "Matematyka-" + System.nanoTime();
		int numOfCoursesBefore = courseDao.findAll().size();
		
		Course course = new Course(courseName);
		courseDao.save(course);
		
		course = courseDao.findById(course.getId());
		assertNotNull(course);
		assertEquals(course.getName(), courseName);
		
		int numOfCoursesAfter = courseDao.findAll().size();
		assertEquals(1, numOfCoursesAfter - numOfCoursesBefore);
	}

}
