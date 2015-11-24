package com.tao.northwindj.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.northwindj.repositories.ISuppliersRepository;
import com.tao.northwindj.domains.Page;
import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.suppliers.*;

@Controller
@RequestMapping(value="/suppliers")
public class SuppliersController {
		
	
	@Autowired
	private ISuppliersRepository sRepository;
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Suppliers> getAll()
	{
		Result<Suppliers> result = sRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Suppliers getById(@RequestParam Long id)
	{
		Suppliers result = sRepository.findById(id);
		return result;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Suppliers> search(@RequestBody SuppliersQuery query)
	{
		Result<Suppliers> result = sRepository.findByQuery(query);
		return result.getPage(query.getPage());
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Suppliers save(@RequestBody Suppliers entity)
	{
		Suppliers result = sRepository.save(entity);
		return result;
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Suppliers data)
	{
		sRepository.remove(data.getId());
		return "Success";
	}
}
