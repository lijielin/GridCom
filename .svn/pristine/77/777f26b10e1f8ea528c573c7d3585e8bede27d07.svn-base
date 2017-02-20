package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 探测器自动获取信息的规则
 * 设置间隔1-N天某一点去自动读取哪个单位那个基站下的哪个探测器温度、电压数据后保存到数据库中，
 * 显示到管理中心界面上。以后还要形成这个单位的探测器温度、电压点线曲线图。
 * */
@Entity
public class SensorRule extends com.itc.domain.Entity{
	private static final long serialVersionUID = 1;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	@ManyToOne
	private FireSensor fireSensor ;
	/**SENSOR 传感终端ID 号*/
	private String sensorCode;
	/**MASTER基站ID号码*/
	private String baseCode;
	
	private Integer districtId;
	private String districtName;
	
	/**上次执行时间*/
	private Date  lastTime;
	/**下次执行时间 =上次执行时间+day的hour*/
	private Date  nextTime;
	/**隔多少天0-31*/
	private Integer day;
	/**多少点 1-24*/
	private Integer hour;
	
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
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public Date getNextTime() {
		return nextTime;
	}
	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	
	
}
