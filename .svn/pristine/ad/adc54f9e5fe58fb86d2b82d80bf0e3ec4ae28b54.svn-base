package com.inc.gtc.fire.service.impl;


import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.SensorBlacklistDao;
import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.domain.SensorBlacklist;
import com.inc.gtc.fire.service.SensorBlacklistService;
import com.itc.Utils;
import com.itc.service.BaseServiceImpl;

@Service("sensorBlacklistService")
public class SensorBlacklistServiceImpl extends BaseServiceImpl<SensorBlacklist, SensorBlacklistDao> implements SensorBlacklistService {
	@Resource(name="sensorBlacklistDao")
	public void setDao(SensorBlacklistDao dao){
		super.setDao(dao);
	}
	public SensorBlacklist findBlacklist(Integer sensorId){
		return this.getDao().findBlacklist(sensorId);
	}
	
	public void addBlacklist(Collection<FireSensor> listSensor){
		SensorBlacklist blacklist = null;
		Date addTime = Utils.nowFullTime();
		for(FireSensor sensor : listSensor){
			blacklist = this.getDao().findBlacklist(sensor.getId());
			if(blacklist == null){
				blacklist = new SensorBlacklist(sensor);
			}
			blacklist.setAddTime(addTime );
			this.getDao().save(blacklist);
		}
	}
}
