package com.inc.gtc.fire.service;

import java.util.Collection;

import com.inc.gtc.fire.domain.District;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 地区service
 */
public interface DistrictService extends BaseService<District> {
	District findDistrictByCode(String code);
	District findDistrictByName(String name);
	Collection<District> loadAll();
}
