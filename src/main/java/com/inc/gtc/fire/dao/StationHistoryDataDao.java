package com.inc.gtc.fire.dao;


import java.util.Collection;
import java.util.Date;

import com.inc.gtc.fire.domain.StationHistoryData;
import com.itc.dao.BaseDao;




/**
 * @author itc.tzj
 */
public interface StationHistoryDataDao extends BaseDao<StationHistoryData> {
	Collection<StationHistoryData> findStationHistoryData(String stationCode);
	Collection<StationHistoryData> findLeastStationHistoryData(String stationCode,Date date);
	Collection<StationHistoryData> findStationData(Integer districtId);
}
