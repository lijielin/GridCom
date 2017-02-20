package com.inc.gtc.domain;

import javax.persistence.Table;

import com.itc.domain.BaseEntity;

@Table(name="sys_unit")
public class Unit extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String code;
	
	private String name;
	
	private String dbName;
	
	private String dbUrl;
	
	private String dbUser;
	
	private String dbPwd;
	
	private String city;
	
	private String deviceSn;
	
	private Double lng;
	
	private Double lat;

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

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPwd() {
		return dbPwd;
	}

	public void setDbPwd(String dbPwd) {
		this.dbPwd = dbPwd;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDeviceSn() {
		return deviceSn;
	}

	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	
	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Unit)
		{
			if (this.id!=null && ((Unit)obj).getId()!=null)
			{
				return ((Unit)obj).getId().intValue()==this.id.intValue();
			}
			else
			{
				return false;
			}
		}
		if (obj instanceof String)
		{
			return this.code.equals((String)obj);
		}
		else
		{
			return false;
		}
	}


}
