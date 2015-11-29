package com.tao.northwindj.domains.employees;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.EducationLevel;

public class Education extends AbstractDomain<Long> {
	
	public Education()
	{
		
	}
	private Long employeeId;
	private EducationLevel educationLevel;
	private String university;
	private String major;
	private String minor;
	private Double gpa;
	private boolean selected;
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public EducationLevel getEducationLevel() {
		if(educationLevel!=null && (educationLevel.getId()==null||educationLevel.getId()==0))
		{
			return null;
		}
		return educationLevel;
	}
	public void setEducationLevel(EducationLevel educationLevel) {
		this.educationLevel = educationLevel;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
}
