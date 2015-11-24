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
import com.tao.northwindj.domains.suppliers.Suppliers;
import com.tao.northwindj.domains.suppliers.SuppliersQuery;
import com.tao.northwindj.repositories.ISuppliersRepository;

@Repository(value="suppliersRepository")
public class SuppliersRepository implements ISuppliersRepository{

	@Autowired
	private SessionFactory factory;
	
	public Result<Suppliers> findAll() {
		Criteria criteria = this.factory.getCurrentSession().createCriteria(Suppliers.class);
		return new Result<Suppliers>(criteria);
	}

	public Suppliers findById(Long id) {
		Criteria criteria = this.factory.getCurrentSession().createCriteria(Suppliers.class);
		criteria.add(Restrictions.eq("id",id));
		
		criteria.setFetchMode("city", FetchMode.JOIN);
		criteria.setFetchMode("region", FetchMode.JOIN);
		criteria.setFetchMode("country",FetchMode.JOIN);
		
		List<Suppliers> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Suppliers data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Suppliers save(Suppliers entity) {
		Suppliers data = findById(entity.getId());
		Suppliers result = (Suppliers) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Suppliers> findByQuery(SuppliersQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Suppliers.class);
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
		
		return new Result<Suppliers>(criteria,factory);
	}

}
