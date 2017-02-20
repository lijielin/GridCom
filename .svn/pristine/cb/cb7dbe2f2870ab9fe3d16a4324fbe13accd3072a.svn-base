package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Sensor extends com.itc.domain.Entity{

	private static final long serialVersionUID = 1L;
	//编号
	private String number;
	//型号
	private String model;	
	//温度
	private String temperatures;
	//区号
	@JoinColumn(name="district")
	@ManyToOne
	private District district;

	//责任人
	private String dutyer;	
	//管理人
	private String manager;	
	//基站号
	private String basestationnumber;
	//管理单位
	private String manageunit;
	
	private String telephone;	
	private String address;
	/**经度*/
	private double lng;
	/**纬度*/
	private double lat;		
	private String img;	
	
	private String video;
	
	private String remark;
	private Date createTime;
	/**
	 * 1火情预警---指发现火焰
	 * 2盗取预警---指发现有人取走了探测器
	 * 3电池预警---指发现电池需要更换
	 * */
	private Integer type;
	private Integer state;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private BaseStation baseStation;
	
	public BaseStation getBaseStation() {
		return baseStation;
	}
	public void setBaseStation(BaseStation baseStation) {
		this.baseStation = baseStation;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(String temperatures) {
		this.temperatures = temperatures;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public String getDutyer() {
		return dutyer;
	}
	public void setDutyer(String dutyer) {
		this.dutyer = dutyer;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getBasestationnumber() {
		return basestationnumber;
	}
	public void setBasestationnumber(String basestationnumber) {
		this.basestationnumber = basestationnumber;
	}
	public String getManageunit() {
		return manageunit;
	}
	public void setManageunit(String manageunit) {
		this.manageunit = manageunit;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	
}
