package com.inc.gtc.sms.req;

import java.util.Map;

public interface SmsReq {

	Map<String,String> getReqEntity();
	
	String getUrl();
}
