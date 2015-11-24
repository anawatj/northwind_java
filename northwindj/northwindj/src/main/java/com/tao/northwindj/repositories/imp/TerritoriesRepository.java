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
import com.tao.northwindj.domains.territories.Territories;
import com.tao.northwindj.domains.territories.TerritoriesQuery;
import com.tao.northwindj.repositories.ITerritoriesRepository;
@Repository(value="territoriesRepository")
public class TerritoriesRepository implements ITerritoriesRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<Territories> findAll() {
		Criteria criteria = this.factory.getCurrentSession().createCriteria(Territories.class);
		return new Result<Territories>(criteria);
	}

	public Territories findById(Long id) {
		Criteria criteria = this.factory.getCurrentSession().createCriteria(Territories.class);
		criteria.add(Restrictions.eq("id",id));
		
		criteria.setFetchMode("region",FetchMode.JOIN);
		
		List<Territories> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Territories data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Territories save(Territories entity) {
		Territories data = findById(entity.getId());
		Territories result = (Territories) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Territories> findByQuery(TerritoriesQuery query) {
		Criteria criteria = this.factory.getCurrentSession().createCriteria(Territories.class);
		
		if(query.getName()!=null && !query.getName().equals(""))
		{
			if(query.getName().contains("*") || query.getName().contains("?"))
			{
				criteria.add(Restrictions.like("name", query.getName().replace("*","%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("name", query.getName()));
			}
		}
		if(query.getRegion()!=null && query.getRegion()!=0)
		{
			criteria.createAlias("region","r",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("r.id",query.getRegion()));
		}
		criteria.setFetchMode("region",FetchMode.JOIN);
		return new Result<Territories>(criteria);
	}

}
