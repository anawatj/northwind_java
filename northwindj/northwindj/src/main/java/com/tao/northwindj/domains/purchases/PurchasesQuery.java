package com.tao.northwindj.domains.purchases;

import java.util.Date;

import com.tao.northwindj.domains.AbstractQuery;

public class PurchasesQuery extends AbstractQuery{
	
	public PurchasesQuery()
	{
		
	}
	private Long supplier;
	private Long employee;
	private Date purchaseDateStart;

	private Date purchaseDateEnd;
	private Date requireDateStart;
	private Date requireDateEnd;
	
	
	public Long getSupplier() {
		return supplier;
	}
	public void setSupplier(Long supplier) {
		this.supplier = supplier;
	}
	public Long getEmployee() {
		return employee;
	}
	public void setEmployee(Long employee) {
		this.employee = employee;
	}
	public Date getPurchaseDateStart() {
		return purchaseDateStart;
	}
	public void setPurchaseDateStart(Date purchaseDateStart) {
		this.purchaseDateStart = purchaseDateStart;
	}
	public Date getPurchaseDateEnd() {
		return purchaseDateEnd;
	}
	public void setPurchaseDateEnd(Date purchaseDateEnd) {
		this.purchaseDateEnd = purchaseDateEnd;
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
