package com.akcreations.dbdemo.rowmapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

import com.akcreations.dbdemo.entity.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person person = new Person();
		person.setPersonId(rs.getInt("id"));
		person.setPersonName(rs.getString("name"));
		person.setLocation(rs.getString("location"));
		person.setPersonDob(new Date (rs.getTimestamp("dob").getTime()));
		return person;
	}
	




}
