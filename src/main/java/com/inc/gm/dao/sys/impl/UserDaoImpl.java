package com.inc.gm.dao.sys.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gm.dao.GmBaseDaoImpl;
import com.inc.gm.dao.sys.UserDao;
import com.inc.gm.domain.sys.User;

/**
 * UserDao
 *
 * @author 
 * @version 2015-08-27 09:33:30
 * @param 
 */
@Repository("gmUserDao")
public class UserDaoImpl<riteria> extends GmBaseDaoImpl<User> implements UserDao{

	@SuppressWarnings("unchecked")
	@Override
	public User find(String name) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		List<User> rs = criteria.list();
		if (rs.size() > 0)
			return rs.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByPhoneAndEmail(String str) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.or(Restrictions.eq("phone", str),Restrictions.eq("email", str)));
		List<User> rs = criteria.list();
		if (rs.size() > 0)
			return rs.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findEM(String email) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		List<User> rs = criteria.list();
		if (rs.size() > 0)
			return rs.get(0);
		else
			return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public User findPH(String phone) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("phone", phone));
		List<User> rs = criteria.list();
		if (rs.size() > 0)
			return rs.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User find(Integer userId) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("id", userId));
		List<User> rs = criteria.list();
		if (rs.size() > 0)
			return rs.get(0);
		else
			return null;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<User> find(Integer[] userIds) {
		Criteria criteria = this.getSession().createCriteria(User.class);
		criteria.add(Restrictions.in("id", userIds));
		return criteria.list();
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findAll() {
		Criteria criteria = this.getSession().createCriteria(User.class)
				.createAlias("dept", "dept");
		return criteria.list();
	}
	
	public void removeAllUser()
	{
		String hql="delete User as u";
		Query query=getSession().createQuery(hql);
		query.executeUpdate();
	}
}
