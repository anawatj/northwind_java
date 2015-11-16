package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.orders.Orders;

public interface IOrdersRepository extends Repository<Orders,Long> {
	
	Result<Orders> findAll();
	Orders findById(Long id);
	void remove(Long id);
	Orders save(Orders entity);
}
