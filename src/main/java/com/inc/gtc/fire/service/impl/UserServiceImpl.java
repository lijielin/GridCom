package com.inc.gtc.fire.service.impl;


import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.UserDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.User;
import com.inc.gtc.fire.service.UserService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 用户service
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {
	@Resource(name="userDao")
	public void setDao(UserDao dao){
		super.setDao(dao);
	}
	public Collection<User> getDistrictUsers(District district)
	{
		return this.getDao().getDistrictUsers(district);
	}
	
	public Collection<User> findUserByPhone(String phone){
		return this.getDao().findUserByPhone(phone);
	}
	
	public void updateIsSendWeather(String phone,int isSendWeather){
		Collection<User> list = this.getDao().findUserByPhone(phone);
		for(User user : list){
			user.setIsSendWeather(isSendWeather);
			this.getDao().save(user);
		}
		
	}
	
	public Collection<User> getDistrictRangerUsers(District district){
		return this.getDao().getDistrictRangerUsers(district);
	}
}
