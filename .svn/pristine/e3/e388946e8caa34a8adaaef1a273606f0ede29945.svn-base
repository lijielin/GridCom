package com.inc.gtc.fire.bus;

import com.inc.gtc.fire.util.MessageUtils;

public class MessageBuilder {
	
	/**
	 * 
	 * @param cd
	 * @param addr
	 * @param code
	 * @param debug 是否调试模式
	 * @return
	 */
	public static String buildAlertMsg(String cd,String addr,String code,boolean debug)
	{
		if (cd.equals(MessageUtils.DATA_CODE_FIRE))
		{
			return buildFireMsg(addr,code,debug);
		}
		else
		{
			return buildStealMsg(addr,code);
		}
	}

	/**
	 * 火情预警
	 * @param addr
	 * @param code
	 * @return
	 */
	public static String buildFireMsg(String addr ,String code,boolean debug)
	{
		if (debug)
			return "火情预警：预警测试,"+addr+code+"号探测器,火情预警！请前往确认。若无火情回复：“000”消除预警，若需向上级报告回复：“119”。";
		else
			return "火情预警："+addr+code+"号探测器,火情预警！请前往确认。若无火情回复：“000”消除预警，若需向上级报告回复：“119”。";
	}
	
	/**
	 * 盗取预警
	 * @param addr
	 * @param code
	 * @return
	 */
	public static String buildStealMsg(String addr ,String code)
	{
		return "设备预警："+addr+code+"号探测器,存在位移现象！请前往查看处理，防止设备丢失。";
	}
}
