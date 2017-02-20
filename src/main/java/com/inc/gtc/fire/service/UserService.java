package com.inc.gtc.fire.service;

import java.util.Collection;

import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.User;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 用户service
 */
public interface UserService extends BaseService<User> {
	Collection<User> getDistrictUsers(District district);
	Collection<User> findUserByPhone(String phone);
	void updateIsSendWeather(String phone,int isSendWeather);
	
	Collection<User> getDistrictRangerUsers(District district);
}
