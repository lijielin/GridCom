package com.inc.gtc.fire.bus.process;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.Constants;
import com.inc.gtc.fire.bus.SendMessageService;
import com.inc.gtc.fire.bus.msg.Message;
import com.inc.gtc.fire.bus.msg.RecvMessage;
import com.inc.gtc.fire.domain.BaseMode;
import com.inc.gtc.fire.domain.BaseStation;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireHandleFlow;
import com.inc.gtc.fire.domain.FireHistory;
import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.domain.PhoneFeeHistory;
import com.inc.gtc.fire.domain.SensorHistoryData;
import com.inc.gtc.fire.domain.User;
import com.inc.gtc.fire.err.ProcessException;
import com.inc.gtc.fire.service.BaseModeService;
import com.inc.gtc.fire.service.BaseStationService;
import com.inc.gtc.fire.service.DisposalStepService;
import com.inc.gtc.fire.service.FireHandleFlowService;
import com.inc.gtc.fire.service.FireHistoryService;
import com.inc.gtc.fire.service.FireSensorService;
import com.inc.gtc.fire.service.PhoneFeeHistoryService;
import com.inc.gtc.fire.service.SensorHistoryDataService;
import com.inc.gtc.fire.service.TipsService;
import com.inc.gtc.fire.service.UserService;
import com.inc.gtc.fire.util.MessageUtils;
import com.inc.gtc.fire.util.StringUtils;
import com.inc.gtc.fire.vo.FireDataVO;
import com.inc.gtc.fire.vo.SendBeanVO;
import com.inc.yun.core.engin.Boot;
import com.itc.Utils;

/**
 * 火情处理
 * @author courser
 *
 */
@Component("fireProcessor")
@Boot(3)
public class FireProcessor  implements Processor{
	
	private static Logger logger = Logger.getLogger(FireProcessor.class);
	
	private static 	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private PhoneFeeHistoryService phoneFeeService;
	
	@Autowired
	private BaseStationService baseStationService;
	
	@Autowired
	private FireSensorService fireSensorService;
	
	@Autowired
	private SensorHistoryDataService sensorHistoryDataService;
	
	@Autowired
	private FireHistoryService fireHistoryService;
	
	@Autowired
	private BaseModeService baseModeService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DisposalStepService disposalStepService;
	
	@Autowired
	private TipsService tipsService;
	
	@Autowired
	private FireHandleFlowService fireHandleFlowService;
	
	@Autowired
	private SendMessageService sendMessageService;

	@Override
	public boolean handle(Message arg) {
		if (!(arg instanceof RecvMessage))
			return false;
		RecvMessage  msg = (RecvMessage)arg;
		Map<String, String> map = MessageUtils.parseMessage(msg.getContent());
		if(map.size() == 0){
			if (msg.getContent()!=null)
			{
				/**
				 *  话费查询短信
				 */
				String smsContent = StringUtils.decodeUnicode(msg.getContent());
				msg.setContent(smsContent);
				if(StringUtils.isBalanceMatcher(smsContent)){
					PhoneFeeHistory entity = new PhoneFeeHistory();
					entity.setCreateTime(Utils.nowFullTime());
					entity.setTelephone(msg.getFrom());
					entity.setFee(StringUtils.findBalanceMatcher(smsContent));
					phoneFeeService.save(entity);
				}
			}
			logger.error("短信格式出错:" + msg.getContent());
			throw new ProcessException("短信格式出错");
		}
		String m = map.get("M");
		String s = map.get("S").trim();
		String cd = map.get("CD");
		String d = map.get("D");
		String cr = map.get("CR");
		String glass = map.get("CLASS");
		String ec = map.get("EC");
		String ed = map.get("ED");

		FireDataVO fireDataVO = new FireDataVO(m, s, cd, d, cr,
				glass, ec, ed,null,msg.getContent());
		String stationNumber = MessageUtils.getLastChar(fireDataVO.getM(),4);
		BaseStation station = baseStationService.findBaseStationByCode(fireDataVO.getM(),stationNumber);
		if(station == null){
			logger.error("不存在的基站");
			throw new RuntimeException("不存在的基站");
		}
		
		FireSensor fireSensor = fireSensorService.findSensorByNumberOrNo(fireDataVO.getS(), (station!=null)?station.getDistrict():null);
		if(fireSensor == null){
			logger.error("不存在的探测器");
			throw new RuntimeException("不存在的探测器");
		}else{
			try {
				Calendar createTime = Calendar.getInstance();
				createTime.setTimeInMillis(msg.getCreateTime());
				fireSensor.setFiredate(Utils.convertDateToString(createTime.getTime(), "yyyy-MM-dd HH:mm:ss"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(MessageUtils.DATA_CODE_REPLY.equals(cd)){
			logger.info("reply");
			parseReply(fireDataVO,fireSensor,station);
		}else{
			logger.info("fire:");
			parseFire(stationNumber,fireDataVO,fireSensor,station);
		}
		return false;
	}
	
	
	/**
	 * 解析回复并保存
	 * */
	private void parseReply(FireDataVO fireDataVO,FireSensor fireSensor,BaseStation station){
		String dateStr = "";
		try {
			dateStr = Utils.convertDateToString(Utils.nowFullTime(),"yyyy-MM-dd");
		} catch (Exception e) {
			e.printStackTrace();
		}
		SensorHistoryData sensorHistoryData = null;
		sensorHistoryData = sensorHistoryDataService.findSensorHistoryData(fireDataVO.getS(), dateStr);
		if(sensorHistoryData == null){
			sensorHistoryData = new SensorHistoryData();
		}
		String[] arr  = fireDataVO.getD().split(" ");
		double temp = 0.0;
		double vol = 0.0;
		if(MessageUtils.DATA_CODE_TEMP.equals(arr[0])){
			temp = MessageUtils.parseTheftTemperature(fireDataVO.getD());
			sensorHistoryData.setTemp(String.valueOf(temp));
		}else if(MessageUtils.DATA_CODE_VOLTAGE.equals(arr[0])){
			vol = MessageUtils.parseVoltage(fireDataVO.getD());
			sensorHistoryData.setVoltage(String.valueOf(vol));
		}
		
		sensorHistoryData.setAddTime(Utils.nowFullTime());
		sensorHistoryData.setAddTimeStr(dateStr);
		sensorHistoryData.setBaseCode(station.getNumber());
		sensorHistoryData.setSensorCode(fireDataVO.getS());
		if(station.getDistrict() != null){
			sensorHistoryData.setDistrictId(station.getDistrict().getId());
			sensorHistoryData.setDistrictName(station.getDistrict().getName());
		}
		sensorHistoryData.setFireSensor(fireSensor);
		sensorHistoryDataService.save(sensorHistoryData);
	}

	/**
	 * 解析报警信息
	 * @param stationNumber 基站编号的最后四位
	 * @param fireDataVO 报警信息vo
	 * @param fireSensor 探测器
	 * @param station 基站
	 * 
	 * */
	private void parseFire(String stationNumber,FireDataVO fireDataVO,FireSensor fireSensor,BaseStation station){
		try{
			//测试类只写历史
			if(MessageUtils.DATA_CODE_E0.equals(fireDataVO.getCd()) || MessageUtils.DATA_CODE_E1.equals(fireDataVO.getCd()) || MessageUtils.DATA_CODE_MESSAGE_MAP.containsKey(fireDataVO.getCd()))
			{
				//判断
				String tmp = "";
				if(fireSensor.getBaseStation() != null){
					tmp = fireSensor.getBaseStation().getNumber();
					tmp = MessageUtils.getLastChar(tmp,4);
				}
//				if(!stationNumber.equals(tmp)){
//					log.error("探测器所属基站和报警信息的基站编号不一致" + fireSensor.getBaseStation() + "" + stationNumber + "" + tmp);
//					throw new RuntimeException("探测器所属基站和报警信息的基站编号不一致");
//				}
//				msg.setDistrict(station.getDistrict().getId());
				if(station != null && fireSensor != null && fireDataVO != null  ){
					Integer cr = 0 ;
					try
					{
						cr = Integer.parseInt(fireDataVO.getCr());
					}
					catch (Exception e)
					{
						e.printStackTrace();
						cr =0;
					}
					FireHistory fireHistory  = null;
					if (cr<300)
					{
						//报警历史保存
						fireHistory = saveFireHistory(station, fireSensor, fireDataVO);
					
						if(fireHistory == null ){
							String str = "错误的火警报警，火警历史记录中存在" + station.getNumber() + "--" + fireSensor.getNumber() + "--" + fireDataVO.getCr().toString();
							logger.error(str);
							throw new ProcessException(str);
						}
					}
					
					if(MessageUtils.DATA_CODE_FIRE.equals(fireDataVO.getCd().toString())){
						//存在此报警码则通知
						//正式运行模式，判断是否为误报
						//正式运行模式是：配置多少秒钟来几次，才不是误报
						//查找当前时间1分钟内的报警记录，如果有则忽略
						//报警信息中的d为01 23,class为00 00时为测试火警,直接修改标示并发送短信,
						//class为FF FF正常火警,正常火警要进行运行模式和历史记录的判断再决定是否报警
						//，其他的忽略
						int alertNum = fireHistoryService.findFireHistoryCount(fireHistory,station.getNumber(), fireSensor.getNumber(), 50);
						if(("01 23".equals(fireDataVO.getD()) && "00 00".equals(fireDataVO.getGlass()))){
							sendModifyMessage(fireSensor,station, fireDataVO,fireHistory);
						}else if(alertNum<1){
							modifySensor(fireSensor,station,fireDataVO,fireHistory);
						}else
						{
							logger.info("Duplicate message,skiped");
						}
					}else{
						logger.info("send Message");
						sendModifyMessage(fireSensor,station, fireDataVO,fireHistory);
					}
				}
				else
				{
					logger.info("unknow error2 ,skiped");
				}
			}
			else
			{
				logger.info("unknow error ,skiped");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("修改探测器状态时错误",e);
			throw new ProcessException("修改探测器状态时错误"+e.getMessage());
		}
	}
	
	
	/**
	 * 保存火警历史
	 * */
	private FireHistory saveFireHistory(BaseStation station,FireSensor fireSensor,FireDataVO fireDataVO) throws Exception{
		Date startTime = Utils.addTimeByMinutes(Calendar.getInstance().getTime(), -60*24*2);
		logger.info("s:"+fireDataVO.getS()+"   cr:"+fireDataVO.getCr()+"  "+format.format(startTime));
		/** 一小时内不能有重复的报警**/
		Collection<FireHistory> list = fireHistoryService.findLastFireHistory(station.getNumber(), fireDataVO.getS(), fireDataVO.getCr(),startTime,null);
		if((list == null || list.size() == 0)  || fireDataVO.getCr().equals("000")){
			FireHistory fireHistory = new FireHistory();
			if(MessageUtils.DATA_CODE_E0.equals(fireDataVO.getCd())){
				String detail = fireSensor.getNumber() + "号探测器-" + MessageUtils.parseDetailE0(fireDataVO.getD(),fireDataVO.getGlass());
				fireHistory.setSensorDetail(detail);
			}
			fireHistory.setDistrictId(fireSensor.getDistrict().getId());
			fireHistory.setFireSensor(fireSensor);
			fireHistory.setSensorCode(fireDataVO.getS());
//			fireHistory.setSensorDetail(fireDataVO.getD());
			fireHistory.setIp(fireDataVO.getIp());
			fireHistory.setData(fireDataVO.getContent());
			fireHistory.setSeq(fireDataVO.getCr());
			fireHistory.setType(Integer.parseInt(fireDataVO.getCd()));
			fireHistory.setIp(fireDataVO.getIp());
			fireHistory.setGlass(fireDataVO.getGlass());
			fireHistory.setBaseCode(station.getNumber());
			fireHistory.setEc(fireDataVO.getEc());
			fireHistory.setEd(fireDataVO.getEd());
			fireHistory.setD(fireDataVO.getD());
			fireHistory.setCr(fireDataVO.getCr());
			fireHistory.setAddTime(StringUtils.getCurDate());
			fireHistoryService.save(fireHistory);
			logger.info("保存火警历史");
			return fireHistory;
		}
		return null;

	}
	
	/**
	 * 根据历史信息判断是否误报,如果不是误报则更改探测器状态
	 * */
	private void modifySensor(FireSensor fireSensor,BaseStation station,FireDataVO fireDataVO,FireHistory fireHistory){
		BaseMode baseMode = baseModeService.findBaseMode(station.getNumber());
		if(baseMode == null){
			baseMode = new BaseMode();
			baseMode.setStationNumber(station.getNumber());
			baseModeService.save(baseMode);
		}
		try
		{
				if(baseMode.getMode() == 1){
					Collection<FireHistory> list = fireHistoryService.findFireHistory(station.getNumber(), fireSensor.getNumber(), baseMode.getMinute(),fireDataVO.getD());
					if((list != null && list.size() >= baseMode.getBout())){
						sendModifyMessage(fireSensor,station, fireDataVO,fireHistory);
					}
				}else{
					sendModifyMessage(fireSensor,station, fireDataVO,fireHistory);
				}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	private void sendModifyMessage(FireSensor fireSensor,BaseStation station,FireDataVO fireDataVO,FireHistory fireHistory) throws Exception{

		District district = station.getDistrict();
		fireSensor.setState(Integer.parseInt(fireDataVO.getCd()));
	
		Collection<FireSensor> fireSensors = this.fireSensorService.getSensorByStatus(district, Integer.valueOf(MessageUtils.DATA_CODE_FIRE));
		Collection<FireHistory> historys = fireHistoryService.findEffectFireHistory(district,Utils.addTimeByMinutes(Calendar.getInstance().getTime(), -120));

		/**查询两小时内是否有确认过的预警短信**/
		SendBeanVO bean = new SendBeanVO(fireDataVO.getCd(), station.getDistrict().getId(), station.getId(), fireSensor.getId());	
		bean.setEffectFireHis(historys.size());
		//火警历史设置为有效
		if (fireHistory!=null)
		{
			if (bean.getEffectFireHis()<1  || fireSensors.size()<1)
			{
				fireHistory.setUse(0);
			}
			else
			{
				fireHistory.setUse(1);
			}
			fireHistory.setValid(1);
			this.fireHistoryService.save(fireHistory);
		}
		fireSensor.setState(Integer.parseInt(fireDataVO.getCd()));
//		sendMessage( fireSensor, station, fireDataVO);
//		fireSensor.setType(Integer.parseInt(fireDataVO.getCd()));
		logger.info("baseMode.getMode() == 0时探测器标志：" + fireSensor.getState());
		fireSensorService.update(fireSensor);
		logger.info("baseMode.getMode() == 0时探测器标志：" + fireSensor.getState());
		//HelpSoftMessagePool.getInstance().addMessage(fireSensor.getNumber() + "," + fireSensor.getState() + ";");
		List<String> usernameList = new ArrayList<String>();
		List<String> phoneList = new ArrayList<String>();
		//写火情流程
		
			FireHandleFlow flow = new FireHandleFlow();
			flow.setAddTime(Utils.nowFullTime());
			flow.addFireSensor(fireSensor);
	//		flow.setType(FireHandleFlowPool.getInstance().getHandleType(fireSensor.getDistrict().getId()));
			flow.setStep(disposalStepService.getStepByCodeFromCache(Constants.firewarn));
			flow.setTips(tipsService.getTipByCodeFromCache(Constants.tip_firewarn));
			flow.setDistrict(fireSensor.getDistrict());
			flow.setContent(fireSensor.toFireString());
			fireHandleFlowService.save(flow);
			Collection<User> listUser = userService.getDistrictRangerUsers(district);
			for (User user : listUser) {
				if (user.getSmsGrade()!=null && user.getSmsGrade()>0)
				{
					phoneList.add(user.getTelephone());
					usernameList.add(user.getName());
				}
			}
		
			/**如果是第一次着火**/
		if (bean.getEffectFireHis()<1  || fireSensors.size()<1)
		{
			bean.setEffectFireHis(0);
			/**发送需要确认的预警短信**/
			saveWarHandleFlow(usernameList,station.getDistrict(),fireSensor);
			//sendMessagePool.addSendMessage(bean);
			sendMessageService.sendMessage(bean);
		
		}else
		{
			sendMessageService.sendMessage(bean);
			//sendMessagePool.addSendMessage(bean);
			SendBeanVO s = new SendBeanVO();
			s.setType(SendBeanVO.SENDMSG_TYPE_SMS);
			s.setTarget(StringUtils.arrayListToString(phoneList, "|"));
			s.setContent("智慧森林预警平台："+fireSensor.getNumber()+"探测器发现火情，请组织扑救！请各组组长回复51通知到位情况！");
			sendMessageService.sendMessage(s);
			//SMSMessagePool.getInstance().addSendMessage(s);	
			//写火情流程--发送火险预警信息
			StringBuffer sb = new StringBuffer();
			sb.append("平台向");
			sb.append(StringUtils.arrayListToString(usernameList, ","));
			sb.append("发送火险预警信息！！");
			FireHandleFlow flow2 = new FireHandleFlow();
			flow2.setAddTime(Utils.nowFullTime());
			flow2.setDistrict(district);
			flow2.addFireSensor(fireSensor);
			flow2.setStep(disposalStepService.getStepByCodeFromCache(Constants.tip_fireconfirm));
			flow2.setTips(tipsService.getTipByCodeFromCache(Constants.fireconfirm));
			flow2.setContent(sb.toString());
			fireHandleFlowService.save(flow2);
			
		}
	}
	
	private void saveWarHandleFlow(List<String> usernameList,District district,FireSensor fireSensor){
		
		StringBuffer sb = new StringBuffer();
		sb.append("平台向");
		sb.append(StringUtils.arrayListToString(usernameList, "、"));
		sb.append("的手机发送预警信息，等待确认！");
		//写火情流程
		FireHandleFlow flow = new FireHandleFlow();
		flow.setAddTime(Utils.nowFullTime());
//		flow.setType(FireHandleFlowPool.getInstance().getHandleType(district.getId()));
		flow.setDistrict(district);
		flow.addFireSensor(fireSensor);
		flow.setStep(disposalStepService.getStepByCodeFromCache(Constants.warnsms));
		flow.setTips(tipsService.getTipByCodeFromCache(Constants.tip_warnsms));
		flow.setContent(sb.toString());
		fireHandleFlowService.save(flow);
	}
}
