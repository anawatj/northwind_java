package com.tao.northwindj.domains.master;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.SimpleMasterObject;

@JsonInclude(value=Include.NON_NULL)
public class BankBranch extends SimpleMasterObject {
	public BankBranch()
	{
		
	}
	private Long bankId;
	public Long getBankId() {
		return bankId;
	}
	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
}
