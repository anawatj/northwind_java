package com.tao.northwindj.domains.payments;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.purchases.Purchases;
import com.tao.northwindj.domains.suppliers.Suppliers;

@JsonInclude(value=Include.NON_NULL)
public class Payments extends AbstractDomain<Long>{
		
	public Payments()
	{
		
	}
	private String paymentCode;
	private Employees employee;
	private Date paymentDate;
	private Suppliers paymentTo;
	private Double paymentTotal;
	private Set<Purchases> purchases;
	public Set<Purchases> getPurchases() {
		return purchases;
	}
	public void setPurchases(Set<Purchases> purchases) {
		this.purchases = purchases;
	}
	public String getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}
	public Employees getEmployee() {
		if(this.employee!=null &&(this.employee.getId()==null || this.employee.getId()==0))
		{
			return null;
		}
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Suppliers getPaymentTo() {
		if(this.paymentTo!=null && (this.paymentTo.getId()==null || this.paymentTo.getId()==0))
		{
			return null;
		}
		return paymentTo;
	}
	public void setPaymentTo(Suppliers paymentTo) {
		this.paymentTo = paymentTo;
	}
	public Double getPaymentTotal() {
		return paymentTotal;
	}
	public void setPaymentTotal(Double paymentTotal) {
		this.paymentTotal = paymentTotal;
	}
	

	
	
}
