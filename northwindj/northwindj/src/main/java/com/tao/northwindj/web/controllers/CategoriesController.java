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
import com.tao.northwindj.domains.categories.Categories;
import com.tao.northwindj.domains.categories.CategoriesQuery;
import com.tao.northwindj.repositories.ICategoriesRepository;

@Controller
@RequestMapping(value="/categories")
public class CategoriesController {
	
	@Autowired
	private ICategoriesRepository cRepository;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Categories> getAll()
	{
		Result<Categories> result = cRepository.findAll();
		return result.getFullResult();
	}
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Categories getById(@RequestParam Long id)
	{
		Categories result = cRepository.findById(id);
		return result;
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Categories save(@RequestBody Categories entity)
	{
		Categories result = cRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Categories entity)
	{
		cRepository.remove(entity.getId());
		return "Success";
		
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Categories> search(@RequestBody CategoriesQuery query)
	{
		Result<Categories> result = cRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
}
