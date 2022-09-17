package com.rps.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="ct_emps")
public class Employee {
	@Id
	@Column(name="eid",length=10)
	@Min(value = 2999,message = "Enter Valid Employee Id")
	@Max(value=9999,message="Enter employeeid in between 2999 to 9999")
	private int empId;
	@Column(length=15)
	@NotEmpty(message = "name can't be null or empty")
	@NotBlank(message = "name can't be null or whitespace")
	private String empName;
	@Min(value = 0,message = "Enter positive value")
	private long empSal;
	@Column(length=15)
	private String empAdd;
	
	private String empDesg;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public long getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	public String getEmpAdd() {
		return empAdd;
	}

	public void setEmpAdd(String empAdd) {
		this.empAdd = empAdd;
	}

	public String getEmpDesg() {
		return empDesg;
	}

	public void setEmpDesg(String empDesg) {
		this.empDesg = empDesg;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", empAdd=" + empAdd
				+ ", empDesg=" + empDesg + "]";
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, long empSal, String empAdd, String empDesg) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.empAdd = empAdd;
		this.empDesg = empDesg;
	}
}
