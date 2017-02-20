package com.inc.gtc.fire.dao.impl;


import java.util.Collection;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.SensorRuleDao;
import com.inc.gtc.fire.domain.SensorRule;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:51:23
 * 探测器自动获取信息的规则等dao
 */
@Repository("sensorRuleDao")
public class SensorRuleDaoImpl extends BaseDaoImpl<SensorRule> implements SensorRuleDao {
	@SuppressWarnings("unchecked")
	public Collection<SensorRule> findSensorRule(final Date begainDate,final Date endDate)
	{
    	Criteria criteria = getSession().createCriteria(SensorRule.class);
    	criteria.add(Restrictions.ge("nextTime", begainDate));
    	criteria.add(Restrictions.lt("nextTime", endDate));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	public int countSensorRule(final Date begainDate,final Date endDate)
	{
		Criteria criteria = getSession().createCriteria(SensorRule.class);
    	criteria.add(Restrictions.ge("nextTime", begainDate));
    	criteria.add(Restrictions.lt("nextTime", endDate));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	@SuppressWarnings("unchecked")
	public Collection<SensorRule> findSensorRule(final Date begainDate,final Date endDate,final int startIndex,final int endIndex)
	{	
    	Criteria criteria = getSession().createCriteria(SensorRule.class);
    	criteria.add(Restrictions.ge("nextTime", begainDate));
    	criteria.add(Restrictions.lt("nextTime", endDate));
    	criteria.setFirstResult(startIndex).setMaxResults(endIndex);
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
}
