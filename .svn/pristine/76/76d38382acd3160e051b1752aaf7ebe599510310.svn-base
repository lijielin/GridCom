package com.inc.gtc.fire.dao;

import java.util.Collection;
import java.util.Date;

import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireHistory;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 报警历史dao
 */
public interface FireHistoryDao extends BaseDao<FireHistory> {
	
	/***
	 * 查找某个地区生效的报警历史
	 * @param district
	 * @return
	 */
	Collection<FireHistory> findEffectFireHistory(District district,Date startTime);
	/***
	 * 查找某个地区生效的报警历史数量
	 * @param district
	 * @return
	 */
	Integer findEffectFireHistoryCount(District district,Date startTime);
	/**
	 * 查找某个地区的报警历史
	 * @param district 地区
	 * */
	Collection<FireHistory> findValidFireHistory(District district);
	
	Integer findCrSize(String sensorCode,String cr,Date startTime,Date endTime,String d);
	
	Integer findFireHistorySize( String baseCode, String sensorCode, Date startTime, Date endTime, String d);
	/**
	 * 查找某个探测器某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	Collection<FireHistory> findFireHistory( String baseCode, String sensorCode, String seq);
	
	int findFireHistoryCount(FireHistory his,String baseCode,String sensorCode,Date startTime,Date endTime);
	
	/**
	 * 查找某个探测器在某个时间段的历史
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * */
	Collection<FireHistory> findFireHistory(String baseCode,String sensorCode,Date startTime,Date endTime);
	
	/**
	 * 查找某个探测器最后在某个时间段内某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	public Collection<FireHistory> findLastFireHistory(String baseCode,String sensorCode,String seq,Date startTime,Date endTime);
	/**
	 * 查找某个探测器在某个时间段的历史
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param d 报警信息中的d d为01 23时为测试火警,测试火警时class为00 00，正常火警时为FF FF
	 * */
	Collection<FireHistory> findFireHistory( String baseCode, String sensorCode, Date startTime, Date endTime, String d);
}
