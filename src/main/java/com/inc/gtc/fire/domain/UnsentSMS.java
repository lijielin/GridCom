package com.inc.gtc.fire.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnsentSMS   extends com.itc.domain.Entity {
	private static final long serialVersionUID = 1;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String content;
	private String phones;
	private Integer msgType;
	public static final int MSG_TYPE_TEXT = 1;
	public static final int MSG_TYPE_PDU = 2;
	public UnsentSMS() {
		this.msgType = MSG_TYPE_TEXT;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public Integer getMsgType() {
		return msgType;
	}
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}


}
