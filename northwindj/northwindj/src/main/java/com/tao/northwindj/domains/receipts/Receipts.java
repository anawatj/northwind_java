package com.tao.northwindj.domains.receipts;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.customers.Customers;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.orders.Orders;

@JsonInclude(value=Include.NON_NULL)
public class Receipts extends AbstractDomain<Long> {
	
	public Receipts()
	{
		this.orders = new HashSet<Orders>();
		this.cashes =new HashSet<ReceiptCash>();
		this.cheques= new HashSet<ReceiptCheque>();
		this.banks = new HashSet<ReceiptBank>();
	}
	private String receiptCode;
	private Date receiptDate;
	private Employees employees;
	private Customers receiptFrom;
	private Double receiveTotal;
	private Double receiveAmt;
	private Set<Orders> orders;
	private Set<ReceiptCash> cashes;
	private Set<ReceiptCheque> cheques;
	private Set<ReceiptBank> banks;
	
	public Set<ReceiptCash> getCashes() {
		return cashes;
	}
	public void setCashes(Set<ReceiptCash> cashes) {
		this.cashes = cashes;
	}
	public Set<ReceiptCheque> getCheques() {
		return cheques;
	}
	public void setCheques(Set<ReceiptCheque> cheques) {
		this.cheques = cheques;
	}
	public Set<ReceiptBank> getBanks() {
		return banks;
	}
	public void setBanks(Set<ReceiptBank> banks) {
		this.banks = banks;
	}
	public String getReceiptCode() {
		return receiptCode;
	}
	public void setReceiptCode(String receiptCode) {
		this.receiptCode = receiptCode;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public Employees getEmployees() {
		if(this.employees!=null && (this.employees.getId()==null || this.employees.getId()==0))
		{
			return null;
		}
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public Customers getReceiptFrom() {
		if(this.receiptFrom!=null && (this.receiptFrom.getId()==null || this.receiptFrom.getId()==0))
		{
			return null;
		}
		return receiptFrom;
	}
	public void setReceiptFrom(Customers receiptFrom) {
		this.receiptFrom = receiptFrom;
	}
	public Double getReceiveTotal() {
		return receiveTotal;
	}
	public void setReceiveTotal(Double receiveTotal) {
		this.receiveTotal = receiveTotal;
	}
	public Set<Orders> getOrders() {
		return orders;
	}
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	public Double getReceiveAmt() {
		return receiveAmt;
	}
	public void setReceiveAmt(Double receiveAmt) {
		this.receiveAmt = receiveAmt;
	}
	
}
