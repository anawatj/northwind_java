package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.receipts.Receipts;
import com.tao.northwindj.domains.receipts.ReceiptsQuery;

public interface IReceiptsRepository extends Repository<Receipts,Long> {

	Result<Receipts> findAll();
	Receipts findById(Long id);
	void remove(Long id);
	Receipts save(Receipts entity);
	
	Result<Receipts> findByQuery(ReceiptsQuery query);
	
	
}
