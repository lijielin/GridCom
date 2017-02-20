package com.inc.gtc.fire.dao;


import java.util.Date;

import com.inc.gtc.fire.domain.PhoneFeeHistory;
import com.itc.dao.BaseDao;


public interface PhoneFeeHistoryDao extends BaseDao<PhoneFeeHistory>{
	
	PhoneFeeHistory findLastFeeByPhone(String phone);
	
	PhoneFeeHistory findFeeByPhone(String phone,Date nowTime);
}
