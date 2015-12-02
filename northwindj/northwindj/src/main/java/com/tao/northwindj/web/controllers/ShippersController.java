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
import com.tao.northwindj.domains.shippers.Shippers;
import com.tao.northwindj.domains.shippers.ShippersQuery;
import com.tao.northwindj.repositories.IShippersRepository;

@Controller
@RequestMapping(value="/shippers")
public class ShippersController {
	
	
	@Autowired
	private IShippersRepository sRepository;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Shippers> getAll()
	{
		Result<Shippers> result = sRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Shippers getById(@RequestParam Long id)
	{
		Shippers result = sRepository.findById(id);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Shippers> search(@RequestBody ShippersQuery query)
	{
		Result<Shippers> result = sRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Shippers save(@RequestBody Shippers entity)
	{
		Shippers result = sRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Shippers data)
	{
		sRepository.remove(data.getId());
		return "Success";
		
	}
} 
