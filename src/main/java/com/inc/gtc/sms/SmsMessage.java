package com.inc.gtc.sms;

/**
 * 从短信网关接收的短信信息
 * @author atian
 *
 */
public class SmsMessage {

	private String mobile;
	
	private String text;
	
	private String replyTime;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}
	
	
}
