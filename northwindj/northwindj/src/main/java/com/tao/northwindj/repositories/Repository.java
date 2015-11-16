package com.tao.northwindj.repositories;

import java.io.Serializable;

import com.tao.northwindj.domains.IDomain;
import com.tao.northwindj.domains.Result;

public interface Repository<E extends IDomain<K>,K extends Serializable> {
		
	public Result<E> findAll();
	public E findById(K id);
	public E save(E entity);
	public void remove(K id);
}
