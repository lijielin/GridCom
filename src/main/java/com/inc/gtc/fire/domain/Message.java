package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message  extends com.itc.domain.Entity {
	private static final long serialVersionUID = 4834201798671423740L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
//	private UserInfo userInfo;
	private String content;
	private String phones;
	private Date sendTime;
	/**是否定时发送0即时，1定时*/
	private Integer isSheduled;
	private Integer districtId;
	public Message() {
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
//	public UserInfo getUserInfo() {
//		return userInfo;
//	}
//	public void setUserInfo(UserInfo userInfo) {
//		this.userInfo = userInfo;
//	}
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
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Integer getIsSheduled() {
		return isSheduled;
	}
	public void setIsSheduled(Integer isSheduled) {
		this.isSheduled = isSheduled;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	


}
