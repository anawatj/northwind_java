package com.tao.northwindj.domains;

public abstract class AbstractQuery implements java.io.Serializable {
	public AbstractQuery()
	{
		
	}
	
	private Integer page;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
}
