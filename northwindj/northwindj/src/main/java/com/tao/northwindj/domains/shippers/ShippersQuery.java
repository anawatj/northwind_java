package com.tao.northwindj.domains.shippers;

import com.tao.northwindj.domains.AbstractQuery;

public class ShippersQuery extends AbstractQuery {
	
	public ShippersQuery()
	{
		
	}
	private String companyName;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
}
