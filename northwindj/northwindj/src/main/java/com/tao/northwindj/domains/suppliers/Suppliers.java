package com.tao.northwindj.domains.suppliers;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.City;
import com.tao.northwindj.domains.master.Country;
import com.tao.northwindj.domains.master.Regions;

public class Suppliers extends AbstractDomain<Long>{
	public Suppliers()
	{
		
	}
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private City city;
	private Regions region;
	private String postalCode;
	private Country country;
	private String phone;
	private String fax;
	private String homePage;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public City getCity() {
		if(this.city!=null &&(this.city.getId()==null || this.city.getId()==0))
		{
			return null;
		}
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Regions getRegion() {
		if(this.region!=null &&(this.region.getId()==null || this.region.getId()==0))
		{
			return null;
		}
		return region;
	}
	public void setRegion(Regions region) {
		this.region = region;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public Country getCountry() {
		if(this.country!=null && (this.country.getId()==null || this.country.getId()==0))
		{
			return null;
		}
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getHomePage() {
		return homePage;
	}
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}
	
	
}
