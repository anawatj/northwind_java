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
import com.tao.northwindj.domains.receipts.Receipts;
import com.tao.northwindj.domains.receipts.ReceiptsQuery;
import com.tao.northwindj.repositories.IReceiptsRepository;
@Repository(value="receiptsRepository")
public class ReceiptsRepository implements IReceiptsRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<Receipts> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Receipts.class);
		return new Result<Receipts>(criteria);
	}

	public Receipts findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Receipts.class);
		criteria.add(Restrictions.eq("id",id));
		
		criteria.setFetchMode("employees",FetchMode.JOIN);
		criteria.setFetchMode("customer",FetchMode.JOIN);
		criteria.setFetchMode("orders", FetchMode.JOIN);
		criteria.setFetchMode("cashes", FetchMode.JOIN);
		criteria.setFetchMode("cheques",FetchMode.JOIN);
		criteria.setFetchMode("banks", FetchMode.JOIN);
		criteria.setFetchMode("banks.bank", FetchMode.JOIN);
		criteria.setFetchMode("banks.bankBranch",FetchMode.JOIN);
		criteria.setFetchMode("cheques.chequeBank", FetchMode.JOIN);
		criteria.setFetchMode("cheques.chequeBankBranch", FetchMode.JOIN);
		
		List<Receipts> result=  criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
		
	}

	public void remove(Long id) {
		Receipts data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Receipts save(Receipts entity) {
		Receipts data = findById(entity.getId());
		Receipts result = (Receipts) factory.getCurrentSession().merge(entity);
		return result;
	}

	public Result<Receipts> findByQuery(ReceiptsQuery query) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Receipts.class);
		if(query.getReceiptCode()!=null && !query.getReceiptCode().equals(""))
		{
			if(query.getReceiptCode().contains("*") || query.getReceiptCode().contains("?"))
			{
				criteria.add(Restrictions.like("receiptCode", query.getReceiptCode().replace("*","%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("receiptCode", query.getReceiptCode()));
			}
		}
		if(query.getReceiptDateStart()!=null)
		{
			criteria.add(Restrictions.ge("receiptDate", query.getReceiptDateStart()));
		}
		if(query.getReceiptDateEnd()!=null)
		{
			criteria.add(Restrictions.le("receiptDate", query.getReceiptDateEnd()));
		}
		if(query.getCustomer()!=null && query.getCustomer()!=0)
		{
			criteria.createAlias("customer","cus",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("cus.id",query.getCustomer()));
		}
		if(query.getEmployee()!=null && query.getEmployee()!=0)
		{
			criteria.createAlias("employees","emp",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("emp.id", query.getEmployee()));
		}
		criteria.setFetchMode("employees", FetchMode.JOIN);
		criteria.setFetchMode("employees.title",FetchMode.JOIN);
		criteria.setFetchMode("customer", FetchMode.JOIN);
		
		return new Result<Receipts>(criteria);
	}

}
