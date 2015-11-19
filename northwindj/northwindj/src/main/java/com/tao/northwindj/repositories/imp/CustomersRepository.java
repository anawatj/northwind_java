package com.tao.northwindj.repositories.imp;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.customers.Customers;
import com.tao.northwindj.domains.customers.CustomersQuery;
import com.tao.northwindj.repositories.ICustomersRepository;
@Repository(value="customersRepository")
public class CustomersRepository implements ICustomersRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<Customers> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Customers.class);
		return new Result<Customers>(criteria);
	}

	public Customers findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Customers.class);
		criteria.add(Restrictions.eq("id",id));
		
		
		criteria.setFetchMode("country",FetchMode.JOIN);
		criteria.setFetchMode("region",FetchMode.JOIN);
		criteria.setFetchMode("city", FetchMode.JOIN);	
		criteria.setFetchMode("demos", FetchMode.JOIN);
		
	
		List<Customers> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Customers data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Customers save(Customers entity) {
		Customers data = findById(entity.getId());
		Customers result = (Customers) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Customers> findByQuery(CustomersQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Customers.class);
		if(query.getCompanyName()!=null && !query.getCompanyName().equals(""))
		{
			if(query.getCompanyName().contains("*") || query.getCompanyName().contains("?"))
			{
				criteria.add(Restrictions.like("companyName", query.getCompanyName().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("companyName", query.getCompanyName()));
			}
		}
		
		if(query.getContactName()!=null && !query.getContactName().equals(""))
		{
			if(query.getContactName().contains("*") || query.getContactName().contains("?"))
			{
				criteria.add(Restrictions.like("contactName", query.getContactName().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("contactName", query.getContactName()));
			}
		}
		if(query.getContactTitle()!=null && !query.getContactTitle().equals(""))
		{
			if(query.getContactTitle().contains("*") || query.getContactTitle().contains("?"))
			{
				criteria.add(Restrictions.like("contactTitle", query.getContactTitle().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("contactTitle", query.getContactTitle()));
			}
		}
		if(query.getCity()!=null && query.getCity()!=0)
		{
			criteria.createAlias("city", "ci",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("ci.id",query.getCity()));
		}
		if(query.getRegion()!=null && query.getRegion()!=0)
		{
			criteria.createAlias("region","r",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("r.id", query.getRegion()));
		}
		if(query.getCountry()!=null && query.getCountry()!=0)
		{
			criteria.createAlias("country","co",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("co.id", query.getCountry()));
		}
		criteria.setFetchMode("city", FetchMode.JOIN);
		criteria.setFetchMode("region", FetchMode.JOIN);
		criteria.setFetchMode("country",FetchMode.JOIN);
		
		return new Result<Customers>(criteria,factory);
	}

}
