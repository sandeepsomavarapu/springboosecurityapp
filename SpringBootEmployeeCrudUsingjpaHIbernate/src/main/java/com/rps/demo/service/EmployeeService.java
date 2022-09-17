package com.rps.demo.service;

import java.util.List;

import com.rps.demo.model.Employee;

public interface EmployeeService {
	String deleteById(int id);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	String employeeCreation(Employee emp);

	String updateEmployee(Employee emp);

	List<Employee> getAllEmployeeInBetween(long minSal, long maxSal);

}
