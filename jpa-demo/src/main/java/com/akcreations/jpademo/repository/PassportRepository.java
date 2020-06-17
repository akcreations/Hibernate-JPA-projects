package com.akcreations.jpademo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akcreations.jpademo.entity.Passport;
import com.akcreations.jpademo.entity.Student;

@Repository
@Transactional
public class PassportRepository {
    
	@PersistenceContext
	EntityManager em;
	
	public Passport findByPassportId(int passportId)
	{
		return em.find(Passport.class, passportId);
	}

}
