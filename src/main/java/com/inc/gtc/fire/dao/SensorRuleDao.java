package com.inc.gtc.fire.dao;

import java.util.Collection;
import java.util.Date;

import com.inc.gtc.fire.domain.SensorRule;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2012-5-7 上午10:49:24
 * 探测器自动获取信息的规则dao
 */
public interface SensorRuleDao extends BaseDao<SensorRule> {
	Collection<SensorRule> findSensorRule( Date begainDate, Date endDate);
	
	int countSensorRule( Date begainDate, Date endDate);
	
	Collection<SensorRule> findSensorRule( Date begainDate, Date endDate, int startIndex, int endIndex);
}
