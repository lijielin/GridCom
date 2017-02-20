package com.inc.gtc.fire.service.impl;


import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.FireSensorDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.service.FireSensorService;
import com.itc.Utils;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 探测器service
 */
@Service("fireSensorService")
public class FireSensorServiceImpl extends BaseServiceImpl<FireSensor, FireSensorDao> implements FireSensorService {
	
	@Resource(name="fireSensorDao")
	public void setDao(FireSensorDao dao){
		super.setDao(dao);
	}
	
	public Collection<FireSensor> getSensorByStatus(District distrct,Integer state)
	{
		return this.getDao().getSensorByStatus(distrct, state);
	}
	public void update(FireSensor fireSensor){
		try {
			fireSensor.setFiredate(Utils.convertDateToString(Utils.nowFullTime(), "yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.save(fireSensor);
	}
	


	public FireSensor findSensorByNumberOrNo(String number,District district)
	{
		return this.getDao().findSensorByNumberOrNo(number, district);
	}
	
	public void updateFireSensorState(Collection<FireSensor>list,Integer state){
		for(FireSensor sensor : list){
			sensor.setState(state);
			this.getDao().save(sensor);
		}
	}
	
	public FireSensor getFireSensorByNumber(String number){
		Collection<FireSensor>list =  this.getDao().getFireSensorByNumber(number);
		if(list != null && list.size() > 0){
			FireSensor sensor =  list.iterator().next();
			if (sensor.getBaseStation()!=null)
				sensor.getBaseStation().setNumber(sensor.getBaseStation().getNumber());
			return sensor;
		}
		return null;
	}
	
	public Collection<FireSensor> findSensors(District district)
	{
		return this.getDao().findSensors(district);
	}
	
}
