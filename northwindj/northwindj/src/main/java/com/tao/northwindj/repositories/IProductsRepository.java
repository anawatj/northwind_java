package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.products.Products;
import com.tao.northwindj.domains.products.ProductsQuery;

public interface IProductsRepository extends Repository<Products,Long> {
		
	Result<Products> findAll();
	Products findById(Long id);
	void remove(Long id);
	Products save(Products entity);
	Result<Products> findByQuery(ProductsQuery query);
}
