package com.tao.northwindj.domains.orders;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.tao.northwindj.domains.AbstractDomain;
import com.tao.northwindj.domains.customers.Customers;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.master.City;
import com.tao.northwindj.domains.master.Country;
import com.tao.northwindj.domains.master.Regions;
import com.tao.northwindj.domains.shippers.Shippers;

public class Orders extends AbstractDomain<Long> {
	public Orders()
	{
		this.details = new HashSet<OrderDetails>();
	}
	private Customers customer;
	private Employees employee;
	private Date orderDate;
	private Date requireDate;
	private Date shipperDate;
	private Shippers shipVia;
	private Double freight;
	private String shipName;
	private String shipAddress;
	private City shipCity;
	private Regions shipRegion;
	private String shipPostalCode;
	private Country shipCountry;
	private Set<OrderDetails> details;
	private String orderCode;
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public Customers getCustomer() {
		if(this.customer!=null &&(this.customer.getId()==null || this.customer.getId()==0))
		{
			return null;
		}
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	public Employees getEmployee() {
		if(this.employee!=null &&(this.employee.getId()==null || this.employee.getId()==0))
		{
			return null;
		}
		return employee;
	}
	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getRequireDate() {
		return requireDate;
	}
	public void setRequireDate(Date requireDate) {
		this.requireDate = requireDate;
	}
	public Date getShipperDate() {
		return shipperDate;
	}
	public void setShipperDate(Date shipperDate) {
		this.shipperDate = shipperDate;
	}
	public Shippers getShipVia() {
		if(this.shipVia!=null &&(this.shipVia.getId()==null || this.shipVia.getId()==0))
		{
			return null;
		}
		return shipVia;
	}
	public void setShipVia(Shippers shipVia) {
		this.shipVia = shipVia;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public City getShipCity() {
		if(this.shipCity!=null &&(this.shipCity.getId()==null || this.shipCity.getId()==0))
		{
			return null;
		}
		return shipCity;
	}
	public void setShipCity(City shipCity) {
		this.shipCity = shipCity;
	}
	public Regions getShipRegion() {
		if(this.shipRegion!=null &&(this.shipRegion.getId()==null || this.shipRegion.getId()==0))
		{
			return null;
		}
		return shipRegion;
	}
	public void setShipRegion(Regions shipRegion) {
		this.shipRegion = shipRegion;
	}
	public String getShipPostalCode() {
		return shipPostalCode;
	}
	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}
	public Country getShipCountry() {
		if(this.shipCountry!=null && (this.shipCountry.getId()==null || this.shipCountry.getId()==0))
		{
			return null;
		}
		return shipCountry;
	}
	public void setShipCountry(Country shipCountry) {
		this.shipCountry = shipCountry;
	}
	public Set<OrderDetails> getDetails() {
		return details;
	}
	public void setDetails(Set<OrderDetails> details) {
		this.details = details;
	}
}
