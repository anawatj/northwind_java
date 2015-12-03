package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.payments.Payments;
import com.tao.northwindj.domains.payments.PaymentsQuery;

public interface IPaymentsRepository extends Repository<Payments,Long>{
		
	
	Result<Payments> findAll();
	Payments findById(Long id);
	void remove(Long id);
	Payments save(Payments entity);
	
	Result<Payments> findByQuery(PaymentsQuery query);
	
}
