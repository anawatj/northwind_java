package com.tao.northwindj.repositories.imp;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.shippers.Shippers;
import com.tao.northwindj.domains.shippers.ShippersQuery;
import com.tao.northwindj.repositories.IShippersRepository;

@Repository(value="shippersRepository")
public class ShippersRepository implements IShippersRepository {

	@Autowired
	private SessionFactory factory;
	public Result<Shippers> findAll() {
	
			Criteria criteria = factory.getCurrentSession().createCriteria(Shippers.class);
			return new Result<Shippers>(criteria);
	}

	public Shippers findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Shippers.class);
		criteria.add(Restrictions.eq("id",id));
		List<Shippers> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Shippers data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Shippers save(Shippers entity) {
		Shippers data = findById(entity.getId());
		Shippers result = (Shippers) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Shippers> findByQuery(ShippersQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Shippers.class);
		if(query.getCompanyName()!=null && !query.getCompanyName().equals(""))
		{
			if(query.getCompanyName().contains("*")||query.getCompanyName().contains("?"))
			{
				criteria.add(Restrictions.like("companyName", query.getCompanyName().replace("*","%").replace("?","_")));
			}else
			{
				criteria.add(Restrictions.eq("companyName",query.getCompanyName()));
			}
		}
		return new Result<Shippers>(criteria);
	}

}
