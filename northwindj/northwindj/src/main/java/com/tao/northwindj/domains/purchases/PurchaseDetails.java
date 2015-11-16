package com.tao.northwindj.domains.purchases;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.products.Products;

public class PurchaseDetails extends AbstractDomain<Long> {
	public PurchaseDetails()
	{
		
	}
	private Long purchaseId;
	private Products product;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}
	public Products getProduct() {
		if(this.product!=null && (this.product.getId()==null || this.product.getId()==0 ))
		{
			return null;
		}
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}
