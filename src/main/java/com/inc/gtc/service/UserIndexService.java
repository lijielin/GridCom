package com.inc.gtc.service;

import com.inc.gtc.domain.UserIndex;

public interface UserIndexService extends BaseService<UserIndex>{

	void removeUnitUser(String unit);
	
	UserIndex findIndex(String email,String tel);
}
