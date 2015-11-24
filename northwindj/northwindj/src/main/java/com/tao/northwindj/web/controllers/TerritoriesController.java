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
import com.tao.northwindj.domains.territories.Territories;
import com.tao.northwindj.domains.territories.TerritoriesQuery;
import com.tao.northwindj.repositories.ITerritoriesRepository;

@Controller
@RequestMapping(value="/territories")
public class TerritoriesController {

	
	@Autowired
	private ITerritoriesRepository tRepository;
	
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Territories> getAll()
	{
		Result<Territories> result = tRepository.findAll();
		return result.getFullResult();
	}
	
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Territories getById(@RequestParam Long id)
	{
		Territories result = tRepository.findById(id);
		return result;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Territories> search(@RequestBody TerritoriesQuery query)
	{
		Result<Territories> result = tRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Territories save(@RequestBody Territories entity)
	{
		Territories result=  tRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Territories data)
	{
		tRepository.remove(data.getId());
		return "Success";
	}
}
