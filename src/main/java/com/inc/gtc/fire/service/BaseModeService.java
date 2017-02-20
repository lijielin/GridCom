package com.inc.gtc.fire.service;

import com.inc.gtc.fire.domain.BaseMode;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:52:12
 * 模式与预警有效周期service
 */
public interface BaseModeService extends BaseService<BaseMode> {
	BaseMode findBaseMode(String stationNumber);
}
