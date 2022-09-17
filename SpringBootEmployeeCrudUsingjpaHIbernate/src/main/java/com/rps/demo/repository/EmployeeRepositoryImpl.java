package com.rps.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rps.demo.exceptions.EmployeeIdNotFound;
import com.rps.demo.model.Employee;

//1.x tomcat ,2.x hikari
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public String deleteById(int id) {
		Employee emp=getEmployeeById(id);
		if(emp==null)
		{
			throw new EmployeeIdNotFound("Enter Valid Employee Id");
		}{
		entityManager.remove(emp);
		}
		return "Employee Deleted Successfully";
	}

	@Override
	public List<Employee> getAllEmployee() {
		TypedQuery<Employee> employees = entityManager.createQuery("select e from Employee e", Employee.class);
		return employees.getResultList();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp = entityManager.find(Employee.class, id);
		if (emp == null) {
			throw new EmployeeIdNotFound("Enter Valid Employee Id");
		}
		return emp;
	}

	@Override
	public String employeeCreation(Employee emp) {
		entityManager.persist(emp);
		return "Employee Created Successfully";
	}

	@Override
	public String updateEmployee(Employee emp) {
		entityManager.merge(emp);
		return "Employee Updated Successfully";
	}

	@Override
	public List<Employee> getAllEmployeeInBetween(long minSal, long maxSal) {
		TypedQuery<Employee> employees = entityManager
				.createQuery("select e from Employee e where e.empSal between ?1 and ?2", Employee.class);
		employees.setParameter(1, minSal);
		employees.setParameter(2, maxSal);
		return employees.getResultList();
	}

}
