package com.inc.gtc.fire.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.TipsDao;
import com.inc.gtc.fire.domain.Tips;
import com.inc.gtc.fire.service.TipsService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2013-5-17 上午10:52:08
 * 类说明
 */
@Service("tipsService")
public class TipsServiceImpl extends BaseServiceImpl<Tips,TipsDao> implements TipsService{

	@Override
	@Resource(name="tipsDao")
	public void setDao(TipsDao dao)
	{
		super.setDao(dao);
	}
	
	
	public Tips getTipByCode(String code)
	{
		return this.getDao().getTipByCode(code);
	}
	
	public Tips getTipByCodeFromCache(String code){
		Tips tips = this.getTipByCode(code);
		return tips;
	}
	

}
