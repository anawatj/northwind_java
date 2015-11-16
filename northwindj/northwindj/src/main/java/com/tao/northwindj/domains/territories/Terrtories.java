package com.tao.northwindj.domains.territories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.master.Regions;
@JsonInclude(value=Include.NON_NULL)
public class Terrtories extends AbstractDomain<Long>{
	
	public Terrtories()
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
		return region;
	}
	public void setRegion(Regions region) {
		this.region = region;
	}
}
