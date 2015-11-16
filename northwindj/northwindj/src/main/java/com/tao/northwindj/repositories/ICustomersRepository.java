package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.customers.Customers;
import com.tao.northwindj.domains.customers.CustomersQuery;

public interface ICustomersRepository extends Repository<Customers,Long> {

	Result<Customers> findAll();
	Customers findById(Long id);
	void remove(Long id);
	Customers save(Customers entity);
	Result<Customers> findByQuery(CustomersQuery query);
	
	
}
