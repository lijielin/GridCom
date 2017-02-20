package com.inc.gtc.fire.dao.impl;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.UnsentSMSDao;
import com.inc.gtc.fire.domain.UnsentSMS;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 消息dao
 */
@Repository("unsentSMSDao")
public class UnsentSMSDaoImpl extends BaseDaoImpl<UnsentSMS> implements UnsentSMSDao {
	@SuppressWarnings("unchecked")
	public Collection<UnsentSMS> loadAll()
	{
    	Criteria criteria = getSession().createCriteria(UnsentSMS.class);
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
}
