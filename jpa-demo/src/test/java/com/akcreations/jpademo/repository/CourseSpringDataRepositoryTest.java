package com.akcreations.jpademo.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.akcreations.jpademo.entity.Course;

@SpringBootTest
public class CourseSpringDataRepositoryTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository courseRepo;
	
	@Test
	void findById()
	{
		Optional<Course> courseOptional = courseRepo.findById(1001);
		assertTrue(courseOptional.isPresent());
	}
	
	@Test
	void testfindByIdNotFound()
	{
		Optional<Course> courseOptional = courseRepo.findById(3001);
		assertFalse(courseOptional.isPresent());
	}
  
	@Test
	void testSort()
	
	{  
		
		Sort descCourseName = Sort.by("courseName").descending();
		List<Course> courses = courseRepo.findAll(descCourseName);
		logger.info("Listof courses->{}",courses);
	}

}
