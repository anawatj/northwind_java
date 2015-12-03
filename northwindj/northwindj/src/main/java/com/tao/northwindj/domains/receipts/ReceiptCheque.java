package com.tao.northwindj.domains.receipts;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.Bank;
import com.tao.northwindj.domains.master.BankBranch;

@JsonInclude(value=Include.NON_NULL)
public class ReceiptCheque extends AbstractDomain<Long> {
		public ReceiptCheque()
		{
			
		}
		private Long receiptId;
		private String chequeNo;
		private Date chequeDate;
		private Bank chequeBank;
		private BankBranch chequeBankBranch;
		private Double chequeAmt;
		public Long getReceiptId() {
			return receiptId;
		}
		public void setReceiptId(Long receiptId) {
			this.receiptId = receiptId;
		}
		public String getChequeNo() {
			return chequeNo;
		}
		public void setChequeNo(String chequeNo) {
			this.chequeNo = chequeNo;
		}
		public Date getChequeDate() {
			return chequeDate;
		}
		public void setChequeDate(Date chequeDate) {
			this.chequeDate = chequeDate;
		}
		public Bank getChequeBank() {
			if(this.chequeBank!=null && (this.chequeBank.getId()==null || this.chequeBank.getId()==0))
			{
				return null;
			}
			return chequeBank;
		}
		public void setChequeBank(Bank chequeBank) {
			this.chequeBank = chequeBank;
		}
		public BankBranch getChequeBankBranch() {
			if(this.chequeBankBranch!=null &&(this.chequeBankBranch.getId()==null || this.chequeBankBranch.getId()==0))
			{
				return null;
			}
			return chequeBankBranch;
		}
		public void setChequeBankBranch(BankBranch chequeBankBranch) {
			this.chequeBankBranch = chequeBankBranch;
		}
		public Double getChequeAmt() {
			return chequeAmt;
		}
		public void setChequeAmt(Double chequeAmt) {
			this.chequeAmt = chequeAmt;
		}
		
}
