package com.tao.northwindj.repositories.imp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale.Category;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.categories.Categories;
import com.tao.northwindj.domains.categories.CategoriesQuery;
import com.tao.northwindj.repositories.ICategoriesRepository;
@Repository(value="categoriesRepository")
public class CategoriesRepository implements ICategoriesRepository{

	@Autowired
	private SessionFactory factory;
	
	public Result<Categories> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Categories.class);
		return new Result(criteria);
		
	}

	public Categories findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Categories.class);
		criteria.add(Restrictions.eq("id",id));
		List<Categories> result= criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
		
	}

	public void remove(Long id) {
		Categories data = findById(id);
		this.factory.getCurrentSession().delete(data);
		
	}

	public Categories save(Categories entity) {
		Categories data= findById(entity.getId());
		Categories res = (Categories) this.factory.getCurrentSession().merge(entity);
		NumberFormat format =new DecimalFormat("#000000000000000000");
		String code = "CA"+format.format(res.getId());
		res.setCategoryCode(code);
		Categories result = (Categories) this.factory.getCurrentSession().merge(res);
		return result;
	}

	public Result<Categories> findByQuery(CategoriesQuery query) {
		Criteria criteria =factory.getCurrentSession().createCriteria(Categories.class);
		if(query.getCategoryName()!=null && !query.getCategoryName().equals(""))
		{
			if(query.getCategoryName().contains("*") || query.getCategoryName().contains("?"))
			{
				criteria.add(Restrictions.like("categoryName",query.getCategoryName().replace("*","%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("categoryName",query.getCategoryName()));
			}
		}
		return new Result<Categories>(criteria,factory);
	}

}
