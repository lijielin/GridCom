package com.inc.gm.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

import com.itc.dao.GroupItem;
import com.itc.domain.Entity;
import com.itc.view.GroupResult;
import com.itc.view.PaginationSupport;

public interface BaseService<T extends Entity> {

	/**
	 * 根据ID查找
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
	 * 物理删除
	 */
	void tryDelete(T entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	void remove(T entity);
	
	/**
	 * 批量删除
	 * @param entitys
	 */
	void remove(T[] entitys);
	
	/**
	 * 批量删除
	 */
	int batchRemove(java.io.Serializable[] ids);
	
	/**
	 * 批量删除
	 */
	int batchTryDelete(java.io.Serializable[] ids);
	
	/**
	 * QBC 离线查询
	 * @param detachedCriteria
	 * @return 返回映射对象集合
	 */
	Collection<T> find(DetachedCriteria detachedCriteria);
	
	/**
	 * QBC 离线查询
	 * @param detachedCriteria
	 * @param maxresult 最大结果数
	 * @return 返回映射对象集合
	 */
	Collection<T> find(DetachedCriteria detachedCriteria,int maxresult);
	
	/**
	 * QBC 离线查询
	 * @param detachedCriteria
	 * @param startindex 开始索引
	 * @param maxresult 最大结果数
	 * @return 返回映射对象集合
	 */
	Collection<T> find(DetachedCriteria detachedCriteria,int startindex,int maxresult);
	
	/**
	 * QBE查询
	 * @param e
	 * @return
	 */
	Collection<T> find(final Example e);
	/**
	 * QBE查询
	 * @param e
	 * @return
	 */
	Collection<T> find(final T t);
	
	/**
	 * 分页查询
	 * @param detachCriteria
	 * @param page
	 * @return 分页查询结果
	 */
	PaginationSupport listByPage(final DetachedCriteria detachCriteria, final PaginationSupport page);
	/**
	 * 分页查询
	 * @param detachCriteria
	 * @param page
	 * @return 分页查询结果
	 */
	PaginationSupport listByPage(final DetachedCriteria detachCriteria,Serializable state, final PaginationSupport page);
	
	/**
	 * 分页查询指定状态的数据 
	 * @param includestates 包含的状态
	 * @param excludestates 排除的状态
	 * */
	PaginationSupport listByPage(final DetachedCriteria detachCriteria,Serializable[] includestates,Serializable[] excludestates, final PaginationSupport page);
	
	/**
	 * 分页查询指定状态的数据 
	 * @param detachCriteria
	 * @param alias JOIN查询，别名
	 * @param state
	 * @param page
	 * @return
	 */
	PaginationSupport listByPage(final DetachedCriteria detachCriteria,String alias,Serializable state, final PaginationSupport page);
	
	
	/**
	 * 对指定property指定抓取策略为FetchMode.JOIN
	 * @param id
	 * @param properties
	 * @return
	 */
	 T fetchGet(java.io.Serializable id,String[] properties);
	 
	 /**
	  * 统计查询
	  * @param detachCriteria
	  * @param gitems
	  * @return
	  */
	 Collection<GroupResult> groupQuery(DetachedCriteria detachCriteria, List<GroupItem> gitems);
	 
	 /**
	  * 分组查询
	  * @param detachCriteria
	  * @param page
	  * @param gitems
	  * @return
	  */
	 Collection<GroupResult> groupByPage(DetachedCriteria detachCriteria, PaginationSupport page,List<GroupItem> gitems);
	 
	 
	 Collection<T> loadAll();
}
