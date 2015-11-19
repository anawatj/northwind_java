package com.tao.northwindj.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.SimpleMasterObject;
import com.tao.northwindj.domains.master.Country;
import com.tao.northwindj.repositories.imp.MasterRepository;

@Controller
@RequestMapping(value="/master")
public class MasterController {
	
	@Autowired
	private MasterRepository mRepository;
	
	@RequestMapping(value="/country/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllCountry()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(Country.class);
		return result.getFullResult();
	}

}
