package com.inc.gtc.service.impl;

import java.io.Serializable;

import com.inc.gtc.dao.BaseJdbcDao;
import com.inc.gtc.service.BaseService;
import com.itc.view.PaginationSupport;

public class BaseServiceImpl<T,K extends BaseJdbcDao<T>> implements BaseService<T> {

	
	private K dao;
	
	public void setDao(K dao) {
		this.dao = dao;
	}
	
	public K getDao()
	{
		return dao;
	}
	
	public T get(Serializable oid)
	{
		return this.dao.get(oid);
	}
	

	public T save(T entity)
	{
		return this.dao.save(entity);
	}
	

	public void remove(T entity)
	{
		this.dao.remove(entity);
	}
	
	public PaginationSupport listByPage(final PaginationSupport page)
	{
		return dao.listByPage(page);
	}
}
