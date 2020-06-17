package com.akcreations.dbdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;





@Entity
@NamedQuery(name="find_all_persons",query="select p from Person p")
public class Person {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer personId;
	
	@Column(name="name")
	private String personName;
	
	@Column(name="location")
	private String location;
	
	@Column(name="dob")
	private Date personDob;
	

	public Person() {
		super();
		this.personId = null;
		this.personName = null;
		this.location = null;
		this.personDob = null;
	}

	public Person(Integer personId, String personName, String location, Date personDob) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.location = location;
		this.personDob = personDob;
	}

	public Person(String personName, String location, Date personDob) {
		super();
		this.personName = personName;
		this.location = location;
		this.personDob = personDob;
	}
	

   
	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getPersonDob() {
		return personDob;
	}

	public void setPersonDob(Date personDob) {
		this.personDob = personDob;
	}

	@Override
	public String toString() {
		return "\n Person [personId=" + personId + ", personName=" + personName + ", location=" + location + ", personDob="
				+ personDob + "]";
	}
	
	

}
