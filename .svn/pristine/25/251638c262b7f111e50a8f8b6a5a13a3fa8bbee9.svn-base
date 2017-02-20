package com.inc.gtc.fire.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class District extends com.itc.domain.Entity{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String code;
	/**纬度*/
	private Double lat;
	/**经度*/
	private Double lng;
	private Double area;
	private Double warnArea;
	private String detail;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private District parent;
	
	@OneToMany(mappedBy="parent",fetch = FetchType.LAZY)
	@Cascade({org.hibernate.annotations.CascadeType.ALL,org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	private Set<District> childs;
	
	private String wtcode;
	
	private String remark;
	/**森林火险天气指数*/
	private Integer htz;
	/**森林火险天气等级*/
	private Integer htzGrade;
	/**
	 * 风级
	 */
	private Integer ws;
	/**`
	 * 相对湿度
	 */
	private Integer sd;
	
	
	/**
	 * 温度
	 */
	private Integer temp;
	/**连睛天数*/
	private Integer sunNum;

	public Integer getWs() {
		return ws;
	}


	public void setWs(Integer ws) {
		this.ws = ws;
	}


	public Integer getSd() {
		return sd;
	}


	public void setSd(Integer sd) {
		this.sd = sd;
	}


	public Integer getTemp() {
		return temp;
	}


	public void setTemp(Integer temp) {
		this.temp = temp;
	}


	public Integer getSunNum() {
		return sunNum;
	}


	public void setSunNum(Integer sunNum) {
		this.sunNum = sunNum;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getLat() {
		return lat;
	}


	public void setLat(Double lat) {
		this.lat = lat;
	}


	public Double getLng() {
		return lng;
	}


	public void setLng(Double lng) {
		this.lng = lng;
	}


	public Integer getId() {
		return id;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setParent(District parent) {
		this.parent = parent;
	}

	public District getParent() {
		return parent;
	}

	public void setChilds(Set<District> childs) {
		this.childs = childs;
	}

	public Set<District> getChilds() {
		return childs;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}


	public Double getArea() {
		return area;
	}


	public void setArea(Double area) {
		this.area = area;
	}


	public Double getWarnArea() {
		return warnArea;
	}


	public void setWarnArea(Double warnArea) {
		this.warnArea = warnArea;
	}


	public String getDetail() {
		return detail;
	}


	public void setDetail(String detail) {
		this.detail = detail;
	}


	public void setWtcode(String wtcode) {
		this.wtcode = wtcode;
	}


	public String getWtcode() {
		return wtcode;
	}


	public Integer getHtz() {
		return htz;
	}


	public void setHtz(Integer htz) {
		this.htz = htz;
	}


	public Integer getHtzGrade() {
		return htzGrade;
	}


	public void setHtzGrade(Integer htzGrade) {
		this.htzGrade = htzGrade;
	}
	
	
}