package com.inc.gtc.fire.dao.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.BaseStationDao;
import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.District;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 基站dao
 */
@Repository("baseStationDao")
public class BaseStationDaoImpl extends BaseDaoImpl<BaseStation> implements BaseStationDao {
	@SuppressWarnings("unchecked")
	public Collection<BaseStation> findBaseStationByCode(final String orginnumber,final String code)
	{
    	Criteria criteria = getSession().createCriteria(BaseStation.class);
    	if (orginnumber!=null && orginnumber.length()>8)
    	{
    		criteria.add(Restrictions.eq("number",orginnumber));
    	}
    	else
    	{
    		criteria.add(Restrictions.or(Restrictions.eq("number",orginnumber),Restrictions.or(Restrictions.eq("number","8623" + code),Restrictions.eq("number",code))));
    	}
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<BaseStation> findBaseStationByPhone(final String phone)
	{
		Criteria criteria = getSession().createCriteria(BaseStation.class).setMaxResults(1);
    	if (phone.indexOf("86")==0)
    	{
    		String phone1 = phone.replaceFirst("86", "");
    		criteria.add(Restrictions.or(Restrictions.eq("telephone",phone), 
    				Restrictions.eq("telephone",phone1)));
    	}
    	else
    	{
    		criteria.add(Restrictions.eq("telephone",phone));
    	}
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();   
	}
	
	@SuppressWarnings("unchecked")
	public Collection<BaseStation> loadAll()
	{
    	Criteria criteria = getSession().createCriteria(BaseStation.class);
    	criteria.add(Restrictions.isNotNull("telephone"));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	public Collection<BaseStation>  findStation(District district)
	{
		Criteria criteria = getSession().createCriteria(BaseStation.class);
    	criteria.add(Restrictions.eq("district",district));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
}
