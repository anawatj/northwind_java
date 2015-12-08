package com.tao.northwindj.domains.suppliers;

import com.tao.northwindj.domains.AbstractQuery;

public class SuppliersQuery extends AbstractQuery {
	
	public SuppliersQuery()
	{
		
	}
	private String companyName;
	private String contactName;
	private String contactTitle;
	private Long city;
	private Long region;
	private Long country;
	private String supplierCode;
	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
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
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	public Long getRegion() {
		return region;
	}
	public void setRegion(Long region) {
		this.region = region;
	}
	public Long getCountry() {
		return country;
	}
	public void setCountry(Long country) {
		this.country = country;
	}
}
