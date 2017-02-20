package com.inc.gtc.fire.dao.impl;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.SensorHistoryDataDao;
import com.inc.gtc.fire.domain.SensorHistoryData;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:51:23
 * 探测器的实时数据，温度，电压等dao
 */
@Repository("sensorHistoryDataDao")
public class SensorHistoryDataDaoImpl extends BaseDaoImpl<SensorHistoryData> implements SensorHistoryDataDao {
	@SuppressWarnings("unchecked")
	public Collection<SensorHistoryData> findSensorHistoryData(final String sensorCode,final String dateStr)
	{
    	Criteria criteria = getSession().createCriteria(SensorHistoryData.class);
    	criteria.add(Restrictions.eq("sensorCode", sensorCode));
    	criteria.add(Restrictions.eq("addTimeStr", dateStr));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
}
