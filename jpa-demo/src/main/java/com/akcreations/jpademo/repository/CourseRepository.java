package com.akcreations.jpademo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akcreations.jpademo.entity.Course;
import com.akcreations.jpademo.entity.Review;

@Repository
@Transactional
public class CourseRepository {
    
	@PersistenceContext
	EntityManager em;
	
	public Course findById(int courseId)
	{
		return em.find(Course.class, courseId);
	}
	
	public void deleteById(int courseId)
	{
		Course removeCourse = findById(courseId);
		em.remove(removeCourse);
	}
	
	public Course save(Course course) {

		if(course.getCourseId()==null)
		{
			 em.persist(course);
		}
		else {
			em.merge(course);
		}
		
		return course;
	}
	
	public void playWithEntityManager() {
		
		Course course1 = new Course("Web-services in 100 steps");
		em.persist(course1);
		Course course2 = new Course("React JS in 100 steps");
		em.persist(course2);
		
		em.flush();
		
		course1.setCourseName("Web-services in 100 steps updated");
		course2.setCourseName("React JS in 100 steps updated");
		
		em.refresh(course1);
		
		em.flush();
	} 
	
	public void addHardCodeReviewForCourse()
	{   //get the course
		Course course = findById(1003);
		
		//add 2 reviews
		Review review1 = new Review("5","Great Course");
		Review review2 = new Review("5","Awesome Course");
		
		//set relations
		review1.setCourse(course);
		review2.setCourse(course);
		
		//save
		em.persist(review1);
		em.persist(review2);
	}
	
	public void addReviewsForCourse(int courseId,List<Review> reviews)
	{   //get the course
		Course course = findById(courseId);
		
		for(Review review:reviews)
		{		
		//set relations
		review.setCourse(course);	
		//save
		em.persist(review);
		}
	}
	
}
