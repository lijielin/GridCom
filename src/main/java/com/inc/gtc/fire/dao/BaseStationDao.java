package com.inc.gtc.fire.dao;

import java.util.Collection;

import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.District;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 基站dao
 */
public interface BaseStationDao extends BaseDao<BaseStation> {
	Collection<BaseStation> findBaseStationByCode(String orginnumber,String code);
	Collection<BaseStation> findBaseStationByPhone(String phone);
	Collection<BaseStation> loadAll();
	Collection<BaseStation>  findStation(District district);
}
