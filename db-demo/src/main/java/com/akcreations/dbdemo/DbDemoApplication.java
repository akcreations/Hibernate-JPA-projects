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

//@SpringBootApplication
public class DbDemoApplication implements CommandLineRunner {
     private  Logger logger = LoggerFactory.getLogger(this.getClass());
     @Autowired
     PersonJdbcDao personDao;
     
	public static void main(String[] args) {
		SpringApplication.run(DbDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Get All persons: {}", personDao.findAllPersons());
		logger.info("Find person with id 10002: {}", personDao.findPersonById(1002));
		
		Person P4 = new Person(1004,"abhay","agra",new Date());
		
		logger.info("inserting new person {}",P4,personDao.addNewPerson(P4));
		
		Person p3 = new Person (1003,"Arjun","kochi",new Date());
		logger.info("update operation executed",personDao.updatePerson(p3));
		
		logger.info("deleting the person by id: 1002 ",personDao.deleteByPersonId(1002));
		
	}
	
	

}
