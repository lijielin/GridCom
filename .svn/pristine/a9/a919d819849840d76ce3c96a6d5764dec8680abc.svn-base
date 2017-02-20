package com.inc.gtc.fire.service.impl;


import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.StationHistoryDataDao;
import com.inc.gtc.fire.domain.StationHistoryData;
import com.inc.gtc.fire.service.StationHistoryDataService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 */
@Service("stationHistoryDataService")
public class StationHistoryDataServiceImpl extends BaseServiceImpl<StationHistoryData, StationHistoryDataDao> implements StationHistoryDataService {
	@Resource(name="stationHistoryDataDao")
	public void setDao(StationHistoryDataDao dao){
		super.setDao(dao);
	}
	
	public StationHistoryData findStationHistoryData(String stationCode){
		Collection<StationHistoryData> list = this.getDao().findStationHistoryData(stationCode);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}else{
			return null;
		}
	}
	
	public StationHistoryData findStationData(Integer districtId){
		Collection<StationHistoryData> list = this.getDao().findStationData(districtId);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}else{
			return null;
		}
	}
	
	public StationHistoryData findStationHistoryData(String StationCode,Date date){
		Collection<StationHistoryData> list = this.getDao().findLeastStationHistoryData(StationCode,date);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}else{
			return null;
		}
	}
}
