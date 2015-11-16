package com.tao.northwindj.domains;

public abstract class SimpleMasterObject extends AbstractDomain<Long> {
	
	public SimpleMasterObject()
	{
		
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
