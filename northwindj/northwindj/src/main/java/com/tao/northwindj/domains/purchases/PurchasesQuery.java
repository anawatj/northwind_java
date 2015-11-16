package com.tao.northwindj.domains.purchases;

import java.util.Date;

import com.tao.northwindj.domains.AbstractQuery;

public class PurchasesQuery extends AbstractQuery{
	
	public PurchasesQuery()
	{
		
	}
	private Integer supplier;
	private Integer employee;
	private Date purchaseDateStart;
	public Integer getSupplier() {
		return supplier;
	}
	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}
	public Integer getEmployee() {
		return employee;
	}
	public void setEmployee(Integer employee) {
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
	private Date purchaseDateEnd;
	private Date requireDateStart;
	private Date requireDateEnd;
	
}
