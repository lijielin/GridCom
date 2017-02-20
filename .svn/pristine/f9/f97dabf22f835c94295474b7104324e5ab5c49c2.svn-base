package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class FireHistory extends com.itc.domain.Entity{
	private static final long serialVersionUID = 1;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	@ManyToOne
	private FireSensor fireSensor ;
	/**SENSOR 传感终端ID 号*/
	private String sensorCode;
	/**MASTER基站ID号码*/
	private String baseCode;
	private String ip;
	private Date  addTime;
	private String cr;
	/**
	 * 1火情预警---指发现火焰
	 * 2盗取预警---指发现有人取走了探测器
	 * 3电池预警---指发现电池需要更换
	 * 指令代码
	 * */
	private Integer type;
	private Date releaseTime;
	private String releasePerson ;
	private String detail ;
	private String sensorDetail;
	/**序号 一个探测器可能会报警多次，每次都有一个不同的序号 数据包特征码*/
	private String seq;
	/**Data数据域type为火情预警，表示火势 盗取预警表示温度，电池预警时表示电压*/
	private String data;
	/**Class路由/配置域*/
	private String glass;
	/**报警数据中的d*/
	private String d;
	//ec,ed	可变长度测试时使用，目前还没有使用
	private String ed;
	private String ec;
	
	private Integer districtId;
	/**
	 * 风向
	 */
	private String wd;
	
	/**
	 * 风级
	 */
	private String ws;
	
	/**
	 * 相对湿度
	 */
	private String sd;
	
	
	/**
	 * 温度
	 */
	private String temp;
	
	/**
	 * 白天天气现象
	 */
	private String dayPhenomena;
	
	/**
	 * 夜间天气现象
	 */
	private String nightPhenomena;
	
	private Integer valid;
	/**是否已经处理*/
	@Column(name="isuse")
	private Integer use;
	
	public FireHistory()
	{
		this.setValid(0);
		this.setUse(0);
	}
	
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
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Date getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getReleasePerson() {
		return releasePerson;
	}
	public void setReleasePerson(String releasePerson) {
		this.releasePerson = releasePerson;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getSensorCode() {
		return sensorCode;
	}
	public void setSensorCode(String sensorCode) {
		this.sensorCode = sensorCode;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getSensorDetail() {
		return sensorDetail;
	}
	public void setSensorDetail(String sensorDetail) {
		this.sensorDetail = sensorDetail;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getWd() {
		return wd;
	}
	public void setWd(String wd) {
		this.wd = wd;
	}
	public String getWs() {
		return ws;
	}
	public void setWs(String ws) {
		this.ws = ws;
	}
	public String getSd() {
		return sd;
	}
	public void setSd(String sd) {
		this.sd = sd;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getDayPhenomena() {
		return dayPhenomena;
	}
	public void setDayPhenomena(String dayPhenomena) {
		this.dayPhenomena = dayPhenomena;
	}
	public String getNightPhenomena() {
		return nightPhenomena;
	}
	public void setNightPhenomena(String nightPhenomena) {
		this.nightPhenomena = nightPhenomena;
	}
	public String getBaseCode() {
		return baseCode;
	}
	public void setBaseCode(String baseCode) {
		this.baseCode = baseCode;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getGlass() {
		return glass;
	}
	public void setGlass(String glass) {
		this.glass = glass;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getEd() {
		return ed;
	}
	public void setEd(String ed) {
		this.ed = ed;
	}
	public String getEc() {
		return ec;
	}
	public void setEc(String ec) {
		this.ec = ec;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getCr() {
		return cr;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getValid() {
		return valid;
	}

	public Integer getUse() {
		return use;
	}

	public void setUse(Integer use) {
		this.use = use;
	}
	
	
}
