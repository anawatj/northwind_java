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
import com.tao.northwindj.domains.products.Products;
import com.tao.northwindj.domains.products.ProductsQuery;
import com.tao.northwindj.repositories.IProductsRepository;

@Repository(value="productsReporitory")
public class ProductsRepository implements IProductsRepository {
	@Autowired
	private SessionFactory factory;
	
	public Result<Products> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Products.class);
		return new Result<Products>(criteria);
	}

	public Products findById(Long id) {
		Criteria criteria  = factory.getCurrentSession().createCriteria(Products.class);
		criteria.add(Restrictions.eq("id",id));
	
		criteria.setFetchMode("category",FetchMode.JOIN);
		criteria.setFetchMode("supplier",FetchMode.JOIN);
		
		List<Products> result = criteria.list();
		
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Products data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Products save(Products entity) {
		if(entity.getId()==0)
		{
			entity.setUnitInStock(0);
			entity.setUnitOnOrder(0);
		}
		Products data = findById(entity.getId());
		Products res = (Products) factory.getCurrentSession().merge(entity);
		NumberFormat format = new DecimalFormat("#000000000000000000");
		String code = "PD"+format.format(res.getId());
		res.setProductCode(code);
		Products result = (Products) factory.getCurrentSession().merge(res);
		return result;
	}

	public Result<Products> findByQuery(ProductsQuery query) {
		Criteria criteria  = factory.getCurrentSession().createCriteria(Products.class);
		if(query.getCategory()!=null && query.getCategory()!=0)
		{
			criteria.createAlias("category","c",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("c.id",query.getCategory()));
		}
		if(query.getSupplier()!=null && query.getSupplier()!=0)
		{
			criteria.createAlias("supplier","s",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("s.id",query.getSupplier()));
		}
		if(query.getProductName()!=null && !query.getProductName().equals(""))
		{
			if(query.getProductName().contains("*") || query.getProductName().contains("?"))
			{
				criteria.add(Restrictions.like("productName", query.getProductName().replace("*","%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("productName", query.getProductName()));
			}
		}
		if(query.getHasInStock())
		{
			criteria.add(Restrictions.gt("unitInStock",0));
		}
		if(query.getDiscontinued())
		{
			criteria.add(Restrictions.eq("discontinued",true));
		}
		return new Result<Products>(criteria);
	}
		
}
