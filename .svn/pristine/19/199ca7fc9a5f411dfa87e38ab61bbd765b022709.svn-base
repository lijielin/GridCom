package com.inc.gtc.fire.domain;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 探测器新增字段“测试点”，一个基站下面只能有一个探测器是测试点
 * “快速扫描”和“全网扫描”历史数据列表
 * */
@Entity
public class StationHistoryData extends com.itc.domain.Entity{
	private static final long serialVersionUID = 1;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	/**测试人*/
	private String testPerson;
	/**测试时间*/
	private Date testTime;
	private String testTimeStr;
	/**扫描类型（快速扫描0、全网扫描1）*/
	private Integer type=0;
	/**基站编号*/
	private String stationCode;
	/**所属地区*/
	private Integer districtId;
	/**回应标记（0或则1，0代表未回应，1代表已回应，默认为0）*/
	private Integer isEcho;
	/**基站回应时间*/
	private Date echoTime;
	private String echoTimeStr;
	/**网络是否畅通（0或则1，0代表不通，1代表畅通，默认为0）*/
	private Integer isOpen;
	/**基站回应内容（字符串格式，只记录，不在列表展示）*/
	private String echoContent;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTestPerson() {
		return testPerson;
	}
	public void setTestPerson(String testPerson) {
		this.testPerson = testPerson;
	}
	public Date getTestTime() {
		return testTime;
	}
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
	public String getTestTimeStr() {
		return testTimeStr;
	}
	public void setTestTimeStr(String testTimeStr) {
		this.testTimeStr = testTimeStr;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getIsEcho() {
		return isEcho;
	}
	public void setIsEcho(Integer isEcho) {
		this.isEcho = isEcho;
	}
	public Date getEchoTime() {
		return echoTime;
	}
	public void setEchoTime(Date echoTime) {
		this.echoTime = echoTime;
	}
	public String getEchoTimeStr() {
		return echoTimeStr;
	}
	public void setEchoTimeStr(String echoTimeStr) {
		this.echoTimeStr = echoTimeStr;
	}
	public Integer getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
	public String getEchoContent() {
		return echoContent;
	}
	public void setEchoContent(String echoContent) {
		this.echoContent = echoContent;
	}

}
