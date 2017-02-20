package com.inc.gtc.fire.dao.impl;


import java.util.Collection;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.FireHistoryDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireHistory;
import com.itc.Utils;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 报警历史dao
 */
@Repository("fireHistoryDao")
public class FireHistoryDaoImpl extends BaseDaoImpl<FireHistory> implements FireHistoryDao {
	
	public Collection<FireHistory> findEffectFireHistory(final District district,final Date startTime)
	{
	        	Criteria criteria = getSession().createCriteria(FireHistory.class)
	        	.createAlias("fireSensor", "f");
	        	if(district != null)
	        		criteria.add(Restrictions.eq("f.district", district));
//				        	criteria.add(Restrictions.eq("f.state", Integer.parseInt(MessageUtils.DATA_CODE_FIRE)));
	        	criteria.add(Restrictions.eq("valid", 1));
	        	criteria.add(Restrictions.eq("use", 1));
	        	criteria.add(Restrictions.ge("addTime", startTime));
	         	criteria.addOrder(Order.asc("id"));
	        	return criteria.list();
	}
	
	public int findFireHistoryCount(final FireHistory his,final String baseCode,final String sensorCode,final Date startTime,final Date endTime)
	{
        	Criteria criteria = getSession().createCriteria(FireHistory.class);
        	if (his!=null)
        	{
        		criteria.add(Restrictions.ne("id", his.getId()));
        	}
        	//criteria.add(Restrictions.eq("baseCode", baseCode));
        	criteria.add(Restrictions.eq("sensorCode", sensorCode));
        	criteria.add(Restrictions.ge("addTime", startTime));
        	criteria.add(Restrictions.le("addTime", endTime));
        	criteria.add(Restrictions.le("valid", 1));
        	Object rs = criteria.setProjection(Projections.rowCount()).uniqueResult();
        	if (rs!=null)
        	{
        		return Integer.parseInt(rs.toString());
        	}
        	else
        	{
        		return 0;
        	}
				    
	}
	
	@SuppressWarnings("unchecked")
	public Integer findEffectFireHistoryCount(final District district,final Date startTime)
	{
	        	Criteria criteria = getSession().createCriteria(FireHistory.class)
	        	.createAlias("fireSensor", "f");
	        	if(district != null)
	        		criteria.add(Restrictions.eq("f.district", district));
//				        	criteria.add(Restrictions.eq("f.state", Integer.parseInt(MessageUtils.DATA_CODE_FIRE)));
	        	criteria.add(Restrictions.eq("valid", 1));
	        	criteria.add(Restrictions.eq("use", 1));
	        	criteria.add(Restrictions.ge("addTime", startTime));
	         	criteria.addOrder(Order.asc("id"));
	         	criteria.setProjection(Projections.rowCount());
        	return Integer.parseInt(criteria.uniqueResult().toString());
	}
	/**
	 * 查找某个探测器某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	@SuppressWarnings("unchecked")
	public Collection<FireHistory> findFireHistory(final String baseCode,final String sensorCode,final String seq)
	{
    	Criteria criteria = getSession().createCriteria(FireHistory.class);
    	criteria.add(Restrictions.eq("baseCode", baseCode));
    	criteria.add(Restrictions.eq("sensorCode", sensorCode));
    	criteria.add(Restrictions.eq("seq", seq));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	/**
	 * 查找某个探测器某个时间段内某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	@SuppressWarnings("unchecked")
	public Collection<FireHistory> findLastFireHistory(final String baseCode,final String sensorCode,final String seq,final Date startTime,final Date endTime)
	{
        	Criteria criteria = getSession().createCriteria(FireHistory.class);
        	criteria.add(Restrictions.eq("baseCode", baseCode));
        	criteria.add(Restrictions.eq("sensorCode", sensorCode));
        	criteria.add(Restrictions.eq("seq", seq));
        	if(startTime != null)
        		criteria.add(Restrictions.ge("addTime", startTime));
        	if(endTime != null)
        		criteria.add(Restrictions.le("addTime", endTime));
         	criteria.addOrder(Order.asc("id"));
        	return criteria.list();
	}
	
	/**
	 * 查找某个探测器在某个时间段的历史
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * */
	@SuppressWarnings("unchecked")
	public Collection<FireHistory> findFireHistory(final String baseCode,final String sensorCode,final Date startTime,final Date endTime)
	{
    	Criteria criteria = getSession().createCriteria(FireHistory.class);
    	criteria.add(Restrictions.eq("baseCode", baseCode));
    	criteria.add(Restrictions.eq("sensorCode", sensorCode));
//				        	criteria.add(Restrictions.between("addTime", startTime, endTime));
    	criteria.add(Restrictions.ge("addTime", startTime));
    	criteria.add(Restrictions.le("addTime", endTime));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	/**
	 * 查找某个探测器在某个时间段的历史
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param d 报警信息中的d d为01 23时为测试火警,测试火警时class为00 00，正常火警时为FF FF
	 * */
	@SuppressWarnings("unchecked")
	public Collection<FireHistory> findFireHistory(final String baseCode,final String sensorCode,final Date startTime,final Date endTime,final String d)
	{
    	Criteria criteria = getSession().createCriteria(FireHistory.class);
    	criteria.add(Restrictions.eq("baseCode", baseCode));
    	criteria.add(Restrictions.eq("sensorCode", sensorCode));
//				        	criteria.add(Restrictions.between("addTime", startTime, endTime));
    	criteria.add(Restrictions.ge("addTime", startTime));
    	criteria.add(Restrictions.le("addTime", endTime));
    	if("01 23".equals(d)){
    		criteria.add(Restrictions.eq("glass", "00 00"));
    	}else{
    		criteria.add(Restrictions.eq("glass", "FF FF"));
    	}
    	criteria.add(Restrictions.eq("valid", 1));
     	criteria.addOrder(Order.asc("id"));
    	return criteria.list();
	}
	
	/**
	 * 查找某个地区的未处理的报警历史
	 * @param district 地区
	 * */
	@SuppressWarnings("unchecked")
	public Collection<FireHistory> findValidFireHistory(final District district)
	{
    	Criteria criteria = getSession().createCriteria(FireHistory.class)
    	.createAlias("fireSensor", "f");
    	if(district != null)
    		criteria.add(Restrictions.eq("f.district", district));
//				        	criteria.add(Restrictions.eq("f.state", Integer.parseInt(MessageUtils.DATA_CODE_FIRE)));
    	criteria.add(Restrictions.eq("valid", 1));
    	criteria.add(Restrictions.eq("use", 0));
    	Date nowtime = Utils.nowFullTime();
    	try {
    		//处理1天内的
			nowtime = Utils.addTimeByDay(nowtime, -1);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	criteria.add(Restrictions.ge("addTime", nowtime));
     	criteria.addOrder(Order.desc("id"));
    	return criteria.list();
	}
	
	
	public Integer findFireHistorySize(final String baseCode,final String sensorCode,final Date startTime,final Date endTime,final String d)
	{
    	Criteria criteria = getSession().createCriteria(FireHistory.class);
    	criteria.add(Restrictions.eq("baseCode", baseCode));
    	criteria.add(Restrictions.ge("addTime", startTime));
    	criteria.add(Restrictions.le("addTime", endTime));
    	if("01 23".equals(d)){
    		criteria.add(Restrictions.eq("glass", "00 00"));
    	}else{
    		criteria.add(Restrictions.eq("glass", "FF FF"));
    	}
     	criteria.addOrder(Order.asc("id"));
    	Object rs = criteria.uniqueResult();
    	if (rs!=null)
    		return Integer.parseInt(rs.toString());
    	else
    		return 0;
	}
	
	public Integer findCrSize(final String sensorCode,final String cr,final Date startTime,final Date endTime,final String d)
	{
    	Criteria criteria = getSession().createCriteria(FireHistory.class);
    	criteria.add(Restrictions.eq("sensorCode", sensorCode));
    	criteria.add(Restrictions.eq("cr", cr));
    	criteria.add(Restrictions.ge("addTime", startTime));
    	criteria.add(Restrictions.le("addTime", endTime));
    	if("01 23".equals(d)){
    		criteria.add(Restrictions.eq("glass", "00 00"));
    	}else{
    		criteria.add(Restrictions.eq("glass", "FF FF"));
    	}
     	criteria.addOrder(Order.asc("id"));
    	Object rs = criteria.uniqueResult();
    	if (rs!=null)
    		return Integer.parseInt(rs.toString());
    	else
    		return 0;
	}
}
