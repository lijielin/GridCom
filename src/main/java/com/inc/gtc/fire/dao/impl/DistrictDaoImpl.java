package com.inc.gtc.fire.dao.impl;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.DistrictDao;
import com.inc.gtc.fire.domain.District;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 地区dao
 */
@Repository("districtDao")
public class DistrictDaoImpl extends BaseDaoImpl<District> implements DistrictDao {
	@SuppressWarnings("unchecked")
	public Collection<District> findDistrictByCode(final String code)
	{
		System.out.println("distirct code find");
    	Criteria criteria = getSession().createCriteria(District.class);
    	criteria.add(Restrictions.eq("code",code));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<District> findDistrictByName(final String name)
	{
    	Criteria criteria = getSession().createCriteria(District.class);
    	criteria.add(Restrictions.eq("name",name));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<District> loadAll()
	{
		Criteria criteria = getSession().createCriteria(District.class);
	//				        	criteria.add(Restrictions.ne("lat", 0d));
	//				        	criteria.add(Restrictions.ne("lng", 0d));
	 	criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}
	
}
