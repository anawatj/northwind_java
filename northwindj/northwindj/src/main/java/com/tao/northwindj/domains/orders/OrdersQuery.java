package com.tao.northwindj.domains.orders;

import java.util.Date;

import com.tao.northwindj.domains.AbstractQuery;

public class OrdersQuery extends AbstractQuery {
	
	public OrdersQuery()
	{
		
	}
	private Long customer;
	private Long employee;
	private Date orderDateStart;
	private Date orderDateEnd;
	private Date requireDateStart;
	private Date requireDateEnd;
	private String orderCode;
	
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Long getCustomer() {
		return customer;
	}
	public void setCustomer(Long customer) {
		this.customer = customer;
	}
	public Long getEmployee() {
		return employee;
	}
	public void setEmployee(Long employee) {
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
