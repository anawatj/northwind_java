package com.tao.northwindj.domains.employees;

import com.tao.northwindj.domains.AbstractQuery;

public class EmployeesQuery extends AbstractQuery {
	
	public EmployeesQuery()
	{
		
	}
	private String firstName;
	private String lastName;
	private Long department;
	private String employeeCode;
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getDepartment() {
		return department;
	}
	public void setDepartment(Long department) {
		this.department = department;
	}
	
}
