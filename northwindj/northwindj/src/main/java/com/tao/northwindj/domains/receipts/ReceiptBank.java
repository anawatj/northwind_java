package com.tao.northwindj.domains.receipts;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.Bank;
import com.tao.northwindj.domains.master.BankBranch;

@JsonInclude(value=Include.NON_NULL)
public class ReceiptBank extends AbstractDomain<Long>{
	public ReceiptBank()
	{
		
	}
	private Long receiptId;
	private Date transferDate;
	private Bank bank;
	private BankBranch bankBranch;
	private String bankAccount;
	private Double bankAmt;
	public Long getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(Long receiptId) {
		this.receiptId = receiptId;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public Bank getBank() {
		if(this.bank!=null && (this.bank.getId()==null || this.bank.getId()==0))
		{
			return null;
		}
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public BankBranch getBankBranch() {
		if(this.bankBranch!=null && (this.bankBranch.getId()==null || this.bankBranch.getId()==0))
		{
			return null;
		}
		return bankBranch;
	}
	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public Double getBankAmt() {
		return bankAmt;
	}
	public void setBankAmt(Double bankAmt) {
		this.bankAmt = bankAmt;
	}
	
}
