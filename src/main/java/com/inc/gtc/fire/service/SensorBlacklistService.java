package com.inc.gtc.fire.service;

import java.util.Collection;

import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.domain.SensorBlacklist;
import com.itc.service.BaseService;

public interface SensorBlacklistService extends BaseService<SensorBlacklist> {
	SensorBlacklist findBlacklist(Integer sensorId);
	void addBlacklist(Collection<FireSensor> listSensor);
}
