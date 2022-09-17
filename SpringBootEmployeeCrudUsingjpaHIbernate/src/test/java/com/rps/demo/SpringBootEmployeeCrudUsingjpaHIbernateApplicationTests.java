package com.rps.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rps.demo.model.Employee;
import com.rps.demo.repository.EmployeeRepository;
import com.rps.demo.service.EmployeeService;

@SpringBootTest
class SpringBootEmployeeCrudUsingjpaHIbernateApplicationTests {
	@MockBean
	EmployeeRepository dao;
	@Autowired
	EmployeeService service;

//	@Test
//	public void testAddEmployee()
//	{
//		Employee emp=new Employee(7745,"mahesh",7890,"hyderanad","trainer");
//		String message=service.employeeCreation(emp);
//		assertEquals("Employee Created Successfully",message);
//	}
//	@Test
//	public void testGetEmployee() {
//		Employee emp = service.getEmployeeById(111);
//		assertEquals("naresh", emp.getEmpName());
//	}

	@Test
	public void testAddEmployee() {
		Employee emp = new Employee(7745, "mahesh", 7890, "hyderanad", "trainer");

		Mockito.doReturn("Employee Created Successfully").when(dao).employeeCreation(emp);

		String result = service.employeeCreation(emp);
		assertEquals("Employee Created Successfully", result);
	}
	@Test
	public void testGetEmployee() {
		Employee emp = new Employee(111, "mahesh", 7890, "hyderanad", "trainer");

		Mockito.doReturn(emp).when(dao).getEmployeeById(111);
		Employee emp2 = service.getEmployeeById(111);
		assertEquals("mahesh", emp2.getEmpName());
	}
}
