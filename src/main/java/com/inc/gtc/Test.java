package com.inc.gtc;

import java.util.Calendar;

import com.inc.gtc.sms.JasperSmsListener;
import com.inc.gtc.sms.SmsMsgClient;
import com.inc.gtc.sms.req.SendReq;
import com.inc.yun.context.BeanFactory;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try
		{
			System.out.println(Calendar.getInstance().getTimeInMillis());
	/*		ConfigLoader loader = (ConfigLoader)BeanFactory.getInstance().getBean(ConfigLoader.class);
			loader.initialize();
			MigrateService ms = (MigrateService)BeanFactory.getInstance().getBean(MigrateService.class);
			ms.migrateDistrict(\"fairy\");*/
				/*TaskExecutor executor = (TaskExecutor)BeanFactory.getInstance().getBean(\"taskExecutor\");
				SysTask task  = new SysTask();
				task.setUnit_id(4);
				executor.executeTask(task);*/
			//System.out.println(Calendar.getInstance().getTimeInMillis());
	/*		TrackProcessor processor = (TrackProcessor)BeanFactory.getInstance().getBean(\"trackProcessor\");
			processor.initialize();	
			processor.start();*/
			//System.out.println(GeoUtils.distance(107.45074166666s667d, 29.796213333333338d,107.11345000000001d, 29.73624333333333d));
			
//			SmsClient client = new SmsClient();
//			SendReq sr = new SendReq();
//			sr.setText("智慧森林安全预警：防火测试,山西省太原市乌金山林场20100号探测器,火灾预警！请立即前往查看并回复短信确认，无火情回复：“000”，发现火情回复：“119”");
//			sr.setMobile("15123901329,13640519514");
//			client.postReq(sr);
//			SmsMsgClient client = new SmsMsgClient();
//			SendReq sr = new SendReq();
//			sr.setMobile("");
//			sr.setMessageConte("智慧森林安全预警：防火测试,山西省太原市乌金山林场20100号探测器,火灾预警！请立即前往查看并回复短信确认，无火情回复：“000”，发现火情回复：“119”");
//			sr.setUserNumber("15123901329,13640519514");
//			client.postReq(sr);
			
			JasperSmsListener jasperSmsListener = (JasperSmsListener)BeanFactory.getInstance().getBean(JasperSmsListener.class);
			jasperSmsListener.initialize();
			jasperSmsListener.start();
//			receiver.execute(null);
	/*		String content = "{\"code\":0,\"msg\":\"OK\",\"sms_reply\":[{\"id\":null,\"mobile\":\"18696521188\",\"text\":\"测试\",\"reply_time\":\"2016-11-02 14:01:20\",\"extend\":\"\",\"base_extend\":\"260793\",\"_sign\":null}]}";
			SmsResp resp = SmsResp.build(content);
			System.out.println(resp.getVal("msg"));*/
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
