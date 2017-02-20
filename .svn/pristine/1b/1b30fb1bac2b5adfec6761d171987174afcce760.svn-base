package com.inc.gtc.fire.dao.impl;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.BaseModeDao;
import com.inc.gtc.fire.domain.BaseMode;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:51:23
 * 模式与预警有效周期dao
 */
@Repository("baseModeDao")
public class BaseModeDaoImpl extends BaseDaoImpl<BaseMode> implements BaseModeDao {
	@SuppressWarnings("unchecked")
	public Collection<BaseMode> findBaseMode(final String stationNumber)
	{
		Criteria criteria = getSession().createCriteria(BaseMode.class);
		criteria.add(Restrictions.eq("stationNumber", stationNumber));
		criteria.addOrder(Order.asc("id"));
		return criteria.list();		
	}
}
