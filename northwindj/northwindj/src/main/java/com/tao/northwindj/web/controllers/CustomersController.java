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
import com.tao.northwindj.domains.customers.Customers;
import com.tao.northwindj.domains.customers.CustomersQuery;
import com.tao.northwindj.repositories.ICustomersRepository;

@Controller
@RequestMapping(value="/customers")
public class CustomersController {
	
	@Autowired
	private ICustomersRepository cRepository;
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Customers> getAll()
	{
		Result<Customers> result = cRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Customers getById(@RequestParam Long id)
	{
		Customers result = cRepository.findById(id);
		if(result==null)
		{
			return new Customers();
		}else
		{
			return result;
		}
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Customers save(@RequestBody Customers entity)
	{
		Customers result = cRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Customers entity)
	{
		cRepository.remove(entity.getId());
		return "Success";
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Customers> search(@RequestBody CustomersQuery query)
	{	
		Result<Customers> result =cRepository.findByQuery(query);
		return result.getPage(query.getPage());
		
	}
}
