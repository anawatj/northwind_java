package com.tao.northwindj.web.controllers;

import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.SimpleMasterObject;
import com.tao.northwindj.domains.master.Bank;
import com.tao.northwindj.domains.master.BankBranch;
import com.tao.northwindj.domains.master.City;
import com.tao.northwindj.domains.master.Country;
import com.tao.northwindj.domains.master.DemoGraphics;
import com.tao.northwindj.domains.master.Department;
import com.tao.northwindj.domains.master.EducationLevel;
import com.tao.northwindj.domains.master.Regions;
import com.tao.northwindj.domains.master.Title;
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
	@RequestMapping(value="/city/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllCity(@RequestParam Long id)
	{
		Vector<String> fields = new Vector<String>();
		fields.add("countryId");
		Vector<Object> values = new Vector<Object>();
		values.add(id);
		Result<SimpleMasterObject> result = mRepository.findAll(City.class, fields, values);
		return result.getFullResult();
		
	}
	@RequestMapping(value="/demographics/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDemoGraphics()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(DemoGraphics.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/department/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllDepartment()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(Department.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/educationLevel/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllEducationLevel()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(EducationLevel.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/regions/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllRegion()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(Regions.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/title/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllTitle()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(Title.class);
		return result.getFullResult();
	}
	@RequestMapping(value="/bank/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllBank()
	{
		Result<SimpleMasterObject> result = mRepository.findAll(Bank.class);
		return result.getFullResult();
		
 	}
	@RequestMapping(value="/bankbranch/all",method=RequestMethod.GET)
	@Transactional
	public @ResponseBody Result<SimpleMasterObject> getAllBankBranch(@RequestParam Long id)
	{
		Vector<String> fields = new Vector<String>();
		fields.add("bankId");
		Vector<Object> values = new Vector<Object>();
		values.add(id);
		Result<SimpleMasterObject> result= mRepository.findAll(BankBranch.class, fields, values);
		return result.getFullResult();
	
	}
}
