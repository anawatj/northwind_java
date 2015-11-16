package com.tao.northwindj.domains.products;


import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.categories.Categories;
import com.tao.northwindj.domains.suppliers.Suppliers;

public class Products extends AbstractDomain<Long>{
	public Products()
	{
		
	}
	private String productName;
	private Categories category;
	private Suppliers supplier;
	private String quantityPerUnit;
	private Double unitPrice;
	private Integer unitInStock;
	private Integer unitOnOrder;
	private Integer recorderLevel;
	private Boolean discontinued;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Categories getCategory() {
		if(this.category!=null && (this.category.getId()==null || this.category.getId()==0))
		{
			return null;
		}
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public Suppliers getSupplier() {
		if(this.supplier!=null &&(this.supplier.getId()==null || this.supplier.getId()==0))
		{
			return null;
		}
		return supplier;
	}
	public void setSupplier(Suppliers supplier) {
		this.supplier = supplier;
	}
	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}
	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(Integer unitInStock) {
		this.unitInStock = unitInStock;
	}
	public Integer getUnitOnOrder() {
		return unitOnOrder;
	}
	public void setUnitOnOrder(Integer unitOnOrder) {
		this.unitOnOrder = unitOnOrder;
	}
	public Integer getRecorderLevel() {
		return recorderLevel;
	}
	public void setRecorderLevel(Integer recorderLevel) {
		this.recorderLevel = recorderLevel;
	}
	public Boolean getDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Boolean discontinued) {
		this.discontinued = discontinued;
	}
}
