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
import com.tao.northwindj.domains.orders.Orders;
import com.tao.northwindj.domains.orders.OrdersQuery;
import com.tao.northwindj.repositories.IOrdersRepository;

@Controller
@RequestMapping(value="/orders")
public class OrdersController {

	
	@Autowired
	private IOrdersRepository oRepository;
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Orders> getAll()
	{
		Result<Orders> result = oRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Orders getById(@RequestParam Long id)
	{
		Orders result= oRepository.findById(id);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Orders> search(@RequestBody OrdersQuery query)
	{
		Result<Orders> result= oRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Orders save(@RequestBody Orders entity)
	{
		Orders result = oRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Orders data)
	{
		oRepository.remove(data.getId());
		return "Success";
	}
}
