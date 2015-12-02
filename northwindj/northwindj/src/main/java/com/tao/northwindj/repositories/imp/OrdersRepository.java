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
import com.tao.northwindj.domains.orders.Orders;
import com.tao.northwindj.domains.orders.OrdersQuery;
import com.tao.northwindj.repositories.IOrdersRepository;

@Repository(value="ordersRepository")
public class OrdersRepository implements IOrdersRepository{

	@Autowired
	private SessionFactory factory;
	
	public Result<Orders> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		return new Result<Orders>(criteria);
	}

	public Orders findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		criteria.add(Restrictions.eq("id",id));
		
		//assocication
		criteria.setFetchMode("employee",FetchMode.JOIN);
		criteria.setFetchMode("customer",FetchMode.JOIN);
		criteria.setFetchMode("shipVia", FetchMode.JOIN);
		criteria.setFetchMode("shipCity",FetchMode.JOIN);
		criteria.setFetchMode("shipRegion", FetchMode.JOIN);
		criteria.setFetchMode("shipCountry",FetchMode.JOIN);
		
		criteria.setFetchMode("details",FetchMode.JOIN);
		criteria.setFetchMode("details.product",FetchMode.JOIN);
		
		List<Orders> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
	}

	public void remove(Long id) {
		Orders data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Orders save(Orders entity) {
		Orders data = findById(entity.getId());
		Orders result = (Orders) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Orders> findByQuery(OrdersQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Orders.class);
		
		if(query.getCustomer()!=null && query.getCustomer()!=0)
		{
			criteria.createAlias("customer", "cus",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("cus.id",query.getCustomer()));
		}
		if(query.getEmployee()!=null && query.getEmployee()!=0)
		{
			criteria.createAlias("employee", "emp",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("emp.id", query.getEmployee()));
		}
		if(query.getOrderDateStart()!=null)
		{
			criteria.add(Restrictions.ge("orderDate", query.getOrderDateStart()));
		}
		if(query.getOrderDateEnd()!=null)
		{
			criteria.add(Restrictions.le("orderDate", query.getOrderDateEnd()));
		}
		if(query.getRequireDateStart()!=null)
		{
			criteria.add(Restrictions.ge("requireDate", query.getRequireDateStart()));
		}
		if(query.getRequireDateEnd()!=null)
		{
			criteria.add(Restrictions.le("requireDate", query.getRequireDateEnd()));
		}
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("employee.title",FetchMode.JOIN);
		criteria.setFetchMode("customer", FetchMode.JOIN);
		return new Result<Orders>(criteria);
	}

}
