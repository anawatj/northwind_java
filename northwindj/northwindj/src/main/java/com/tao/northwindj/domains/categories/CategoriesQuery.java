package com.tao.northwindj.domains.categories;

import com.tao.northwindj.domains.AbstractQuery;

public class CategoriesQuery extends AbstractQuery {
	
	public CategoriesQuery()
	{
		
	}
	private String categoryName;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
