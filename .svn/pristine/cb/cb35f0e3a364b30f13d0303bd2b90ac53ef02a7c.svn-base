package com.inc.gtc.fire.service;

import java.util.Collection;

import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireSensor;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 探测器历史service
 */
public interface FireSensorService extends BaseService<FireSensor> {
	 Collection<FireSensor> getSensorByStatus(District distrct,Integer state);

	FireSensor getFireSensorByNumber(String number);
	
	/**
	 * 按照探测器编号或则显示编号查询探测器
	 * @param number
	 * @return
	 */
	FireSensor findSensorByNumberOrNo(String number,District district);
	void update(FireSensor fireSensor);
	void updateFireSensorState(Collection<FireSensor>list,Integer state);
	
	Collection<FireSensor> findSensors(District district);
}
