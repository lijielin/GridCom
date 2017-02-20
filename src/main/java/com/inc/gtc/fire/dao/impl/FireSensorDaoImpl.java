package com.inc.gtc.fire.dao.impl;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.FireSensorDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireSensor;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 探测器dao
 */
@Repository("fireSensorDao")
public class FireSensorDaoImpl extends BaseDaoImpl<FireSensor> implements FireSensorDao {
	
	@Override
	public Collection<FireSensor> getSensorByStatus(final District distrct,final Integer state) {
            Criteria crit = getSession().createCriteria(FireSensor.class);
            crit.add(Restrictions.eq("state", state));
            crit.add(Restrictions.eq("district", distrct));
            crit.addOrder(Order.asc("firedate"));
            return crit.list(); 
	}
	@Override
	public FireSensor get(final java.io.Serializable id)
	{
            Criteria crit =   getSession().createCriteria(FireSensor.class);
            crit.add(Restrictions.eq("id",id));
            List<FireSensor> rs = crit.list();
            if (rs!=null && rs.size()>0)
            {
            	FireSensor sensor = rs.get(0);
            	if (sensor.getBaseStation()!=null)
    				sensor.getBaseStation().setNumber(sensor.getBaseStation().getNumber());
            	return sensor;
            }
            else
            {
            	return null;
            }
			      
	}
	
	public FireSensor findSensorByNumberOrNo(final String number,final District district)
	{
            Criteria crit =   getSession().createCriteria(FireSensor.class);
            if (district!=null  && StringUtils.isNumeric(number))
            {
        
	            crit.add(Restrictions.eq("district",district));
	            if (number.length()>1 && number.charAt(0)=='0')
	            {
	            	   crit.add(Restrictions.or(
			            		Restrictions.or(
			            				Restrictions.eq("number",number),
			            				Restrictions.eq("number",number.substring(1))),
			            		Restrictions.eq("showNo",Integer.valueOf(number))
			            		));
	            }
	            else
	            {
	            	   crit.add(Restrictions.or(
	            			    Restrictions.eq("number",number),
			            		Restrictions.eq("showNo",Integer.valueOf(number))
			            		));
	            }
            }
            else
            {
            	if (number.length()>1 && number.charAt(0)=='0')
	            {
            	  crit.add(Restrictions.or(
            				Restrictions.eq("number",number),
            				Restrictions.eq("number",number.substring(1))));
	            }
            	else
            	{
            		 crit.add(Restrictions.eq("number",number));	
            	}
            }
            List<FireSensor> rs = crit.list();
            if (rs!=null && rs.size()>0)
            {
            	FireSensor sensor = rs.get(0);
            	if (sensor.getBaseStation()!=null)
    				sensor.getBaseStation().setNumber(sensor.getBaseStation().getNumber());
            	return sensor;
            }
            else
            {
            	return null;
            }
	}
	
	public Collection<FireSensor> findFireSensors(final District district,final Date fireDate,final Date releaseTime)
	{
        Criteria crit =   getSession().createCriteria(FireSensor.class);
        crit.add(Restrictions.eq("district",district));
        if (fireDate!=null)
        {
        	crit.add(Restrictions.ge("firedate", fireDate));
        }
        if (releaseTime!=null)
        {
        	crit.add(Restrictions.ge("releaseTime", releaseTime));
        }
        return crit.list(); 
	}
	
	@SuppressWarnings("unchecked")
	public Collection<FireSensor> getFireSensorByNumber(final String number)
	{
        Criteria crit =  getSession().createCriteria(FireSensor.class);
        crit.setFetchMode("baseStation", FetchMode.JOIN);
        //如果是四位就在前面加0，如果是5位就去掉0，然后比较两者
        if(number.length() == 4){
        	crit.add(Restrictions.or(Restrictions.eq("number", number), Restrictions.eq("number", "0" + number)));
        }else if(number.length() == 5){
        	if('0' == number.charAt(0)){
        		crit.add(Restrictions.or(Restrictions.eq("number", number), Restrictions.eq("number", number.substring(1, 5))));
        	}else{
        		crit.add(Restrictions.eq("number", number));
        	}
        }else{
        	crit.add(Restrictions.eq("number", number));
        }
        return crit.list();   
	}
	
	public Collection<FireSensor> findSensors(District district)
	{
		 Criteria crit =   getSession().createCriteria(FireSensor.class);
		 crit.add(Restrictions.eq("district",district));
		 return crit.list(); 
	}
}
