package com.inc.gtc.fire.bus.msg;

/**
 * 发送消息
 * @author courser
 *
 */
public class SendMessage  extends AbstractMessage{

	private String to;
	
	public SendMessage()
	{
		
	}
	
	public SendMessage(String to,String content)
	{
		super(content);
		this.to = to;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	
}
