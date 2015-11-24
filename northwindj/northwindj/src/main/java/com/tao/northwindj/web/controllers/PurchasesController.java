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
import com.tao.northwindj.domains.purchases.Purchases;
import com.tao.northwindj.domains.purchases.PurchasesQuery;
import com.tao.northwindj.repositories.IPurchasesRepository;

@Controller
@RequestMapping(value="/purchases")
public class PurchasesController {

	
	@Autowired
	private IPurchasesRepository pRepository;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Purchases> getAll()
	{
		Result<Purchases> result = pRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Purchases getById(@RequestParam Long id)
	{
		Purchases result = pRepository.findById(id);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Purchases> search(@RequestBody PurchasesQuery query)
	{
		Result<Purchases> result = pRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Purchases save(@RequestBody Purchases entity)
	{
		Purchases result = pRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Purchases data)
	{
		pRepository.remove(data.getId());
		return "Success";
	}
	
}
