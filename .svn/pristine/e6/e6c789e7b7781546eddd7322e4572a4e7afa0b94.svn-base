package com.inc.gtc.fire.dao;

import java.util.Collection;

import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.User;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 用户dao
 */
public interface UserDao extends BaseDao<User> {
	Collection<User> getDistrictUsers(District district);
	Collection<User> findUserByPhone(String phone);
	
	Collection<User> getDistrictRangerUsers(District district);
}
