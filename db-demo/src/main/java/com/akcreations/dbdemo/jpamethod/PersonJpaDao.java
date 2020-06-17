package com.akcreations.dbdemo.jpamethod;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;


import org.springframework.stereotype.Repository;

import com.akcreations.dbdemo.entity.Person;

@Repository
@Transactional
public class PersonJpaDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findPersonById(int personId) {
		return entityManager.find(Person.class,personId);
	}
	
	public Person addNewPerson(Person p) {
		return entityManager.merge(p);
	}
	
	public Person updatePerson(Person p) {
		return entityManager.merge(p);
	}
	
	public void deleteById(int personId)
	{
		Person removePerson = findPersonById(personId);
		entityManager.remove(removePerson);
	}
	
	public List<Person> findAllPersons(){
		
		  TypedQuery<Person> namedQuery =
		  entityManager.createNamedQuery("find_all_persons", Person.class); return
		  namedQuery.getResultList();
		 

	}

}
