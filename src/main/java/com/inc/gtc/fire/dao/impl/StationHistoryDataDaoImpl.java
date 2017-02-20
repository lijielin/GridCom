package com.inc.gtc.fire.dao.impl;


import java.util.Collection;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.StationHistoryDataDao;
import com.inc.gtc.fire.domain.StationHistoryData;
import com.itc.dao.h4.BaseDaoImpl;

/**
 * @author itc.tzj
 */
@Repository("stationHistoryDataDao")
public class StationHistoryDataDaoImpl extends BaseDaoImpl<StationHistoryData> implements StationHistoryDataDao {
	@SuppressWarnings("unchecked")
	public Collection<StationHistoryData> findStationHistoryData(final String stationCode)
	{
    	Criteria criteria = getSession().createCriteria(StationHistoryData.class);
    	criteria.add(Restrictions.eq("stationCode", stationCode));
     	criteria.addOrder(Order.desc("id"));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<StationHistoryData> findLeastStationHistoryData(final String stationCode,final Date date)
	{
    	Criteria criteria = getSession().createCriteria(StationHistoryData.class);
    	criteria.add(Restrictions.eq("stationCode", stationCode));
    	criteria.add(Restrictions.ge("testTime", date));
     	criteria.addOrder(Order.desc("id"));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<StationHistoryData> findStationData(final Integer districtId)
	{
    	Criteria criteria = getSession().createCriteria(StationHistoryData.class);
    	criteria.add(Restrictions.eq("districtId", districtId));
    	criteria.setMaxResults(1);
     	criteria.addOrder(Order.desc("id"));
    	return criteria.list();
	}
}
