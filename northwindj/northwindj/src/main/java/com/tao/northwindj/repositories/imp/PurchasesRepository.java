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
import com.tao.northwindj.domains.purchases.Purchases;
import com.tao.northwindj.domains.purchases.PurchasesQuery;
import com.tao.northwindj.repositories.IPurchasesRepository;

@Repository(value="purchasesRepository")
public class PurchasesRepository implements IPurchasesRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<Purchases> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Purchases.class);
		return new Result<Purchases>(criteria);
	}

	public Purchases findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Purchases.class);
		
		criteria.add(Restrictions.eq("id",id));
		
		criteria.setFetchMode("supplier", FetchMode.JOIN);
		criteria.setFetchMode("employee", FetchMode.JOIN);
		
		criteria.setFetchMode("details",FetchMode.JOIN);
		criteria.setFetchMode("details.product", FetchMode.JOIN);
		
		
		
		List<Purchases> result = criteria.list();
		
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Purchases data = findById(id);
		factory.getCurrentSession().delete(data);
		
		
	}

	public Purchases save(Purchases entity) {
		Purchases data = findById(entity.getId());
		Purchases result = (Purchases) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Purchases> findByQuery(PurchasesQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Purchases.class);

		if(query.getEmployee()!=null && query.getEmployee()!=0)
		{
			criteria.createAlias("employee", "e",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("e.id", query.getEmployee()));
		}
		if(query.getSupplier()!=null && query.getSupplier()!=0)
		{
			criteria.createAlias("supplier", "s",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("s.id", query.getSupplier()));
		}
		if(query.getPurchaseDateStart()!=null)
		{
			criteria.add(Restrictions.ge("purchaseDate",query.getPurchaseDateStart()));
		}
		if(query.getPurchaseDateEnd()!=null)
		{
			criteria.add(Restrictions.le("purchaseDate", query.getPurchaseDateEnd()));
		}
		if(query.getRequireDateStart()!=null)
		{
			criteria.add(Restrictions.ge("requireDate", query.getRequireDateStart()));
		}
		if(query.getRequireDateEnd()!=null)
		{
			criteria.add(Restrictions.le("requireDate", query.getRequireDateEnd()));
		}
		return new Result<Purchases>(criteria);
		
	}

}
