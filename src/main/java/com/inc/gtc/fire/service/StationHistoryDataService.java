package com.inc.gtc.fire.service;


import java.util.Date;

import com.inc.gtc.fire.domain.StationHistoryData;
import com.itc.service.BaseService;


/**
 * @author itc.tzj
 */
public interface StationHistoryDataService extends BaseService<StationHistoryData> {
	StationHistoryData findStationHistoryData(String stationCode);
	StationHistoryData findStationHistoryData(String stationCode,Date date);
	StationHistoryData findStationData(Integer districtId);
}
