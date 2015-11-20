package com.tao.northwindj.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.northwindj.domains.Page;
import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.employees.EmployeesQuery;
import com.tao.northwindj.repositories.IEmployeesRepository;

@Controller
@RequestMapping(value="/employees")
public class EmployeesController {
		
	
	@Autowired
	private IEmployeesRepository eRepository;
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Employees> getAll()
	{
		Result<Employees> result = eRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Employees getById(@RequestParam Long id)
	{
		Employees result = eRepository.findById(id);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Employees> search(@RequestBody EmployeesQuery query)
	{
		Result<Employees> result = eRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Employees save(@RequestBody Employees entity)
	{
		Employees result = eRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Employees data)
	{
		eRepository.remove(data.getId());
		return "success";
	}
	
}
