package com.tao.northwindj.domains.products;

import com.tao.northwindj.domains.AbstractQuery;

public class ProductsQuery extends AbstractQuery{
	
	public ProductsQuery()
	{
		
	}
	private String productName;
	private Long supplier;
	private Long category;
	private boolean discontinued;
	private boolean hasInStock;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Long getSupplier() {
		return supplier;
	}
	public void setSupplier(Long supplier) {
		this.supplier = supplier;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
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
