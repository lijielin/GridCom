package com.inc.gtc.fire.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.BaseModeDao;
import com.inc.gtc.fire.domain.BaseMode;
import com.inc.gtc.fire.service.BaseModeService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:55:12
 * 模式与预警有效周期service
 */
@Service("baseModeService")
public class BaseModeServiceImpl extends BaseServiceImpl<BaseMode, BaseModeDao> implements BaseModeService {
	@Resource(name="baseModeDao")
	public void setDao(BaseModeDao dao){
		super.setDao(dao);
	}
	public BaseMode findBaseMode(String stationNumber){
		try {
			Collection<BaseMode> list = this.getDao().findBaseMode(stationNumber);
			if(list != null && list.size() > 0){
				return list.iterator().next();
			}
		} catch (Throwable e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		return null;
	}
}
