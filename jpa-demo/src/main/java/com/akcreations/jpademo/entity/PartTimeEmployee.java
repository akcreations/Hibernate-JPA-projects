package com.akcreations.jpademo.entity;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee{
	
	private long hourlyWage;
     
 	protected PartTimeEmployee() {
 		
 	}
	public PartTimeEmployee(String name, long hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	public long getSalary() {
		return hourlyWage;
	}
	public void setSalary(long hourlyWage) {
		this.hourlyWage = hourlyWage;
	}
	
}
