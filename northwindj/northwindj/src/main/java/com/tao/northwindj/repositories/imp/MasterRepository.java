package com.tao.northwindj.repositories.imp;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public Result<SimpleMasterObject> findAll(Class clazz,Vector<String> fields,Vector<Object> values)
	{
		Criteria criteria =  this.factory.getCurrentSession().createCriteria(clazz);
		for(int index=0;index<fields.size();index++)
		{
			criteria.add(Restrictions.eq(fields.get(index), values.get(index)));
		}
		return new Result<SimpleMasterObject>(criteria);
		
		
	}
}
