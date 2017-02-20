package com.inc.gtc.fire.bus.msg;

import java.util.Calendar;

import com.inc.gateway.flow.cmd.CmdAttrs;

public abstract class AbstractMessage implements Message{
	
	/**
	 * 短信内容
	 */
	protected String content;
	
	protected Long createTime;
	
	public AbstractMessage()
	{
		createTime = Calendar.getInstance().getTimeInMillis();
	}
	
	public AbstractMessage(String content)
	{
		this();
		setContent(content);
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}

	
	public String getContent() {
		return content;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	
	public void buildAttr(CmdAttrs attr)
	{
		if (attr.containsAttr("content"))
		{
			this.setContent((String)attr.getAttr("content"));
		}
		if (attr.containsAttr("createTime"))
		{
			this.setCreateTime((Long)attr.getAttr("createTime"));
		}
	}
}
