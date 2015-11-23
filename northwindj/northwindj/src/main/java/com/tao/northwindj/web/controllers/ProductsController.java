package com.tao.northwindj.web.controllers;

import org.apache.tiles.definition.digester.DigesterDefinitionsReader.PutAttributeRule;
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
import com.tao.northwindj.domains.products.Products;
import com.tao.northwindj.domains.products.ProductsQuery;
import com.tao.northwindj.repositories.IProductsRepository;

@Controller
@RequestMapping(value="/products")
public class ProductsController {
		
	@Autowired
	private IProductsRepository pRepository;
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<Products> getAll()
	{
		Result<Products> result= pRepository.findAll();
		return result.getFullResult();
	}
	
	@RequestMapping(value="/single",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Products getById(@RequestParam Long id)
	{
		Products result= pRepository.findById(id);
		return result;
	}
	@RequestMapping(value="/search",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Page<Products> search(@RequestBody ProductsQuery query)
	{
		Result<Products> result= pRepository.findByQuery(query);
		return result.getPage(query.getPage());
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody Products save(@RequestBody Products entity)
	{
		Products result = pRepository.save(entity);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@Transactional
	public @ResponseBody String delete(@RequestBody Products data)
	{
		pRepository.remove(data.getId());
		return "Success";
	}
	
}
