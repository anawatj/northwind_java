package com.tao.northwindj.domains.employees;

import java.util.Date;

import com.tao.northwindj.domains.AbstractDomain;

public class Experiences extends AbstractDomain<Long> {
	public Experiences()
	{
		
	}
	private Long employeeId;
	private String company;
	private Date start;
	private Date end;
	private Double salary;
	private String reasonOfResign;
	
	private boolean selected;
	
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getReasonOfResign() {
		return reasonOfResign;
	}
	public void setReasonOfResign(String reasonOfResign) {
		this.reasonOfResign = reasonOfResign;
	}
}
