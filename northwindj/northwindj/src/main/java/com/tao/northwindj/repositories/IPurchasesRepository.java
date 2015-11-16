package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.purchases.Purchases;

public interface IPurchasesRepository extends Repository<Purchases,Long> {
	
	Result<Purchases> findAll();
	Purchases findById(Long id);
	void remove(Long id);
	Purchases save(Purchases entity);
	
}
