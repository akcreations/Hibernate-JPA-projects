package com.akcreations.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.akcreations.jpademo.entity.Course;

@SpringBootTest
class JPQLDemoApplicationTests {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
	@Test
	void coursesWithoutStudent()
	{
		TypedQuery<Course> coursesQuery= em.createQuery("Select c from Course c where c.students is empty", Course.class);
		List<Course> courses=coursesQuery.getResultList();
		logger.info("Courses without student ->{}",courses);
	}
	
	@Test
	void coursesWithMoreThan2Student()
	{
		TypedQuery<Course> coursesQuery= em.createQuery("Select c from Course c where size(c.students) >=2", Course.class);
		List<Course> courses=coursesQuery.getResultList();
		logger.info("Courses with more than 2 student ->{}",courses);
	}
	
	@Test
	void coursesWithReact()
	{
		TypedQuery<Course> coursesQuery= em.createQuery("Select c from Course c where c.courseName like '%React%'", Course.class);
		List<Course> courses=coursesQuery.getResultList();
		logger.info("React courses ->{}",courses);
	}

}
