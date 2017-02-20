package com.inc.gtc.fire.service;

import com.inc.gtc.fire.domain.SensorHistoryData;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:52:12
 * 探测器的实时数据，温度，电压等service
 */
public interface SensorHistoryDataService extends BaseService<SensorHistoryData> {
	SensorHistoryData findSensorHistoryData(String sensorCode,String dateStr);
}
