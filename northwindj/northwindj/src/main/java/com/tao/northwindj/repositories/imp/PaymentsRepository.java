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
import com.tao.northwindj.domains.payments.Payments;
import com.tao.northwindj.domains.payments.PaymentsQuery;
import com.tao.northwindj.repositories.IPaymentsRepository;
@Repository(value="paymentsRepository")
public class PaymentsRepository implements IPaymentsRepository {

	@Autowired
	private SessionFactory factory;
	
	public Result<Payments> findAll() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Payments.class);
		return new Result<Payments>(criteria);
	}

	public Payments findById(Long id) {
		Criteria criteria = factory.getCurrentSession().createCriteria(Payments.class);
		criteria.add(Restrictions.eq("id", id));
		
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("paymentTo",FetchMode.JOIN);
		criteria.setFetchMode("purchases",FetchMode.JOIN);
		
		List<Payments> result = criteria.list();
		if(result!=null && result.size()>0)
		{
			return result.get(0);
		}else
		{
			return null;
		}
		
	}

	public void remove(Long id) {
		Payments data = findById(id);
		factory.getCurrentSession().delete(data);
		
	}

	public Payments save(Payments entity) {
		Payments data = findById(entity.getId());
		Payments res = (Payments) factory.getCurrentSession().merge(entity);
		NumberFormat format =new DecimalFormat("#000000000000000000");
		String code = "PT"+format.format(res.getId());
		res.setPaymentCode(code);
		Payments result = (Payments) factory.getCurrentSession().merge(res);
		return result;
	}

	public Result<Payments> findByQuery(PaymentsQuery query) {
	
		Criteria criteria = factory.getCurrentSession().createCriteria(Payments.class);
		if(query.getPaymentCode()!=null && !query.getPaymentCode().equals(""))
		{
			if(query.getPaymentCode().contains("*") || query.getPaymentCode().contains("?"))
			{
				criteria.add(Restrictions.like("paymentCode", query.getPaymentCode().replace("*","%").replace("?", "_")));
			}else
			{
				criteria.add(Restrictions.eq("paymentCode", query.getPaymentCode()));
			}
				
		}
		if(query.getPaymentDateStart()!=null)
		{
			criteria.add(Restrictions.ge("paymentDate",query.getPaymentDateStart()));
		}
		if(query.getPaymentDateEnd()!=null)
		{
			criteria.add(Restrictions.le("paymentDate",query.getPaymentDateEnd()));
		}
		if(query.getEmployee()!=null && query.getEmployee()!=0)
		{
			criteria.createAlias("employee","em",JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("em.id",query.getEmployee()));
		}
		if(query.getSupplier()!=null && query.getSupplier()!=0)
		{
			criteria.createAlias("supplier", "su", JoinType.LEFT_OUTER_JOIN);
			criteria.add(Restrictions.eq("su.id",query.getSupplier()));
		}
		criteria.setFetchMode("employee", FetchMode.JOIN);
		criteria.setFetchMode("employee.title",FetchMode.JOIN);
		criteria.setFetchMode("supplier", FetchMode.JOIN);
		
		return new Result<Payments>(criteria);
	}

}
