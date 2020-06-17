package com.akcreations.jpademo.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "Employee_Type")
public abstract class Employee {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	
	protected Employee()
	{
		
	}

	public Employee(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
		
}
