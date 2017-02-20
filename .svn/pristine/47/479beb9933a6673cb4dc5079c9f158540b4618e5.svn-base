package com.inc.gtc.fire.vo;


/**
 * 发送短信的一些信息vo
 * @author itc.tzj
 * @version 创建时间：2011-10-13 上午10:21:19 
 */
public class SendBeanVO {
	
	public static final int SENDMSG_TYPE_FIRE = 1;//fire 
	public static final int SENDMSG_TYPE_SMS = 2;
	public static final int MSG_TYPE_TEXT = 1;
	public static final int MSG_TYPE_PDU = 2;
	private String cd;
	private Integer districtId;
//	private String area;
//	private String number;
//	private String part;
	private Integer stationId;
	private Integer sensorId;
	
	//重发次数
	private int repeatCount;
	
	private int type;
	//多个手机号用|分隔
	private String target;//目的
	
	private String content;
	
	private Integer msgType;
	
	/**已经确认过的着火历史信息**/
	private Integer effectFireHis;
	
	private String message;
	
	public SendBeanVO() {
		super();
		this.setType(SENDMSG_TYPE_FIRE);
		repeatCount=0;
		this.setMsgType(MSG_TYPE_PDU);
	}
	
	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public SendBeanVO(String cd, Integer districtId,Integer stationId, Integer sensorId) {
		this.setType(SENDMSG_TYPE_FIRE);
		repeatCount=0;
		this.setMsgType(MSG_TYPE_PDU);
		this.cd = cd;
		this.districtId = districtId;
//		this.area = area;
//		this.number = number;
//		this.part = part;
		this.stationId = stationId;
		this.sensorId = sensorId;
	}
	
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public Integer getSensorId() {
		return sensorId;
	}
	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getTarget() {
		return target;
	}
	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
	public int getRepeatCount() {
		return repeatCount;
	}



	public void setEffectFireHis(Integer effectFireHis) {
		this.effectFireHis = effectFireHis;
	}

	public Integer getEffectFireHis() {
		return effectFireHis;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
