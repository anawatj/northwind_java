package com.tao.northwindj.domains.payments;

import java.util.Date;

import com.tao.northwindj.domains.AbstractQuery;

public class PaymentsQuery extends AbstractQuery {

		public PaymentsQuery()
		{
			
		}
		private String paymentCode;
		private Date paymentDateStart;
		private Date paymentDateEnd;
		private Long employee;
		private Long supplier;
		public String getPaymentCode() {
			return paymentCode;
		}
		public void setPaymentCode(String paymentCode) {
			this.paymentCode = paymentCode;
		}
		public Date getPaymentDateStart() {
			return paymentDateStart;
		}
		public void setPaymentDateStart(Date paymentDateStart) {
			this.paymentDateStart = paymentDateStart;
		}
		public Date getPaymentDateEnd() {
			return paymentDateEnd;
		}
		public void setPaymentDateEnd(Date paymentDateEnd) {
			this.paymentDateEnd = paymentDateEnd;
		}
		public Long getEmployee() {
			return employee;
		}
		public void setEmployee(Long employee) {
			this.employee = employee;
		}
		public Long getSupplier() {
			return supplier;
		}
		public void setSupplier(Long supplier) {
			this.supplier = supplier;
		}
}
