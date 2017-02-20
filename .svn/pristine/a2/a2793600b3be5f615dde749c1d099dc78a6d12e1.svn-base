package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FireSensor extends Sensor{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	//防火区
	private String area;
	//防火段
	private String part;
	private String firedate;
	
	private Integer isSendMsg;
	
	private Date releaseTime;
	
	private Integer showNo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getFiredate() {
		return firedate;
	}

	public void setFiredate(String firedate) {
		this.firedate = firedate;
	}

	public Integer getIsSendMsg() {
		return isSendMsg;
	}

	public void setIsSendMsg(Integer isSendMsg) {
		this.isSendMsg = isSendMsg;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getArea() {
		return area == null ?"":area;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getPart() {
		return part == null ?"":part;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setShowNo(Integer showNo) {
		this.showNo = showNo;
	}

	public Integer getShowNo() {
		return showNo;
	}

	public String toFireString() {
		StringBuffer sb = new StringBuffer();
		if(this.getDistrict() != null){
			sb.append(this.getDistrict().getName());
		}
		sb.append(this.getArea());
		sb.append(this.getPart());
		sb.append(this.getNumber()).append("号探测器  ");
		if(this.getShowNo() != null){
			sb.append("显示编号:").append(this.getShowNo());
		}
		sb.append("火情预警！");
		return sb.toString();
	}
	
}
