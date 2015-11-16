package com.tao.northwindj.domains.shippers;

import com.tao.northwindj.domains.AbstractDomain;

public class Shippers extends AbstractDomain<Long>{
	public Shippers()
	{
		
	}
	private String companyName;
	private String phone;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
