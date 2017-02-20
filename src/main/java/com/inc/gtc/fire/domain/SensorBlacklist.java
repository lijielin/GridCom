package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author itc.tzj
 * @version 创建时间：2013-4-19 
 * 黑名单信息表，存储报警不准确的探测器
 */
@Entity
public class SensorBlacklist extends com.itc.domain.Entity{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private Integer sensorId;
	private String sensorNumber;
	private Integer districtId;
	private String districtName;
	private Date addTime; 

	public SensorBlacklist() {
		super();
	}

	public SensorBlacklist(FireSensor sensor) {
		super();
		this.sensorId = sensor.getId();
		this.sensorNumber = sensor.getNumber();
		if(sensor.getDistrict() != null){
			this.districtId = sensor.getDistrict().getId();
			this.districtName = sensor.getDistrict().getName();
		}
//		this.addTime = Utils.nowFullTime();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Integer getSensorId() {
		return sensorId;
	}

	public void setSensorId(Integer sensorId) {
		this.sensorId = sensorId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getSensorNumber() {
		return sensorNumber;
	}

	public void setSensorNumber(String sensorNumber) {
		this.sensorNumber = sensorNumber;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	
}
