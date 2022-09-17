package com.rps.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.rps.demo.exceptions.EmployeeIdNotFound;
import com.rps.demo.exceptions.ExceptionResponse;
import com.rps.demo.model.Employee;
import com.rps.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee") // http://localhost:7878/employee
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping("/addemployee") // http://localhost:7878/employee/addemployee
	public String addEmployee(@Valid@RequestBody Employee emp) {
		return service.employeeCreation(emp);
	}

	@GetMapping("/getemployee/{id}") // http://localhost:7878/employee/getemployee/123
	public Employee getEmployee(@PathVariable("id") int empId) {
		return service.getEmployeeById(empId);
	}

	@GetMapping("/getallemployee") // http://localhost:7878/employee/getallemployee
	public List<Employee> getAllEmployees() {
		return service.getAllEmployee();
	}
	@GetMapping("/getallemployees/{minsal}/{maxsal}") // http://localhost:7878/employee/getallemployees/20000/30000
	public List<Employee> getAllEmployeesInBetween(@PathVariable("minsal") long minSal,@PathVariable("maxsal")long maxSal) {
		return service.getAllEmployeeInBetween(minSal, maxSal);
	}
	@PutMapping("/updateemployee") // http://localhost:7878/employee/updateemployee
	public String updateEmployee(@Valid@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}

	@DeleteMapping("/deleteemployee/{eid}") // http://localhost:7878/employee/deleteemployee/123
	public String addEmployee(@PathVariable("eid") int empId) {
		return service.deleteById(empId);
	}
	
}
