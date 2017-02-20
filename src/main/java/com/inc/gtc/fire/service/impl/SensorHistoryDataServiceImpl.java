package com.inc.gtc.fire.service.impl;


import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.SensorHistoryDataDao;
import com.inc.gtc.fire.domain.SensorHistoryData;
import com.inc.gtc.fire.service.SensorHistoryDataService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:55:12
 * 探测器的实时数据，温度，电压等service
 */
@Service("sensorHistoryDataService")
public class SensorHistoryDataServiceImpl extends BaseServiceImpl<SensorHistoryData, SensorHistoryDataDao> implements SensorHistoryDataService {
	@Resource(name="sensorHistoryDataDao")
	public void setDao(SensorHistoryDataDao dao){
		super.setDao(dao);
	}
	
	public SensorHistoryData findSensorHistoryData(String sensorCode,String dateStr){
		Collection<SensorHistoryData> list = this.getDao().findSensorHistoryData(sensorCode,dateStr);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}else{
			return null;
		}
	}
}
