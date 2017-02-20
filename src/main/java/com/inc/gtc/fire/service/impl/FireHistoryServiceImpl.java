package com.inc.gtc.fire.service.impl;


import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.FireHistoryDao;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireHistory;
import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.service.FireHistoryService;
import com.itc.Utils;
import com.itc.service.BaseServiceImpl;
import com.itc.util.StringUtils;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 报警历史service
 */
@Service("fireHistoryService")
public class FireHistoryServiceImpl extends BaseServiceImpl<FireHistory, FireHistoryDao> implements FireHistoryService {
	@Resource(name="fireHistoryDao")
	public void setDao(FireHistoryDao dao){
		super.setDao(dao);
	}
	
	public Collection<FireHistory> findEffectFireHistory(District district,Date startTime)
	{
		return this.getDao().findEffectFireHistory(district, startTime);
	}
	public Integer findEffectFireHistoryCount(District district,Date startTime)
	{
		return getDao().findEffectFireHistoryCount(district, startTime);
	}
	/**
	 * 查找某个探测器某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	public Collection<FireHistory> findFireHistory( String baseCode, String sensorCode, String seq){
		return this.getDao().findFireHistory(baseCode, sensorCode, seq);
	}
	
	/**
	 * 查找某个探测器最后在某个时间段内某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	public Collection<FireHistory> findLastFireHistory(String baseCode,String sensorCode,String seq, Date startTime, Date endTime){
		return this.getDao().findLastFireHistory(baseCode, sensorCode, seq, startTime, endTime);
	}
	

	public int findFireHistoryCount(FireHistory his,String baseCode,String sensorCode,int second)
	{
		try {
			Date endTime = Calendar.getInstance().getTime();
			Date startTime = Utils.addTimeBySeconds(endTime, -1*second);
			return this.getDao().findFireHistoryCount(his,baseCode, sensorCode, startTime, endTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 查找某个探测器在某个时间段的历史
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param d 报警信息中的d d为01 23时为测试火警,测试火警时class为00 00，正常火警时为FF FF
	 * */
	public Collection<FireHistory> findFireHistory( String baseCode,String sensorCode,int second, String d){
		try {
			Date nowTime = Utils.nowFullTime("yyyy-MM-dd HH:mm:ss");
			Calendar cal = Calendar.getInstance();
			cal.setTime(nowTime);
			cal.add(Calendar.SECOND, -second);
		//	Date startTime = StringUtils.addDays(nowTime,Calendar.SECOND , -second);
			return this.getDao().findFireHistory(baseCode, sensorCode, cal.getTime(), nowTime,d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 查找某个地区的报警历史
	 * @param district 地区
	 * */
	public Collection<FireHistory> findValidFireHistory(District district){
		return this.getDao().findValidFireHistory(district);
	}
	
	public void updateFireHistoryUse(Collection<FireHistory>list,Integer use){
		for(FireHistory history : list){
			history.setUse(use);
			this.getDao().save(history);
		}
	}
	
	/**
	 * 查找某个地区的报警的探测器
	 * @param district 地区
	 * */
	public Collection<FireSensor> findFiredSensor(District district){
		Collection<FireHistory> list = this.getDao().findValidFireHistory(district);
		Map<String,FireSensor> map = new HashMap<String,FireSensor>();
		for(FireHistory h : list){
			map.put(h.getFireSensor().getNumber(), h.getFireSensor());
		}
		return map.values();
	}
}
