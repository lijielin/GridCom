package com.inc.gtc.sms.req;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractReq implements SmsReq{

	private String apikey;
	
	private String SpCode;
	
	private String LoginName;
	
	private String Password;
	
	private String SerialNumber ;
	
	private String f;
	
	private String ScheduleTime ;
	

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
	
	public String getSpCode() {
		return SpCode;
	}

	public void setSpCode(String spCode) {
		SpCode = spCode;
	}

	public String getLoginName() {
		return LoginName;
	}

	public void setLoginName(String loginName) {
		LoginName = loginName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	
	

	public String getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		SerialNumber = serialNumber;
	}
	

	public String getF() {
		return f;
	}

	public void setF(String f) {
		this.f = f;
	}
	
	

	public String getScheduleTime() {
		return ScheduleTime;
	}

	public void setScheduleTime(String scheduleTime) {
		ScheduleTime = scheduleTime;
	}

	public Map<String,String> getReqEntity()
	{
		Map<String,String> data = new HashMap<String,String>();
//		data.put("apikey", this.apikey);
		data.put("SpCode",SpCode);
		data.put("LoginName",LoginName);
		data.put("Password",Password);
		data.put("SerialNumber", SerialNumber);
		data.put("f", f);
		data.put("ScheduleTime", ScheduleTime);
		return data;
	}

	
}
