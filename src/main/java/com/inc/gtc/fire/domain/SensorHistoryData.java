package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 探测器的实时数据，温度，电压等
 * */
@Entity
public class SensorHistoryData extends com.itc.domain.Entity{
	private static final long serialVersionUID = 1;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	@ManyToOne
	private FireSensor fireSensor ;
	/**SENSOR 传感终端ID 号*/
	private String sensorCode;
	/**MASTER基站ID号码*/
	private String baseCode;
	private Date  addTime;
	/**yyyy-MM-dd格式串，用来查找某天的数据*/
	private String addTimeStr;
	private Integer districtId;
	private String districtName;
	/**
	 * 电压
	 */
	private String voltage;
	
	
	/**
	 * 温度
	 */
	private String temp;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public FireSensor getFireSensor() {
		return fireSensor;
	}
	public void setFireSensor(FireSensor fireSensor) {
		this.fireSensor = fireSensor;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getSensorCode() {
		return sensorCode;
	}
	public void setSensorCode(String sensorCode) {
		this.sensorCode = sensorCode;
	}
	public String getBaseCode() {
		return baseCode;
	}
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getVoltage() {
		return voltage;
	}
	public void setVoltage(String voltage) {
		this.voltage = voltage;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getAddTimeStr() {
		return addTimeStr;
	}
	public void setAddTimeStr(String addTimeStr) {
		this.addTimeStr = addTimeStr;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
