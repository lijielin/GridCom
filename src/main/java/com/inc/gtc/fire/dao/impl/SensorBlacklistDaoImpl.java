package com.inc.gtc.fire.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.SensorBlacklistDao;
import com.inc.gtc.fire.domain.SensorBlacklist;
import com.itc.dao.h4.BaseDaoImpl;

@Repository("sensorBlacklistDao")
public class SensorBlacklistDaoImpl extends BaseDaoImpl<SensorBlacklist> implements SensorBlacklistDao {

	@Override
	public SensorBlacklist findBlacklist(final Integer sensorId) {
    	Criteria criteria = getSession().createCriteria(SensorBlacklist.class);
    	criteria.add(Restrictions.eq("sensorId", sensorId));
     	criteria.addOrder(Order.asc("id"));
     	@SuppressWarnings("unchecked")
		Collection<SensorBlacklist> list = criteria.list();
     	if(list != null && list.size() > 0){
     		return list.iterator().next();
     	}
    	return null;
	}
}
