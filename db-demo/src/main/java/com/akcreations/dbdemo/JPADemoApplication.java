package com.akcreations.dbdemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.akcreations.dbdemo.entity.Person;
import com.akcreations.dbdemo.jdbcmethod.PersonJdbcDao;
import com.akcreations.dbdemo.jpamethod.PersonJpaDao;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaDao personDao;

	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		logger.info("Find person with id 10002: {}", personDao.findPersonById(1002));
		
		Person P4 = new Person("abhay","agra",new Date());
		logger.info("inserting new person {}",personDao.addNewPerson(P4));
		
		Person p3 = new Person (1003,"Arjun","kochi",new Date());
		logger.info("update operation executed {}",personDao.updatePerson(p3));
		
		logger.info("deleting the person by id:1002 ");personDao.deleteById(1002);
		 
		
		
		logger.info("Get All persons: {}", personDao.findAllPersons());
		//
		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * ;
		 */ 
	}

}
