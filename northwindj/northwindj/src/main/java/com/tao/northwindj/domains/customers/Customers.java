package com.tao.northwindj.domains.customers;

import java.util.HashSet;
import java.util.Set;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.City;
import com.tao.northwindj.domains.master.Country;
import com.tao.northwindj.domains.master.DemoGraphics;
import com.tao.northwindj.domains.master.Regions;

public class Customers extends AbstractDomain<Long> {
	public Customers()
	{
		this.demos = new HashSet<DemoGraphics>();
	}
	private String customerCode;
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
	private Set<DemoGraphics> demos;
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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
	public Set<DemoGraphics> getDemos() {
		return demos;
	}
	public void setDemos(Set<DemoGraphics> demos) {
		this.demos = demos;
	}
	
}
