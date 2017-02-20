package com.inc.gtc.fire.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.DistrictDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.service.DistrictService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 地区service
 */
@Service("districtService")
public class DistrictServiceImpl extends BaseServiceImpl<District, DistrictDao> implements DistrictService {
	@Resource(name="districtDao")
	public void setDao(DistrictDao dao){
		super.setDao(dao);
	}
	public District findDistrictByCode(String code){
		Collection<District> list = this.getDao().findDistrictByCode(code);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}
		return null;
	}
	public District findDistrictByName(String name){
		Collection<District> list = this.getDao().findDistrictByName(name);
		if(list != null && list.size() > 0){
			return list.iterator().next();
		}
		return null;
	}
	public Collection<District> loadAll(){
		return this.getDao().loadAll();
	}
}
