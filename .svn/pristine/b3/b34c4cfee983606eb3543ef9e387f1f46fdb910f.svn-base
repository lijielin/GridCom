package com.inc.gtc.fire.service;
import java.util.Collection;
import java.util.Date;

import com.inc.gtc.fire.domain.SensorRule;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:52:12
 * 探测器自动获取信息的规则等service
 */
public interface SensorRuleService extends BaseService<SensorRule> {
	Collection<SensorRule> findSensorRule(Date nowDate);
	
	int countSensorRule(Date nowDate);
	
	Collection<SensorRule> findSensorRule(Date nowDate,int startIndex, int endIndex) ;
	
	void saveAllSensorRule();
}
