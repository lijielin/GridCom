package com.inc.gtc.fire.bus.msg;

import com.inc.gateway.flow.cmd.CmdAttrs;

public class ErrMessage implements Message{

	private String error;
	
	private Integer errcode;
	
	private String errmsg;
	
	private String pm;
	
	

	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	public Integer getErrcode() {
		return errcode;
	}



	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}



	public String getErrmsg() {
		return errmsg;
	}



	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}



	public String getPm() {
		return pm;
	}



	public void setPm(String pm) {
		this.pm = pm;
	}



	@Override
	public void buildAttr(CmdAttrs attr) {
		if (attr.containsAttr("error"))
			this.setError((String)attr.getAttr("error"));
		if (attr.containsAttr("errcode"))
			this.setErrcode((Integer)attr.getAttr("errcode"));
		if (attr.containsAttr("errmsg"))
			this.setErrmsg((String)attr.getAttr("errmsg"));
		if (attr.containsAttr("pm"))
			this.setPm((String)attr.getAttr("pm"));
	}

}
