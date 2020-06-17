package com.akcreations.jpademo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Integer id;

	private String number;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	protected Passport() {

	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public String getnumber() {
		return number;
	}

	public void setnumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}

}
