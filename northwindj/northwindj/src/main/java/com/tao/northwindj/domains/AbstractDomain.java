package com.tao.northwindj.domains;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractDomain<K extends Serializable> implements IDomain<K> {
	
	public AbstractDomain()
	{
		
	}
	private K id;
	private int version;
	private String createBy;
	private Date createDate;
	private String updateBy;
	private Date updateDate;
	
	
	public K getId() {
		return id;
	}
	public void setId(K id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
