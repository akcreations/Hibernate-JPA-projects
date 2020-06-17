package com.akcreations.jpademo.entity;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{
	
	private long salary;
     
 
	public FullTimeEmployee(String name, long salary) {
		super(name);
		this.salary = salary;
	}
	protected FullTimeEmployee() {
		
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	
}
