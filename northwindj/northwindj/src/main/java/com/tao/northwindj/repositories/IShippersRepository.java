package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.shippers.Shippers;

public interface IShippersRepository extends Repository<Shippers,Long> {
	
	Result<Shippers> findAll();
	Shippers findById(Long id);
	void remove(Long id);
	Shippers save(Shippers entity);
}
