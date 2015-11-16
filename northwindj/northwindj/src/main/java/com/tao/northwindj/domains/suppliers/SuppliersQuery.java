package com.tao.northwindj.domains.suppliers;

import com.tao.northwindj.domains.AbstractQuery;

public class SuppliersQuery extends AbstractQuery {
	
	public SuppliersQuery()
	{
		
	}
	private String companyName;
	private String contactName;
	private String contactTitle;
	private Integer city;
	private Integer region;
	private Integer country;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactTitle() {
		return contactTitle;
	}
	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
	public Integer getCountry() {
		return country;
	}
	public void setCountry(Integer country) {
		this.country = country;
	}
}
