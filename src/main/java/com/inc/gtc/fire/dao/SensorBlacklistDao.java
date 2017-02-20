package com.inc.gtc.fire.dao;

import com.inc.gtc.fire.domain.SensorBlacklist;
import com.itc.dao.BaseDao;

public interface SensorBlacklistDao extends BaseDao<SensorBlacklist> {
	SensorBlacklist findBlacklist(Integer sensorId);
}
