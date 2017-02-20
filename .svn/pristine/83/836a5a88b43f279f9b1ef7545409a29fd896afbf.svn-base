package com.inc.gtc.dao;

import java.io.Serializable;

import com.itc.view.PaginationSupport;

public interface BaseJdbcDao<T> {
	
	/**
	 * 根据ID查询
	 * @param oid
	 * @return
	 */
	T get(Serializable oid);
	
	/**
	 * 保存
	 * @param entity
	 */
	T save(T entity);
	

	
	/**
	 * 删除
	 * @param entity
	 */
	void remove(T entity);
	
	void batchRemove(Serializable[] ids);
	
	PaginationSupport listByPage(final PaginationSupport page);
}
