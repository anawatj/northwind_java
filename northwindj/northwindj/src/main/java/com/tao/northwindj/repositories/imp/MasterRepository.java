package com.tao.northwindj.repositories.imp;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.SimpleMasterObject;

@Repository(value="masterRepository")
public class MasterRepository {
	
	@Autowired
	private SessionFactory factory;
	
	
	public Result<SimpleMasterObject> findAll(Class clazz)
	{
		Criteria criteria = this.factory.getCurrentSession().createCriteria(clazz);
		return new Result<SimpleMasterObject>(criteria);
		
		
	}
}
