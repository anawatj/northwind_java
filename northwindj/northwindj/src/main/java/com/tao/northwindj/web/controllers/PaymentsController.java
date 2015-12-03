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
import com.tao.northwindj.domains.payments.Payments;
import com.tao.northwindj.domains.payments.PaymentsQuery;
import com.tao.northwindj.repositories.IPaymentsRepository;

@Controller
@RequestMapping(value="/payments")
public class PaymentsController {

		@Autowired
		private IPaymentsRepository pRepository;
		
		
		@RequestMapping(value="/all",method=RequestMethod.GET)
		@Transactional
		public @ResponseBody Result<Payments> getAll()
		{
			Result<Payments> result  = pRepository.findAll();
			return result.getFullResult();
		}
		@RequestMapping(value="/single",method=RequestMethod.GET)
		@Transactional
		public @ResponseBody Payments getById(@RequestParam Long id)
		{
			Payments result = pRepository.findById(id);
			return result;
		}
		@RequestMapping(value="/search",method=RequestMethod.POST)
		@Transactional
		public @ResponseBody Page<Payments> search(@RequestBody PaymentsQuery query)
		{
			Result<Payments> result= pRepository.findByQuery(query);
			return result.getPage(query.getPage());
		}
		@RequestMapping(value="/save",method=RequestMethod.POST)
		@Transactional
		public @ResponseBody Payments save(@RequestBody Payments entity)
		{
			Payments result = pRepository.save(entity);
			return result;
		}
		@RequestMapping(value="/delete",method=RequestMethod.POST)
		@Transactional
		public @ResponseBody String delete(@RequestBody Payments data)
		{
			pRepository.remove(data.getId());
			return "Success";
		}
}
