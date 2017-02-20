package com.inc.gm.service.sys.impl;

import java.util.Collection;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inc.gm.dao.sys.UserDao;
import com.inc.gm.domain.sys.Dept;
import com.inc.gm.domain.sys.User;
import com.inc.gm.service.BaseServiceImpl;
import com.inc.gm.service.sys.UserService;
import com.itc.util.DomainUtils;
import com.itc.util.EncryptUtils;


/**
 * UserService
 *
 * @author 
 * @version 2015-08-27 09:33:30
 */
@Service("gmUserService")
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService{
	
	

	@Resource(name="gmUserDao")
	public void setDao(UserDao dao)
	{
		super.setDao(dao);
	}


	@Override
	public User find(Integer userid) {
		return getDao().find(userid);
	}

	@Override
	public Collection<User> find(Integer[] userIds) {
		return getDao().find(userIds);
	}

	@Override

	public User save(User arg, Dept dept) {
		// TODO Auto-generated method stub
		User user = null;
		if (arg.getId()!=null)
		{
			user = this.get(arg.getId());
			DomainUtils.copyProperties(user, arg,new String[]{"pwd"});
		}
		else
		{
			user = arg;
			user.setPwd(EncryptUtils.MD5(user.getPwd()));
		}

		user.setDept(dept);
		///userIndexService.sync(user);
		return super.save(user);
	}
	@Transactional
	public void savePwd(User user,String pwd){
		
		user.setPwd(EncryptUtils.MD5(pwd));
		
		super.save(user);
	}

	@Override
	public User check(String name) {
		// TODO Auto-generated method stub
		return getDao().find(name);
	}

	@Override
	public Collection<User> findAll() {
		return getDao().findAll();
	}

	@Override
	public User findEM(String email) {
		// TODO Auto-generated method stub
		return getDao().findEM(email);
	}

	@Override
	public User findPH(String phone) {
		// TODO Auto-generated method stub
		return getDao().findPH(phone);
	}
	
	public 	void removeAllUser()
	{
		 getDao().removeAllUser();
	}
}
