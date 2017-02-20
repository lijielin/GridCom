package com.inc.gtc.service;

import com.inc.gtc.domain.SysTask;
import com.inc.gtc.domain.Unit;

public interface MigrateService {

	/**
	 * 执行建库任务
	 * @param task
	 */
	void executeTask(SysTask task);
	
	/**
	 * 按地区迁移
	 * @param district
	 */
	void migrateDistrict(String districtCode);
	
	
	void createDb(Unit unit);
}
