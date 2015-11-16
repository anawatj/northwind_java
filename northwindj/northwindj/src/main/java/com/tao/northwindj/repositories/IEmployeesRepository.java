package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.employees.Employees;

public interface IEmployeesRepository extends Repository<Employees,Long> {

	Result<Employees> findAll();
	Employees findById(Long id);
	void remove(Long id);
	Employees save(Employees entity);
}
