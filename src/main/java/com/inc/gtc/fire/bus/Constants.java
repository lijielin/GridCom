package com.inc.gtc.fire.bus;

/**
 * 常量定义
 * @author courser
 *
 */
public class Constants {
	public static final String RECV_QUEUE_NAME="com.inc.firequeue";
	public static final String SEND_QUEUE_NAME="com.inc.gateway.queue";
	public static final String RECV_GM_TASKQUEUE_NAME = "com.inc.gm.task";
	
	public static final Integer yes = 1;
	public static final Integer no = 0;
	
	/**着火的探测器个数据 ，大于些数目时为火险*/
	public static final Integer fire_sensor_num = 2;
	
	/**火情*/
	public static final Integer type_fire_behavior = 1;
	/**火险*/
	public static final Integer type_fire_danger = 2;
	/**火灾*/
	public static final Integer type_fire_conflagrat = 3;
	/**火险处置步骤*/
	public static final String disposal_step_key = "treesensor_disposal_step";

	
	/**火情预警 firewarn*/ 
	public static final String firewarn = "firewarn"; 
	/**发送预警短信 warnsms  */ 
	public static final String warnsms = "warnsms"; 
	/**消除预警 clearwarn  */ 
	public static final String clearwarn = "clearwarn"; 
	/**火情确认 fireconfirm  */ 
	public static final String fireconfirm = "fireconfirm"; 
	/**发送火险预警 risksms  */ 
	public static final String risksms = "risksms"; 
	/**指挥记录 command */ 
	public static final String command = "command"; 
	/**启动火险预案 startplan */ 
	public static final String startplan = "startplan"; 
	
	/**火险提示信息*/
	public static final String tips_key = "treesensor_tips";
	
	/** 1.探测器报警*/ 
	public static final String tip_firewarn = "firewarn"; 
	/** 2.平台预警（短信发出）*/ 
	public static final String tip_warnsms = "warnsms"; 
	/** 3.护林员现场确认（短信回复）*/
	public static final String tip_fireconfirm = "fireconfirm"; 
	/** 4.消警或转火险预案*/ 
	public static final String tip_clear_or_risksms = "clear_or_risksms"; 
	/** 1.平台报警（短信发出）*/ 
	public static final String tip_risksms = "risksms"; 
	/** 2.启动X级预案响应*/ 
	public static final String tip_startplan = "startplan"; 
}
