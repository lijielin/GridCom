package com.inc.gtc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gtc.dao.UserIndexDao;
import com.inc.gtc.domain.UserIndex;
import com.inc.gtc.service.UserIndexService;

@Service("userIndexService")
public class UserIndexServiceImpl extends BaseServiceImpl<UserIndex,UserIndexDao> implements UserIndexService{

	@Override
	@Autowired
	public void setDao(UserIndexDao dao)
	{
		super.setDao(dao);
	}
	
	public void removeUnitUser(String unit)
	{
		this.getDao().removeUnitUser(unit);
	}
	
	public 	UserIndex findIndex(String email,String tel)
	{
		return this.getDao().findIndex(email,tel);
	}
}
