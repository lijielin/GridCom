package com.inc.gtc.fire.bus.msg;

import com.inc.gateway.flow.cmd.CmdAttrs;

public class SuccessMessage implements Message{
	
	private String successful;
	
	private Long timestamp;
	
	private String pm;
	
	
	
	public String getSuccessful() {
		return successful;
	}



	public void setSuccessful(String successful) {
		this.successful = successful;
	}



	public Long getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}



	public String getPm() {
		return pm;
	}



	public void setPm(String pm) {
		this.pm = pm;
	}



	@Override
	public void buildAttr(CmdAttrs attr) {
		if (attr.containsAttr("successful"))
			this.setSuccessful((String)attr.getAttr("successful"));
		if (attr.containsAttr("timestamp"))
			this.setTimestamp(Long.parseLong(attr.getAttr("timestamp").toString()));
		if (attr.containsAttr("pm"))
			this.setPm((String)attr.getAttr("pm"));
	}
}
