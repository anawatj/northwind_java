package com.tao.northwindj.domains.receipts;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;

@JsonInclude(value=Include.NON_NULL)
public class ReceiptCash extends AbstractDomain<Long> {
	public ReceiptCash()
	{
		
	}
	private Long receiptId;
	private Date receiptDate;
	private Double cashAmt;
	
	public Long getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}
	public Date getReceiptDate() {
		return receiptDate;
	}
	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}
	public Double getCashAmt() {
		return cashAmt;
	}
	public void setCashAmt(Double cashAmt) {
		this.cashAmt = cashAmt;
	}
}
