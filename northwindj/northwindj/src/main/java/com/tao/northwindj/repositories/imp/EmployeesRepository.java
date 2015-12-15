package com.tao.northwindj.repositories.imp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.employees.Employees;
import com.tao.northwindj.domains.employees.EmployeesQuery;
import com.tao.northwindj.repositories.IEmployeesRepository;

@Repository(value="employeesRepository")
public class EmployeesRepository implements IEmployeesRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<Employees> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Employees.class);
		return new Result<Employees>(criteria);
	}

	public Employees findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Employees.class);
		criteria.add(Restrictions.eq("id", id));
		
		criteria.setFetchMode("title",FetchMode.JOIN);
		criteria.setFetchMode("country", FetchMode.JOIN);
		criteria.setFetchMode("city",FetchMode.JOIN);
		criteria.setFetchMode("region",FetchMode.JOIN);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("reportTo", FetchMode.JOIN);
		
		criteria.setFetchMode("educations",FetchMode.JOIN);
		criteria.setFetchMode("educations.educationLevel",FetchMode.JOIN);
		criteria.setFetchMode("experiences",FetchMode.JOIN);
		criteria.setFetchMode("territories",FetchMode.JOIN);
		
		List<Employees> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Employees data = findById(id);
		factory.getCurrentSession().delete(data);
	}

	public Employees save(Employees entity) {
			Employees data = findById(entity.getId());
			Employees res = (Employees) factory.getCurrentSession().merge(entity);
			NumberFormat format = new DecimalFormat("#000000000000000000");
			String code ="EM"+ format.format(res.getId());
			res.setEmployeeCode(code);
			Employees result = (Employees) factory.getCurrentSession().merge(res);
			
			return result;
	}

	public Result<Employees> findByQuery(EmployeesQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Employees.class);
		if(query.getFirstName()!=null && !query.getFirstName().equals(""))
		{
			if(query.getFirstName().contains("*") || query.getFirstName().contains("?"))
			{
				criteria.add(Restrictions.like("firstName", query.getFirstName().replace("*", "%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("firstName", query.getFirstName()));
			}
		}
		if(query.getLastName()!=null && !query.getLastName().equals(""))
		{
			if(query.getLastName().contains("*") || query.getLastName().contains("?"))
			{
				criteria.add(Restrictions.like("lastName", query.getLastName().replace("*", "%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("lastName", query.getLastName()));
			}
		}
		if(query.getDepartment()!=null && query.getDepartment()!=0)
		{
			criteria.createAlias("department", "d",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("d.id",query.getDepartment()));
		}
		criteria.setFetchMode("department",FetchMode.JOIN);
		criteria.setFetchMode("title",FetchMode.JOIN);
		criteria.setFetchMode("country", FetchMode.JOIN);
		criteria.setFetchMode("city", FetchMode.JOIN);
		criteria.setFetchMode("region", FetchMode.JOIN);
		
		return new Result<Employees>(criteria);
	}

}
