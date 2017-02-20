package com.inc.gtc.fire.dao;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.internal.CriteriaImpl;

import com.itc.view.PaginationSupport;

/**
 * 通用查询Dao
 * @author inc.chenzhi
 *
 */
public interface QueryDao {
	
	
	Class<?> getCriteriaClass(DetachedCriteria criteria) throws Exception;
	/**
	 * 根据主键查询
	 * @param cls
	 * @param id
	 * @return
	 */
	Object load(Class<?> cls,java.io.Serializable id);
	
	/**
	 * QBE查询
	 * @param criteria
	 * @return
	 */
	Collection<?> query(final DetachedCriteria criteria);
	
	/**
	 * 分页查询
	 * @param detachCriteria
	 * @param page
	 * @return
	 */
	PaginationSupport listByPage(DetachedCriteria detachCriteria, PaginationSupport page);
	
	String containsAlias(CriteriaImpl impl,String path);
}
