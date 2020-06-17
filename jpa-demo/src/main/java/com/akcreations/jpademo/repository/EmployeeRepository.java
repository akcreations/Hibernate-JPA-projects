package com.akcreations.jpademo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.akcreations.jpademo.entity.Course;
import com.akcreations.jpademo.entity.Passport;
import com.akcreations.jpademo.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {
    
	@PersistenceContext
	EntityManager em;
	
	public Employee findById(int employeeId)
	{
		return em.find(Employee.class, employeeId);
	}
	

	public Employee save(Employee employee) {

		if(employee.getId()==null)
		{
			 em.persist(employee);
		}
		else {
			em.merge(employee);
		}
		
		return employee;
	}
	
	public List<Employee> findall()
	{
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}
}
