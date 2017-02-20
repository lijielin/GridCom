package com.inc.gtc.fire.service;


import java.util.Collection;

import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.District;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 基站service
 */
public interface BaseStationService extends BaseService<BaseStation> {
	BaseStation findBaseStationByCode(String orginnumber,String code);
	BaseStation findBaseStationByPhone(String phone);
	Collection<BaseStation> loadAll();
	Collection<BaseStation>  findStation(District district);
}
