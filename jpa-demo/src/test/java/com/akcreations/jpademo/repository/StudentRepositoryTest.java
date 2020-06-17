package com.akcreations.jpademo.repository;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.akcreations.jpademo.entity.Passport;
import com.akcreations.jpademo.entity.Student;


@SpringBootTest
class StudentRepositoryTest {
	

    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    StudentRepository repo;
    
    @Autowired
    PassportRepository repo2;
    
  
	
    @Test
    @Transactional	
	void testgetStudentById() {
		Student student = repo.findById(2001);
		logger.info("Student ->{}",student);
		logger.info("Passport ->{}",student.getPassport());
	}
    
    @Test
    @Transactional
	void testgetStudentByPassport() {
		Passport passport = repo2.findByPassportId(3001);
		logger.info("Student ->{}",passport);
		logger.info("Passport ->{}",passport.getStudent());
	}

}
