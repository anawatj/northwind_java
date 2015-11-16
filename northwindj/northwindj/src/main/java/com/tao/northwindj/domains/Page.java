package com.tao.northwindj.domains;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tao.northwindj.Configs;
@JsonInclude(value=Include.NON_NULL)
public class Page<E> {
	private List<E> list;
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	private List<Integer> pages;
	private long totalRecord;
	private long totalPage;
	public Page(Criteria criteria,Integer page)
	{
		criteria.setProjection(null);
		this.totalRecord= (Long) criteria.setProjection(Projections.count("id")).uniqueResult();
		criteria.setProjection(null);
		int startPage = (page-1)*Configs.PAGE_SIZE;
		this.list = criteria.setFirstResult(startPage).setMaxResults(Configs.PAGE_SIZE).list();
		this.totalPage= this.totalRecord/Configs.PAGE_SIZE;
		if((this.totalRecord%Configs.PAGE_SIZE)>0)
		{
			this.totalPage++;
		}
		this.pages=new ArrayList<Integer>();
		for(int index=1;index<=this.totalPage;index++)
		{
			this.pages.add(index);
		}
		
	}
}
