package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.suppliers.Suppliers;
import com.tao.northwindj.domains.suppliers.SuppliersQuery;

public interface ISuppliersRepository extends Repository<Suppliers,Long>{
	
	Result<Suppliers> findAll();
	Suppliers findById(Long id);
	void remove(Long id);
	Suppliers save(Suppliers entity);
	Result<Suppliers> findByQuery(SuppliersQuery query);
	
}
