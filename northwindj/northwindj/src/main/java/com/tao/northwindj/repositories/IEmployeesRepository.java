package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.employees.EmployeesQuery;

public interface IEmployeesRepository extends Repository<Employees,Long> {

	Result<Employees> findAll();
	Employees findById(Long id);
	void remove(Long id);
	Employees save(Employees entity);
	Result<Employees> findByQuery(EmployeesQuery query);
}
