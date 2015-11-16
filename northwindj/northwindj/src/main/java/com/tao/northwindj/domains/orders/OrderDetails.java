package com.tao.northwindj.domains.orders;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.products.Products;

public class OrderDetails extends AbstractDomain<Long> {
	
	public OrderDetails()
	{
		
	}
	private Long orderId;
	private Products product;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Products getProduct() {
		if(this.product!=null &&(this.product.getId()==null || this.product.getId()==0))
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
