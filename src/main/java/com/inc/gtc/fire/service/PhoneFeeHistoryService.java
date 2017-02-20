package com.inc.gtc.fire.service;
import java.util.Date;

import com.inc.gtc.fire.domain.PhoneFeeHistory;
import com.itc.service.BaseService;



public interface PhoneFeeHistoryService extends BaseService<PhoneFeeHistory>{
	PhoneFeeHistory findLastFeeByPhone(String phone);
	PhoneFeeHistory findFeeByPhone(String phone,Date nowTime);
}
