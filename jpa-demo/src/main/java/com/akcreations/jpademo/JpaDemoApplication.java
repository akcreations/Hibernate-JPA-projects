package com.akcreations.jpademo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.akcreations.jpademo.entity.Course;
import com.akcreations.jpademo.entity.FullTimeEmployee;
import com.akcreations.jpademo.entity.PartTimeEmployee;
import com.akcreations.jpademo.entity.Review;
import com.akcreations.jpademo.entity.Student;
import com.akcreations.jpademo.repository.CourseRepository;
import com.akcreations.jpademo.repository.EmployeeRepository;
import com.akcreations.jpademo.repository.StudentRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {
     Logger logger = LoggerFactory.getLogger(this.getClass());
     
     @Autowired
     CourseRepository courseRepo;
     
     @Autowired
     StudentRepository studentRepo;
     
     @Autowired
     EmployeeRepository empRepo;
     
     public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * List<Review> reviews = new ArrayList<>();
		 * 
		 * reviews.add(new Review("5","Great Course")); reviews.add(new
		 * Review("5","Awesome Course"));
		 * 
		 * courseRepo.addReviewsForCourse(1003, reviews);
		 */
		empRepo.save(new FullTimeEmployee("Josh", 1000000L));
		empRepo.save(new PartTimeEmployee("Anantha", 100L));
		
		logger.info("List of All employees {}",empRepo.findall());
	/*	studentRepo.saveStudentWithPassport();
		
		logger.info("find 1001: {}" ,repo.findById(1001));
//		logger.info("deleting course 1002");
//		repo.deleteById(1002);
		logger.info("Insering new Course {}", repo.save(new Course("test")));
	}*/
		
	/*
	 * logger.info("Play with entity manager"); repo.playWithEntityManager();
	 */
	}

}
