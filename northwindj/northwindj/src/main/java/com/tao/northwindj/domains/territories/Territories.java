package com.tao.northwindj.domains.territories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.Regions;
@JsonInclude(value=Include.NON_NULL)
public class Territories extends AbstractDomain<Long>{
	
	public Territories()
	{
		
	}
	private String name;
	private Regions region;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
