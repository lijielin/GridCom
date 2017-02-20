package com.inc.gtc.fire.bus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gateway.client.ExecuteCmd;
import com.inc.gtc.fire.bus.buf.SendBuffer;
import com.inc.gtc.fire.bus.buf.SendItem;
import com.inc.gtc.fire.bus.msg.SendMessage;
import com.inc.gtc.fire.domain.BaseMode;
import com.inc.gtc.fire.domain.District;
import com.inc.gtc.fire.domain.FireSensor;
import com.inc.gtc.fire.domain.User;
import com.inc.gtc.fire.service.BaseModeService;
import com.inc.gtc.fire.service.DistrictService;
import com.inc.gtc.fire.service.FireSensorService;
import com.inc.gtc.fire.service.MessageService;
import com.inc.gtc.fire.service.UserService;
import com.inc.gtc.fire.util.GsonUtils;
import com.inc.gtc.fire.util.StringUtils;
import com.inc.gtc.fire.vo.SendBeanVO;
import com.inc.gtc.sms.SmsClient;
import com.inc.gtc.sms.req.SendReq;
import com.inc.gtc.sms.resp.SmsResp;
import com.inc.yun.bridge.DeliveryTarget;

/**
 *  短信网关发送
 * @author atian
 *
 */
@Component("gatewaySendService")
public class GatewaySendService implements SendMessageService {

	private static final Logger logger = Logger.getLogger(JmsSendService.class);
	
	private static String target = "smsmobile_1";
	
	private Integer pm;
	
	
	
	@Autowired
	private FireSensorService fireSensorService;
	
	@Autowired
	private BaseModeService baseModeService;
	
	@Autowired
	private DistrictService districtService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SendBuffer<SendItem> buf;
	
	public GatewaySendService()
	{
		pm=0;
	}
	
	@Override
	public void sendMessage(SendBeanVO bean) {
		try
		{
			if (bean.getType()==SendBeanVO.SENDMSG_TYPE_SMS)
			{
				ExecuteCmd cmd = new ExecuteCmd();
				cmd.setDeviceId(target);
				cmd.setPm(String.valueOf(getPm()));
				cmd.setP(GsonUtils.getJsonFromObj(new SendMessage(bean.getTarget(),bean.getContent())));
				buf.add(new SendItem(cmd));
				sendSms(bean.getTarget(),bean.getContent());
				//this.send(new SimpleDeliveryTarget(Constants.SEND_QUEUE_NAME),cmd);
			}
			else
			{
				boolean debug = false;
				String cd = bean.getCd();
				
				District district = null;
				if (bean.getDistrictId()!=null)
				 district = districtService.get(bean.getDistrictId());
				
				FireSensor fireSensor = this.fireSensorService.get(bean.getSensorId()); 
				if (district==null)
					district = fireSensor.getDistrict();
				if(fireSensor.getBaseStation() != null){
					BaseMode baseMode = baseModeService.findBaseMode(fireSensor.getBaseStation().getNumber());
				
					if(baseMode==null || baseMode.getMode()==null || baseMode.getMode().intValue() == 0){
						//安装调试模式
						//message = message + "防火测试,";
						debug = true;
					}
				}
	//				if (district != null) {
	//					message = message + district.getName() + "地方,";
	//				}
		/*	2016-11-4	
		 * message = message + fireSensor.getArea() + fireSensor.getPart()
						+ ((fireSensor.getShowNo()!=null && fireSensor.getShowNo()>0)?fireSensor.getShowNo():fireSensor.getNumber()) + "号探测器,";
				if (MessageUtils.DATA_CODE_E0.equals(cd)) {
					message = message + MessageUtils.DATA_NAME_E0;
				} else if (MessageUtils.DATA_CODE_E1.equals(cd)) {
					message = message + MessageUtils.DATA_NAME_E1;
				} else {
					System.out.println("火警类别:"+MessageUtils.DATA_CODE_MESSAGE_MAP.get(cd));
					if (bean.getEffectFireHis()<1)
						message = message + MessageUtils.DATA_CODE_MESSAGE_MAP.get(cd)+"请立即前往查看并回复短信确认，无火情回复：“000”，发现火情回复：“119”";
					else
						message = message + MessageUtils.DATA_CODE_MESSAGE_MAP.get(cd);
				}
			*/
			
				// 给相关人员发送短信
				List<String> phoneList = new ArrayList<String>();
				List<String> usernameList = new ArrayList<String>();
				Collection<User> listUser = userService.getDistrictRangerUsers(district);
				for (User user : listUser) {
					if (user.getSmsGrade()!=null && user.getSmsGrade()>0)
					{
						System.out.println("receiver's phone:"+user.getTelephone());
						phoneList.add(user.getTelephone());
						usernameList.add(user.getName());
					}
				}
				// phoneList.add("10086");
				// 更新为已发送
	//			fireSensor.setState(Integer.parseInt(cd));
	//			fireSensor.setIsSendMsg(1);
	//			log.info("发送短信时探测器标志：" + fireSensor.getState());
	//			fireSensorService.update(fireSensor);
				logger.info("发送预警短信,探测器编号为：" + fireSensor.getNumber());
				// 保存发送历史
				String msg = MessageBuilder.buildAlertMsg(cd, fireSensor.getArea() + fireSensor.getPart(), ((fireSensor.getShowNo()!=null && fireSensor.getShowNo()>0)?fireSensor.getShowNo().toString():fireSensor.getNumber()), debug);
				com.inc.gtc.fire.domain.Message message2 = new com.inc.gtc.fire.domain.Message();
				message2.setContent(msg);
				message2.setIsSheduled(0);
				message2.setDistrictId(district.getId());
				message2.setPhones(StringUtils.arrayListToString(phoneList, ","));
				message2.setSendTime(StringUtils.getCurDate());
				messageService.save(message2);
				sendSms(message2.getPhones(),msg);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	private void sendSms(String phone,String text)
	{
		System.out.println("send sms:"+text);
		SmsClient client = new SmsClient();
		SendReq sr = new SendReq();
		sr.setText(text);
		sr.setMobile(phone);
		SmsResp resp = client.postReq(sr);
		try
		{
			if (resp.getVal("result")!=null)
			{
				logger.info("success send smscount:"+((Map)resp.getVal("result")).get("count"));
			}
		}
		catch (Exception e)
		{
			logger.error("get sms resp error");
		}
		
	}
	
	
	private synchronized int getPm()
	{
		if (pm>Short.MAX_VALUE)
		{
			pm=1;
			return pm;
		}
		else
		{
			return ++pm;
		}
	}

	@Override
	public void send(DeliveryTarget target, Object obj) {
		// TODO Auto-generated method stub
		
	}
}
