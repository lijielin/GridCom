package com.inc.gm.service.sys;

import java.util.Collection;

import com.inc.gm.domain.sys.Dept;
import com.inc.gm.domain.sys.User;
import com.inc.gm.service.BaseService;


/**
 * UserService
 *
 * @author 
 * @version 2015-08-27 09:33:30
 */
public interface UserService extends BaseService<User>{
	

	User check(String name);
	
	User findEM(String email);
	
	User findPH(String phone);

	User find(Integer userid);
	
	Collection<User> findAll();
	
	Collection<User> find(Integer[] userIds);

	User save(User user, Dept dept);
	
	void savePwd(User user,String pwd);
	
	void removeAllUser();
	

}
