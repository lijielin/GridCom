package com.inc.gm.dao.sys;

import java.util.Collection;

import com.inc.gm.domain.sys.User;
import com.itc.dao.BaseDao;

/**
 * UserDao
 *
 * @author 
 * @version 2015-08-27 09:33:30
 */
public interface UserDao extends BaseDao<User>{
	User find(String name);
	
	User findEM(String email);
	
	User findPH(String phone);

	User find(Integer userId);
	
	User findByPhoneAndEmail(String str);

	Collection<User> find(Integer[] userIds);

	Collection<User> findAll();
	
	void removeAllUser();


}
