package com.tao.northwindj.domains.territories;

import com.tao.northwindj.domains.AbstractQuery;

public class TerritoriesQuery extends AbstractQuery {
	
	
	public TerritoriesQuery()
	{
		
	}
	private String name;
	private Long region;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRegion() {
		return region;
	}
	public void setRegion(Long region) {
		this.region = region;
	}
}
