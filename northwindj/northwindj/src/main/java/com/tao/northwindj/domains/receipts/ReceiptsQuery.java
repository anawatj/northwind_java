package com.tao.northwindj.domains.receipts;

import java.util.Date;

import com.tao.northwindj.domains.AbstractQuery;

public class ReceiptsQuery extends AbstractQuery{
		public ReceiptsQuery()
		{
			
		}
		private String receiptCode;
		private Date receiptDateStart;
		private Date receiptDateEnd;
		private Long employee;
		private Long customer;
		public String getReceiptCode() {
			return receiptCode;
		}
		public void setReceiptCode(String receiptCode) {
			this.receiptCode = receiptCode;
		}
		public Date getReceiptDateStart() {
			return receiptDateStart;
		}
		public void setReceiptDateStart(Date receiptDateStart) {
			this.receiptDateStart = receiptDateStart;
		}
		public Date getReceiptDateEnd() {
			return receiptDateEnd;
		}
		public void setReceiptDateEnd(Date receiptDateEnd) {
			this.receiptDateEnd = receiptDateEnd;
		}
		public Long getEmployee() {
			return employee;
		}
		public void setEmployee(Long employee) {
			this.employee = employee;
		}
		public Long getCustomer() {
			return customer;
		}
		public void setCustomer(Long customer) {
			this.customer = customer;
		}
}
