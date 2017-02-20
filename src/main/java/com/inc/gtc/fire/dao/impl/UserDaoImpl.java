package com.inc.gtc.fire.dao.impl;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.UserDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.User;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 用户dao
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	public Collection<User> getDistrictUsers(final District district)
	{
        Criteria crit = getSession().createCriteria(User.class);
        crit.add(Restrictions.eq("district", district));
        return crit.list();
	}
	
	public Collection<User> getDistrictRangerUsers(final District district)
	{ 
        Criteria crit = getSession().createCriteria(User.class);
        crit.add(Restrictions.eq("district", district));
        crit.add(Restrictions.eq("isRanger", 1));
        return crit.list();
	}
	
	public Collection<User> findUserByPhone(final String phone)
	{ 
        Criteria crit = getSession().createCriteria(User.class);
        crit.add(Restrictions.eq("telephone", phone));
        return crit.list();
	}
}
