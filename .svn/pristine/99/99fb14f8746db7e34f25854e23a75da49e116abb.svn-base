package com.inc.gtc.fire.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.BaseStationDao;
import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.service.BaseStationService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 基站service
 */
@Service("baseStationService")
public class BaseStationServiceImpl extends BaseServiceImpl<BaseStation, BaseStationDao> implements BaseStationService {
	@Resource(name="baseStationDao")
	public void setDao(BaseStationDao dao){
		super.setDao(dao);
	}
	public BaseStation findBaseStationByCode(String orginnumber,String code){
		Collection<BaseStation> list = this.getDao().findBaseStationByCode(orginnumber,code);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}
		return null;
	}
	
	public BaseStation findBaseStationByPhone(String phone){
		Collection<BaseStation> list = this.getDao().findBaseStationByPhone(phone);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}
		return null;
	}
	@Override
	public Collection<BaseStation> loadAll() {
		return this.getDao().loadAll();
	}
	
	public Collection<BaseStation>  findStation(District district)
	{
		return this.getDao().findStation(district);
	}
}
