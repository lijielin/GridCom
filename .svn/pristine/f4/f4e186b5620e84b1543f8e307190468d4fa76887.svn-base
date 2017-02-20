package com.inc.gtc.fire.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.DisposalStepDao;
import com.inc.gtc.fire.domain.DisposalStep;
import com.inc.gtc.fire.service.DisposalStepService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.chenzhi
 * @version 创建时间：2013-5-17 上午10:52:08
 * 类说明
 */
@Service("disposalStepService")
public class DisposalStepServiceImpl extends BaseServiceImpl<DisposalStep,DisposalStepDao> implements DisposalStepService{

	@Override
	@Resource(name="disposalStepDao")
	public void setDao(DisposalStepDao dao)
	{
		super.setDao(dao);
	}
	
//	private CacheProvider cacheProvider;
//	@Resource(name="itcCacheProvider")
//	public void setCacheProvider(CacheProvider cacheProvider) {
//		this.cacheProvider = cacheProvider;
//	}
	
	public DisposalStep getStepByCode(String code)
	{
		return this.getDao().getStepByCode(code);
	}
	
	public DisposalStep getStepByCodeFromCache(String code){
		DisposalStep disposalStep = null;
//		if (cacheProvider.get(getCacheKey(code))!=null){
//			disposalStep = (DisposalStep)cacheProvider.get(getCacheKey(code));
//		}else{
			disposalStep  = this.getStepByCode(code);
//		}
		return disposalStep;
	}
	
//	private String getCacheKey(String code)
//	{
//		return Constants.disposal_step_key + "_" + code;
//	}
}
