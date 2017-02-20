package com.inc.gtc.fire.service.impl;


import java.util.Collection;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.SensorRuleDao;
import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.SensorRule;
import com.inc.gtc.fire.service.BaseStationService;
import com.inc.gtc.fire.service.SensorRuleService;
import com.inc.gtc.fire.vo.SendBeanVO;
import com.itc.Utils;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-8-1 上午10:55:12
 * 探测器自动获取信息的规则service
 */
@Service("sensorRuleService")
public class SensorRuleServiceImpl extends BaseServiceImpl<SensorRule, SensorRuleDao> implements SensorRuleService {
	private final int pageSize = 20;
	private BaseStationService baseStationService;
	@Resource(name="sensorRuleDao")
	public void setDao(SensorRuleDao dao){
		super.setDao(dao);
	}
	@Resource(name="baseStationService")
	public void setBaseStationService(BaseStationService baseStationService) {
		this.baseStationService = baseStationService;
	}
	public Collection<SensorRule> findSensorRule(Date nowDate){
		Collection<SensorRule> list = this.getDao().findSensorRule(nowDate,getEndDate(nowDate));
		return list;
	}

	private Date getEndDate (Date nowDate){
		Date endDate = null;
		try {
			endDate = Utils.addTimeByMinutes(nowDate, 30);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return endDate;
	}
	@Override
	public int countSensorRule(Date nowDate) {
		return this.getDao().countSensorRule(nowDate, getEndDate(nowDate));
	}

	@Override
	public Collection<SensorRule> findSensorRule(Date nowDate,int startIndex, int endIndex) {
		Collection<SensorRule> list = this.getDao().findSensorRule(nowDate, getEndDate(nowDate),startIndex, endIndex);
		return list;
	}
	
	public void saveAllSensorRule(){
		Date nowDate = Utils.nowFullTime();
		try {
			int size = this.countSensorRule(nowDate);
			//分页处理，每页20条
			int page = (size + pageSize - 1)/pageSize;
//			System.out.println("size:" + size);
//			System.out.println("page:" + page);
//			int startIndex;
			Collection<SensorRule> list = null;
			BaseStation baseStation = null;
			for(int i = 0;i < page; i++){
//				startIndex = i * pageSize;
				list = this.findSensorRule(nowDate, 0, pageSize);
				for(SensorRule rule : list){
					if(rule.getBaseCode() != null){
						baseStation = baseStationService.findBaseStationByCode(rule.getBaseCode(),rule.getBaseCode());
					}
					//温度响应 CC60039-01
					String temp = "CC" + rule.getSensorCode()+"-01";
					SendBeanVO bean = new SendBeanVO();
					bean.setType(SendBeanVO.SENDMSG_TYPE_SMS);
					bean.setMsgType(SendBeanVO.MSG_TYPE_TEXT);
					if(baseStation.getTelephone() != null){
						bean.setTarget(baseStation.getTelephone());
					}
					bean.setContent(temp);
					//SMSMessagePool.getInstance().addSendMessage(bean);
//					System.out.println(temp);
//					this.getDao().save(rule);
				}
				Thread.sleep(60 * 1000); 
				for(SensorRule rule : list){
					if(rule.getBaseCode() != null){
						baseStation = baseStationService.findBaseStationByCode(rule.getBaseCode(),rule.getBaseCode());
					}
					//电池电压响应 CC60039-02
					String vol = "CC" + rule.getSensorCode()+"-02";
					SendBeanVO bean2 = new SendBeanVO();
					bean2.setType(SendBeanVO.SENDMSG_TYPE_SMS);
					bean2.setMsgType(SendBeanVO.MSG_TYPE_TEXT);
					if(baseStation.getTelephone() != null){
						bean2.setTarget(baseStation.getTelephone());
					}
					bean2.setContent(vol);
					//SMSMessagePool.getInstance().addSendMessage(bean2);
//					System.out.println(vol);
					rule.setLastTime(nowDate);
					rule.setNextTime(getNextTime(nowDate,rule));
//					this.getDao().save(rule);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private Date getNextTime(Date nowDate,SensorRule rule){
		Date nextTime = null;
		try {
			nextTime = Utils.addTimeByDay(nowDate, rule.getDay());
			String str = Utils.convertDateToString(nextTime, "yyyy-MM-dd");
			String hour = "";
			if(rule.getHour().toString().length() == 1){
				hour = " 0" + rule.getHour() + ":00:00";
			}else{
				hour = " " + rule.getHour() + ":00:00";
			}
			str = str + hour;
			nextTime = Utils.formatDateStr(str, "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nextTime;
	}
	
}
