package com.tao.northwindj.domains.categories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;
@JsonInclude(value=Include.NON_NULL)
public class Categories extends AbstractDomain<Long> {
	public Categories()
	{
		
	}
	private String categoryName;
	private String description;
	private String categoryCode;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
