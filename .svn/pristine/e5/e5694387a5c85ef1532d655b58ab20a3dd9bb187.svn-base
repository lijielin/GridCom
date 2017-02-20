package com.inc.gtc.fire.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.PhoneFeeHistoryDao;
import com.inc.gtc.fire.domain.PhoneFeeHistory;
import com.itc.dao.h4.BaseDaoImpl;


@Repository("phoneFeeHistoryDao")
public class PhoneFeeHistoryDaoImpl extends BaseDaoImpl<PhoneFeeHistory> implements PhoneFeeHistoryDao{
	
	public PhoneFeeHistory findLastFeeByPhone(final String phone)
	{
        Criteria crit = getSession().createCriteria(PhoneFeeHistory.class);
        crit.add(Restrictions.eq("telephone", phone));
        crit.addOrder(Order.desc("createTime"));
        List<PhoneFeeHistory> result = crit.list();
        if (result!=null && result.size()>0)
        	return result.get(0);
        else
        	return null;
	}
	
	public PhoneFeeHistory findFeeByPhone(final String phone,final Date nowTime)
	{
            Criteria crit = getSession().createCriteria(PhoneFeeHistory.class);
            crit.add(Restrictions.eq("telephone", phone));
            crit.add(Restrictions.ge("createTime", nowTime));
            crit.addOrder(Order.desc("createTime"));
            List<PhoneFeeHistory> result = crit.list();
            if (result!=null && result.size()>0)
            	return result.get(0);
            else
            	return null;
	}
}
