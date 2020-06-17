package com.akcreations.dbdemo.jdbcmethod;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.akcreations.dbdemo.entity.Person;
import com.akcreations.dbdemo.rowmapper.PersonRowMapper;

@Repository
public class PersonJdbcDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAllPersons()
	{
		return jdbcTemplate.query("select * from person", new PersonRowMapper());
	}
	
	public Person findPersonById(int personId)
	{
		return jdbcTemplate.queryForObject("select * from person where id= ? ",new Object[] {personId} , new PersonRowMapper());
	}
	
	public int addNewPerson(Person p)
	{
		return jdbcTemplate.update("insert into person (id,name,location,dob)"
				+ " values(?,?,?,?) ",
				new Object[] {p.getPersonId(),
						p.getPersonName(),
						p.getLocation(),
						p.getPersonDob()} );
	}
	
	public int updatePerson(Person p)
	{
		return jdbcTemplate.update("update person"
				+ " set name=?, location=?, dob=?"
				+ "  where id=?",
				new Object[] {
						p.getPersonName(),
						p.getLocation(),
						p.getPersonDob(),
						p.getPersonId()} );
	}
	
	public int deleteByPersonId(int personId)
	{
		return jdbcTemplate.update("delete from person"
				+ "  where id=?",
				new Object[] {personId} );
	}


}
