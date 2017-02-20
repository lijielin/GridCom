package com.inc.gtc.fire.bus.buf;

import java.util.Calendar;

import com.inc.gateway.client.ExecuteCmd;

public class SendItem {

	private ExecuteCmd cmd;
	
	private Long lastSendTime;
	
	/**
	 * 重试次数
	 */
	private Integer retryCount;
	
	public SendItem(ExecuteCmd cmd)
	{
		this.cmd = cmd;
		this.lastSendTime = Calendar.getInstance().getTimeInMillis();
		this.retryCount = 0;
	}
	
	public SendItem(ExecuteCmd cmd,Long sendTime)
	{
		this(cmd);
		this.lastSendTime = sendTime;
		
		
	}

	public ExecuteCmd getCmd() {
		return cmd;
	}

	public void setCmd(ExecuteCmd cmd) {
		this.cmd = cmd;
	}

	public Long getLastSendTime() {
		return lastSendTime;
	}

	public void setLastSendTime(Long lastSendTime) {
		this.lastSendTime = lastSendTime;
	}

	public Integer getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(Integer retryCount) {
		this.retryCount = retryCount;
	}
	
	
}
