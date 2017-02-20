package com.inc.gtc.fire.dao;

import java.util.Collection;
import java.util.Date;

import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireSensor;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 探测器dao
 */
public interface FireSensorDao extends BaseDao<FireSensor> {
	
	 Collection<FireSensor> getSensorByStatus(District distrct,Integer state);
	FireSensor findSensorByNumberOrNo(String number,District district);
	 Collection<FireSensor> findFireSensors(District district,Date fireDate,Date releastTime);
	Collection<FireSensor> getFireSensorByNumber(String number);
	Collection<FireSensor> findSensors(District district);
}
