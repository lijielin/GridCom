package com.inc.gtc.fire.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.PhoneFeeHistoryDao;
import com.inc.gtc.fire.domain.PhoneFeeHistory;
import com.inc.gtc.fire.service.PhoneFeeHistoryService;
import com.itc.service.BaseServiceImpl;
@Service("phoneFeeHistoryService")
public class PhoneFeeHistroyServiceImpl extends BaseServiceImpl<PhoneFeeHistory,PhoneFeeHistoryDao> implements PhoneFeeHistoryService{
	@Resource(name="phoneFeeHistoryDao")
	public void setDao(PhoneFeeHistoryDao dao)
	{
		super.setDao(dao);
	}
	
	public PhoneFeeHistory findLastFeeByPhone(String phone)
	{
		return this.getDao().findLastFeeByPhone(phone);
	}
	
	public PhoneFeeHistory findFeeByPhone(String phone,Date nowTime)
	{
		return this.getDao().findFeeByPhone(phone,nowTime);
	}
}
