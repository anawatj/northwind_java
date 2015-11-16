package com.tao.northwindj.domains;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value=Include.NON_NULL)
public class Result<E> {
	private SessionFactory factory;
	private Criteria criteria;
	private List<E> list;
	

	public Result(Criteria criteria)
	{
		this.criteria= criteria;
		
	}
	public Result(Criteria criteria,SessionFactory factory)
	{
		this.factory=factory;
		this.criteria= criteria;
		
	}
	private Result(List<E> list)
	{
		this.list = list;
	}
	
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	
	public Result<E> getFullResult()
	{
		this.list = this.criteria.list();
		return new Result<E>(this.list);
	}
	public Page<E> getPage(int page)
	{
		return new Page<E>(this.criteria,page);
	}

}
