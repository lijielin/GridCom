package com.inc.gm.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.itc.dao.BaseDao;
import com.itc.dao.GroupItem;
import com.itc.domain.Entity;
import com.itc.service.BaseService;
import com.itc.view.GroupResult;
import com.itc.view.PaginationSupport;

public class BaseServiceImpl<T extends Entity,K extends BaseDao<T>> implements BaseService<T> {
	
	private K dao;
	
	
	public T get(Serializable oid)
	{
		return dao.get(oid);
	}
	public T save(T entity)
	{
		return dao.save(entity);
	}
	
	public void tryDelete(T entity)
	{
		 dao.tryDelete(entity);
	}
	
	public void remove(T entity)
	{
		dao.remove(entity);
	}
	
	public void remove(T[] entitys)
	{
		dao.remove(entitys);
	}

	public void setDao(K dao) {
		this.dao = dao;
	}

	public K getDao() {
		return dao;
	}
	
	public int batchRemove(java.io.Serializable[] ids)
	{
		return this.dao.batchRemove(ids);
	}
	
	public int batchTryDelete(java.io.Serializable[] ids)
	{
		return this.dao.batchTryDelete(ids);
	}
	
	//QBC
	public Collection<T> find(DetachedCriteria detachedCriteria)
	{
		return getDao().find(detachedCriteria);
	}
	
	public Collection<T> find(DetachedCriteria detachedCriteria,int maxresult)
	{
		return getDao().find(detachedCriteria,maxresult);
	}
	
	
	public Collection<T> find(DetachedCriteria detachedCriteria,int startindex,int maxresult)
	{
		return getDao().find(detachedCriteria,startindex,maxresult);
	}
	

	//QBE 
	public Collection<T> find(final Example e)
	{
		return getDao().find(e);
	}
	public Collection<T> find(final T t)
	{
		return getDao().find(t);
	}
	public PaginationSupport listByPage(final DetachedCriteria detachCriteria,Serializable state, final PaginationSupport page)
	{
		if (state!=null)
			detachCriteria.add(Restrictions.eq("state", state));
		return listByPage(detachCriteria,page);
	}
	
	public PaginationSupport listByPage(final DetachedCriteria detachCriteria,String alias,Serializable state, final PaginationSupport page)
	{
		detachCriteria.add(Restrictions.eq(alias+".state", state));
		return listByPage(detachCriteria,page);
	}
	
	public PaginationSupport listByPage(final DetachedCriteria detachCriteria,Serializable[] includestates,Serializable[] excludestates, final PaginationSupport page)
	{
		if (includestates!=null && includestates.length>0)
		{
			if (includestates.length == 1)
			{
				detachCriteria.add(Restrictions.ne("state", includestates[0]));
			}
			else
			{
				LogicalExpression expression = null;
				for (int i=0;i<includestates.length;i++)
				{
					if (i<(includestates.length-1) && expression == null)
					{
						expression = Restrictions.or(Restrictions.eq("state",includestates[i])
													, Restrictions.eq("state",includestates[i+1]));
						i++;
					}
					else
					{
						expression = Restrictions.or(expression, Restrictions.eq("state",includestates[i]));
					}	
				}
				detachCriteria.add(expression);
			}
			
		}
		if (excludestates!=null && excludestates.length>0)
		{
			for (Serializable state : excludestates)
			{
				detachCriteria.add(Restrictions.ne("state", state));
			}
		}
		return listByPage(detachCriteria,page);
	}
	
	
	public PaginationSupport listByPage(final DetachedCriteria detachCriteria, final PaginationSupport page)
	{
		return getDao().listByPage(detachCriteria, page);
	}
	
	public 	T fetchGet(java.io.Serializable id,String[] properties)
	{
		return this.getDao().fetchGet(id, properties);
	}
	
	 /**
	  * 分组查询
	  * @param detachCriteriaJ
	  * @param page
	  * @param gitems
	  * @return
	  */
	public  Collection<GroupResult> groupByPage(DetachedCriteria detachCriteria, PaginationSupport page,List<GroupItem> gitems)
	{
		/*if (page!=null)
			page.setOrders(null);
		else*/
		if (page==null)
			page = new PaginationSupport();
		return this.getDao().groupByPage(detachCriteria, page, gitems);
	}
	

	public Collection<GroupResult> groupQuery(DetachedCriteria detachCriteria, List<GroupItem> gitems)
	{
		return this.getDao().groupQuery(detachCriteria, gitems);
	}
	
	public  Collection<T> loadAll()
	{
		return this.getDao().loadAll();
	}
}

