package com.inc.gtc.fire.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author itc.tzj
 * @version 创建时间：2011-8-2 上午09:57:49 
 * 模式与预警有效周期设置
 * 1正式运行模式，0安装调试模式
 * 有效周期用几分钟报警多少次表示有效的报警
 */
@Entity
public class BaseMode extends com.itc.domain.Entity {

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	/**基站编号*/
	private String stationNumber;
	/**1正式运行模式，0安装调试模式*/
	private Integer mode;
	/**多少秒*/
	private Integer minute;
	/**多少次*/
	private Integer bout;
	public BaseMode(){
		mode = 0;
		minute = 200;
		bout = 3;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public Integer getBout() {
		return bout;
	}
	public void setBout(Integer bout) {
		this.bout = bout;
	}
	public String getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}
	
}
