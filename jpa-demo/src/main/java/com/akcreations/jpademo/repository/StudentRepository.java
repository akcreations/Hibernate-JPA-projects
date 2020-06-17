package com.akcreations.jpademo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akcreations.jpademo.entity.Course;
import com.akcreations.jpademo.entity.Passport;
import com.akcreations.jpademo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
    
	@PersistenceContext
	EntityManager em;
	
	public Student findById(int studentId)
	{
		return em.find(Student.class, studentId);
	}
	
	public void deleteById(int studentId)
	{
		Student removeStudent = findById(studentId);
		em.remove(removeStudent);
	}
	
	public Student save(Student student) {

		if(student.getId()==null)
		{
			 em.persist(student);
		}
		else {
			em.merge(student);
		}
		
		return student;
	}
	
	public void saveStudentWithPassport() {
		
	 Passport passport = new Passport("ZXY23243");
	 em.persist(passport);
	 
	 Student student = new Student("Adithya");
	 student.setPassport(passport);
	 
	 
	 em.persist(student);
	} 
	
	public void insertStudentAndCourse(Student student,Course course )
	{
		em.persist(student);
		em.persist(course);
		
		student.addCourse(course);
		course.addStudent(student);
		//persist the owning table
		em.persist(course);
	}
}
