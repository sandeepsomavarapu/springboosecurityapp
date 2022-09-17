package com.rps.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rps.demo.model.Employee;
import com.rps.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository repo;

	@Override
	public String deleteById(int id) {

		return repo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return repo.getAllEmployee();
	}

	@Override
	public Employee getEmployeeById(int id) {
			
		return repo.getEmployeeById(id);
	}

	@Override
	public String employeeCreation(Employee emp) {
		return repo.employeeCreation(emp);
	}

	@Override
	public String updateEmployee(Employee emp) {
		return repo.updateEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployeeInBetween(long minSal, long maxSal) {
		return repo.getAllEmployeeInBetween(minSal, maxSal);
	}

}
