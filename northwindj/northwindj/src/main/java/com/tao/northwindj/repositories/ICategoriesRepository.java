package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.categories.Categories;
import com.tao.northwindj.domains.categories.CategoriesQuery;

public interface ICategoriesRepository extends Repository<Categories,Long>{

	Result<Categories> findAll();
	Categories findById(Long id);
	void remove(Long id);
	Categories save(Categories entity);
	Result<Categories> findByQuery(CategoriesQuery query);
	
}
