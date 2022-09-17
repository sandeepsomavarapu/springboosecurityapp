package com.rps.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rps.demo.model.Employee;

public interface EmployeeRepository  {
	String deleteById(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	String employeeCreation(Employee emp);

	String updateEmployee(Employee emp);

	List<Employee> getAllEmployeeInBetween(long minSal, long maxSal);

}
