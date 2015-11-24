package com.tao.northwindj.domains.territories;

import com.tao.northwindj.domains.AbstractQuery;

public class TerritoriesQuery extends AbstractQuery {
	
	
	public TerritoriesQuery()
	{
		
	}
	private String name;
	private Integer region;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRegion() {
		return region;
	}
	public void setRegion(Integer region) {
		this.region = region;
	}
}
