package com.tao.northwindj.domains.products;

import com.tao.northwindj.domains.AbstractQuery;

public class ProductsQuery extends AbstractQuery{
	
	public ProductsQuery()
	{
		
	}
	private String productName;
	private Integer supplier;
	private Integer category;
	private boolean discontinued;
	private boolean hasInStock;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getSupplier() {
		return supplier;
	}
	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public boolean getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	public boolean getHasInStock() {
		return hasInStock;
	}
	public void setHasInStock(boolean hasInStock) {
		this.hasInStock = hasInStock;
	}
}
