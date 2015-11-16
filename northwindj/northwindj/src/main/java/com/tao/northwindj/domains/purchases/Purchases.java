package com.tao.northwindj.domains.purchases;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.shippers.Shippers;
import com.tao.northwindj.domains.suppliers.Suppliers;

public class Purchases  extends AbstractDomain<Long>{
	
	public Purchases()
	{
		this.details = new HashSet<PurchaseDetails>();
	}
	private Suppliers supplier;
	private Employees employee;
	private Date purchaseDate;
	private Date requireDate;
	private Date shippedDate;
	private Double freight;
	private Shippers shipper;
	private Set<PurchaseDetails> details;	
	
	public Set<PurchaseDetails> getDetails() {
		return details;
	}
	public void setDetails(Set<PurchaseDetails> details) {
		this.details = details;
	}
	
	public Shippers getShipper() {
		if(this.shipper!=null &&(this.shipper.getId()==null || this.shipper.getId()==0))
		{
			return null;
		}
		return shipper;
	}
	public void setShipper(Shippers shipper) {
		this.shipper = shipper;
	}
	public Suppliers getSupplier() {
		if(this.supplier!=null && (this.supplier.getId()==null || this.supplier.getId()==0))
		{
			return null;
		}
		return supplier;
	}
	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
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
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public Date getRequireDate() {
		return requireDate;
	}
	public void setRequireDate(Date requireDate) {
		this.requireDate = requireDate;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	
	
}
