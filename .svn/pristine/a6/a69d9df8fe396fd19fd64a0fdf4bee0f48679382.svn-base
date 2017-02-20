package com.inc.gtc.fire.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.QueryDao;
import com.inc.gtc.fire.service.QueryService;



/**
 * 通用查询服务实现
 * @author inc.chenzhi
 *
 */
@Service("queryService")
public class QueryServiceImpl implements QueryService{
	
	
	private QueryDao queryDao;
	
	@Resource(name="queryDao")
	public void setQueryDao(QueryDao queryDao) {
		this.queryDao = queryDao;
	}

	public QueryDao getQueryDao() {
		return queryDao;
	}

	@SuppressWarnings("unchecked")
	public Object load(Class cls,java.io.Serializable id)
	{
		return this.getQueryDao().load(cls, id);
	}
	
	public Collection<?> query(DetachedCriteria criteria)
	{
		return this.getQueryDao().query(criteria);
	}
	

}

