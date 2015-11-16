package com.tao.northwindj.domains.orders;

import java.util.Date;

import com.tao.northwindj.domains.AbstractQuery;

public class OrdersQuery extends AbstractQuery {
	
	public OrdersQuery()
	{
		
	}
	private Integer customer;
	private Integer employee;
	private Date orderDateStart;
	private Date orderDateEnd;
	private Date requireDateStart;
	private Date requireDateEnd;
	
	public Integer getCustomer() {
		return customer;
	}
	public void setCustomer(Integer customer) {
		this.customer = customer;
	}
	public Integer getEmployee() {
		return employee;
	}
	public void setEmployee(Integer employee) {
		this.employee = employee;
	}
	public Date getOrderDateStart() {
		return orderDateStart;
	}
	public void setOrderDateStart(Date orderDateStart) {
		this.orderDateStart = orderDateStart;
	}
	public Date getOrderDateEnd() {
		return orderDateEnd;
	}
	public void setOrderDateEnd(Date orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}
	public Date getRequireDateStart() {
		return requireDateStart;
	}
	public void setRequireDateStart(Date requireDateStart) {
		this.requireDateStart = requireDateStart;
	}
	public Date getRequireDateEnd() {
		return requireDateEnd;
	}
	public void setRequireDateEnd(Date requireDateEnd) {
		this.requireDateEnd = requireDateEnd;
	}
	
}
