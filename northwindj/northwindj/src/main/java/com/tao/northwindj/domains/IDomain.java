package com.tao.northwindj.domains;

import java.io.Serializable;
import java.util.Date;

public interface IDomain<K extends Serializable> {
	
	public void setId(K id);
	public K getId();
	
	
	public void setVersion(int version);
	public int getVersion();
	
	
	public void setCreateBy(String createBy);
	public String getCreateBy();
	
	public void setCreateDate(Date createDate);
	public Date getCreateDate();
	
	public void setUpdateBy(String updateBy);
	public String getUpdateBy();
	
	public void setUpdateDate(Date updateDate);
	public Date getUpdateDate();
	
	
}
