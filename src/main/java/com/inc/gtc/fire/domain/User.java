package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class User extends com.itc.domain.Entity{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	private String code;
	private String name;	
	private String email;	
	private String password;		
	@ManyToOne
	private District district;
	private String telephone;
//	@ManyToOne
//	private Units units;
//	@ManyToOne
//	private Role role;
	private Date createTime;
	/**1普通用户，2管理员用户*/
	private Integer type;
	
	private Integer smsGrade;
	/**是否每天中午给该用户发送当天的天气情况*/
	private Integer isSendWeather;
	/**是否是护林员*/
	private Integer isRanger;
	/**是否组长**/
	private Integer isLeader;
	
	/**预警信息**/
	private String riskInfo;
	
	private String loginCode;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setSmsGrade(Integer smsGrade) {
		this.smsGrade = smsGrade;
	}

	public Integer getSmsGrade() {
		return smsGrade;
	}

	public Integer getIsSendWeather() {
		return isSendWeather;
	}

	public void setIsSendWeather(Integer isSendWeather) {
		this.isSendWeather = isSendWeather;
	}

	public Integer getIsRanger() {
		return isRanger;
	}

	public void setIsRanger(Integer isRanger) {
		this.isRanger = isRanger;
	}
	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
	}

	public Integer getIsLeader() {
		return isLeader;
	}

	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}

	public String getRiskInfo() {
		return riskInfo;
	}
	
	public String[] getRiskInfos()
	{
		if (riskInfo!=null && riskInfo.length()>0)
		{
			return riskInfo.split(";");
		}
		else
		{
			return null;
		}
	}

	public String getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
}
