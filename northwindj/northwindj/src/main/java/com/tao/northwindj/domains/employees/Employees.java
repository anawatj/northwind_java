package com.tao.northwindj.domains.employees;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.City;
import com.tao.northwindj.domains.master.Country;
import com.tao.northwindj.domains.master.Regions;
import com.tao.northwindj.domains.master.Title;
import com.tao.northwindj.domains.territories.Territories;

public class Employees extends AbstractDomain<Long> {
	
	public Employees()
	{
		this.territories = new HashSet<Territories>();
		this.educations = new HashSet<Education>();
		this.experiences = new HashSet<Experiences>();
	}
	private Title title;
	private String firstName;
	private String lastName;
	private String titleOfCourstesy;
	private Date birthDate;
	private Date hireDate;
	private String address;
	private City city;
	private Regions region;
	private String postalCode;
	private Country country;
	private String homePhone;
	private String extention;
	private String notes;
	private Employees reportTo;
	private Set<Territories> territories;
	private Set<Education> educations;
	private Set<Experiences> experiences;
	public Set<Territories> getTerritories() {
		return territories;
	}
	public void setTerritories(Set<Territories> territories) {
		this.territories = territories;
	}
	public Set<Education> getEducations() {
		return educations;
	}
	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}
	public Set<Experiences> getExperiences() {
		return experiences;
	}
	public void setExperiences(Set<Experiences> experiences) {
		this.experiences = experiences;
	}
	public Title getTitle(){
		if(this.title!=null &&(this.title.getId()==null || this.title.getId()==0))
		{
			return null;
		}
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitleOfCourstesy() {
		return titleOfCourstesy;
	}
	public void setTitleOfCourstesy(String titleOfCourstesy) {
		this.titleOfCourstesy = titleOfCourstesy;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
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
			return this.city;
		}
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public Regions getRegion() {
		if(this.region!=null && (this.region.getId()==null || this.region.getId()==0))
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
		if(this.country!=null &&(this.country.getId()==null || this.country.getId()==0))
		{
			return null;
		}
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getExtention() {
		return extention;
	}
	public void setExtention(String extention) {
		this.extention = extention;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Employees getReportTo() {
		if(reportTo!=null && (reportTo.getId()==null || reportTo.getId()==0))
		{
			return null;
		}
		return reportTo;
	}
	public void setReportTo(Employees reportTo) {
		this.reportTo = reportTo;
	}
	
	
}
