package com.inc.gtc.fire.dao;
import java.util.Collection;

import com.inc.gtc.fire.domain.District;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 地区dao
 */
public interface DistrictDao extends BaseDao<District> {
	Collection<District> findDistrictByCode(String code);
	Collection<District> findDistrictByName(String name);
	
	Collection<District> loadAll();
}
