package com.akcreations.jpademo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.akcreations.jpademo.entity.Course;
import com.akcreations.jpademo.entity.Student;


@SpringBootTest
class CourseRepositoryTest {
    
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    CourseRepository repo;
	
	@Autowired
	EntityManager em;
	
    @Test
	void testfindById() {
		Course course = repo.findById(1001);
		assertEquals("React Training",course.getCourseName());
	}
    
    @Test
    @DirtiesContext
	void testdeleteById() {
		repo.deleteById(1002);
		assertNull(repo.findById(1002));
	}
    
    @Test
    @DirtiesContext
	void testsave1() {
		Course course = repo.findById(1001);
		assertEquals("React Training",course.getCourseName());
		course.setCourseName("React and PrimeReact");
		repo.save(course);
		assertEquals("React and PrimeReact",repo.findById(1001).getCourseName());
	}
    
    @Test
    @Transactional
    void getCourseWithReviews()
    {
    	Course  course=repo.findById(1003);
    	logger.info("{}",course.getReviews());
    }
    
    @Test
    @Transactional
    void getListofStudentsForCourse()
    {
    	Course  course=repo.findById(1001);
    	logger.info("{}",course);
    	logger.info("{}",course.getStudents());
    
    }
    
    @Test
    @Transactional
    void getListofCourseForStudent()
    {
    		Student student=em.find(Student.class,2001);
    	logger.info("{}",student);
    	logger.info("{}",student.getCourses());
    
    }
    
    
}
