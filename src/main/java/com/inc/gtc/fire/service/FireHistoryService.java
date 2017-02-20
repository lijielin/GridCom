package com.inc.gtc.fire.service;

import java.util.Collection;
import java.util.Date;

import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireHistory;
import com.inc.gtc.fire.domain.FireSensor;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 报警历史service
 */
public interface FireHistoryService extends BaseService<FireHistory> {
	
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
	/**
	 * 查找某个地区的报警的探测器
	 * @param district 地区
	 * */
	Collection<FireSensor> findFiredSensor(District district);
	/**
	 * 获取一段时间内的报警次数
	 * @param his 需要排除的历史
	 * @param baseCode
	 * @param sensorCode
	 * @param second
	 * @return
	 */
	 int findFireHistoryCount(FireHistory his,String baseCode,String sensorCode,int second);
	/**
	 * 查找某个探测器某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	Collection<FireHistory> findFireHistory( String baseCode, String sensorCode, String seq);

	/**
	 * 查找某个探测器最后在某个时间段内某个seq的历史记录
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param seq 序列号
	 * */
	public Collection<FireHistory> findLastFireHistory(String baseCode,String sensorCode,String seq, Date startTime, Date endTime);
	/**
	 * 查找某个探测器在某个时间段的历史
	 * @param baseCode 基站编号
	 * @param sensorCode 探测器编号
	 * @param d 报警信息中的d d为01 23时为测试火警,测试火警时class为00 00，正常火警时为FF FF
	 * */
	Collection<FireHistory> findFireHistory( String baseCode,String sensorCode,int second, String d);

	/**
	 * 更改火警历史的使用状态
	 * */
	void updateFireHistoryUse(Collection<FireHistory>list,Integer use);
}
