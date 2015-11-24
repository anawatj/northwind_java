package com.tao.northwindj.repositories;

import com.tao.northwindj.domains.Result;
import com.tao.northwindj.domains.territories.Territories;
import com.tao.northwindj.domains.territories.TerritoriesQuery;

public interface ITerritoriesRepository extends Repository<Territories,Long>{
	
	Result<Territories> findAll(); 
	Territories findById(Long id);
	void remove(Long id); 
	Territories save(Territories entity);
	Result<Territories> findByQuery(TerritoriesQuery query);
}
