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
import com.tao.northwindj.domains.receipts.Receipts;
import com.tao.northwindj.domains.receipts.ReceiptsQuery;
import com.tao.northwindj.repositories.IReceiptsRepository;

@Controller
@RequestMapping(value="/receipts")
public class ReceiptsController {

	
	@Autowired
	private IReceiptsRepository rRepository;
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Receipts> getAll()
	{
		Result<Receipts> result = rRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Receipts getById(@RequestParam Long id)
	{
		Receipts result = rRepository.findById(id);
		return result;
		
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Receipts> search(@RequestBody ReceiptsQuery query)
	{
		Result<Receipts> result = rRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Receipts save(@RequestBody Receipts entity)
	{
		Receipts result = rRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Receipts data)
	{
		rRepository.remove(data.getId());
		return "Success";
	}
	
}
