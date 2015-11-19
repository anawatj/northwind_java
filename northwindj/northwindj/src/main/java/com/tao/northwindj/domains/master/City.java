package com.tao.northwindj.domains.master;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.SimpleMasterObject;
@JsonInclude(value=Include.NON_NULL)
public class City extends SimpleMasterObject {
	public City()
	{
		
	}
	private Long countryId;
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	
}
