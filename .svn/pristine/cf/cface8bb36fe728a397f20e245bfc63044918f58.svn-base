package com.inc.gtc.fire.dao.impl;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.Subcriteria;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.QueryDao;
import com.itc.dao.h4.BaseDaoImpl;
import com.itc.domain.Entity;
import com.itc.view.PaginationSupport;

/**
 * 通用查询Dao实现
 * @author inc.chenzhi
 *
 */
@Repository("queryDao")
public class QueryDaoImpl extends BaseDaoImpl<Entity> implements QueryDao{

	public Object load(final Class<?> cls,final java.io.Serializable id)
	{
		try
		{
		return  this.getSession().load(cls, id);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public Collection<?> query(final DetachedCriteria criteria)
	{
		return criteria.getExecutableCriteria(getSession()).list();
	}
	
	 public PaginationSupport listByPage(final DetachedCriteria detachCriteria, final PaginationSupport page)
	    {

			final String sort = this.addSort(detachCriteria, page.getSort());
	       
        	try
        	{
        	Session session = getSession();
        	page.setStartIndex(page.getCurrentPage()*page.getPageSize());
            Criteria criteria = detachCriteria.getExecutableCriteria(session);
           
            if (page.getTotalCount()==0)
            {
            	if (page.getProjectionProperty()!=null)
            	{
            		int totalCount = ((Integer)criteria.setProjection(Projections.countDistinct(page.getProjectionProperty())).uniqueResult()).intValue();
                	page.setTotalCount(totalCount);
            	}
            	else
            	{
                	int totalCount = Integer.parseInt((criteria.setProjection(Projections.rowCount()).uniqueResult().toString()));
                	page.setTotalCount(totalCount);             		
            	}
            }
            if (page.getProjectionProperty()!=null)
            {
            	criteria.setResultTransformer(CriteriaSpecification.PROJECTION);
            	criteria.setProjection(Projections.distinct(Projections.property(page.getProjectionProperty())));
            }
            else
            {
            	criteria.setProjection(null);
            	criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
            }
            if (sort!=null)
            {
            	if (page.getDirection()==null || page.getDirection().equals("asc"))
            	{
            		criteria.addOrder(Order.asc(sort));
            	}
            	else
            	{
            		criteria.addOrder(Order.desc(sort));
            	}
            }
            else if(page.getOrders() != null)
            {
                org.hibernate.criterion.Order aorder[];
                int j = (aorder = page.getOrders()).length;
                for(int i = 0; i < j; i++)
                {
                    org.hibernate.criterion.Order order = aorder[i];
                    criteria.addOrder(order);
                }

            }
            else
            {
            	criteria.addOrder(Order.asc("id"));
            }
            List<?> items = criteria.setFirstResult(page.getStartIndex()).setMaxResults(page.getPageSize()).list();
            PaginationSupport ps = new PaginationSupport();
            ps.setPageSize(page.getPageSize());
            ps.setItems(items);
            ps.setTotalCount(page.getTotalCount());
            ps.setStartIndex(page.getStartIndex());
            int totalPage = page.getTotalCount() / ps.getPageSize();
            if(totalPage * ps.getPageSize() < page.getTotalCount())
                totalPage++;
            ps.setTotalPage(totalPage);
            ps.setCurrentPage(page.getCurrentPage());
            ps.setSort(page.getSort());
            ps.setDirection(page.getDirection());
            return ps;
        	}
        	catch (Exception e)
        	{
        		e.printStackTrace();
        		return null;
        	}
	            	
	    }
	 
		private String addSort(DetachedCriteria criteria,String sort)
		{
			try
			{
				if (sort!=null && sort.indexOf(".")>0)
				{
					Method method = criteria.getClass().getDeclaredMethod("getCriteriaImpl", null);
					method.setAccessible(true);
					CriteriaImpl impl = (CriteriaImpl)method.invoke(criteria, null);
					String aliastr = sort.substring(0,sort.lastIndexOf("."));
					String field = sort.substring(sort.lastIndexOf(".")+1);
					String[] aliaary =aliastr.split("\\.");
					String parentalia = null;
					String aliaed = null;
					Map<String,String> aliaedhash = new HashMap<String,String>();
					for (String alia : aliaary)
					{
						if (aliaedhash.containsKey(alia))
						{
							aliaed=aliaedhash.get(alia);
						}
						else
							aliaed = this.containsAlias(impl, alia);
						if (aliaed==null)
						{
							if (parentalia!=null)
							{
								criteria.createAlias(parentalia+"."+alia, alia,CriteriaSpecification.LEFT_JOIN);
							}
							else
							{
								criteria.createAlias(alia, alia,CriteriaSpecification.LEFT_JOIN);
							}
							aliaedhash.put(alia, alia);
							parentalia= alia;
						}
						else
						{
							parentalia = aliaed;
						}
					}
					if (parentalia!=null)
						return parentalia+"."+field;
					else
						return aliaary[aliaary.length-1]+"."+field;
				}
				else
				{
					return sort;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				return null;
			}
		}
	
	public String containsAlias(CriteriaImpl impl,String path)
	{
		Subcriteria sub = null;
		Iterator<?> iterator = impl.iterateSubcriteria();
		while (iterator.hasNext())
		{
			sub = (Subcriteria)iterator.next();
			if  (sub.getPath().indexOf(path)>=0)
				return sub.getAlias();
		}
		return null;
	}
	
	public Class<?> getCriteriaClass(DetachedCriteria criteria) throws Exception
	{
		Method method = criteria.getClass().getDeclaredMethod("getCriteriaImpl", null);
		method.setAccessible(true);
		CriteriaImpl impl = (CriteriaImpl)method.invoke(criteria, null);
		return Class.forName(impl.getEntityOrClassName());
	}
}
