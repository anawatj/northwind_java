package com.tao.northwindj.domains.employees;

import com.tao.northwindj.domains.AbstractQuery;

public class EmployeesQuery extends AbstractQuery {
	
	public EmployeesQuery()
	{
		
	}
	private String firstName;
	private String lastName;
	private Integer department;
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
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	
}
