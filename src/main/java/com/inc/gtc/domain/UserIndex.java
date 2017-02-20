package com.inc.gtc.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Table;

import com.itc.domain.BaseEntity;

@Table(name="sys_userindex")
public class UserIndex  extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME="sys_userindex";
	
	private Integer id;
	
	private String code;
	
	private String name;
	
	private String unit;
	
	private String phone;
	
	private String email;

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

	
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Map<String,Object> toMap()
	{
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("code", code);
		data.put("unit", unit);
		data.put("name", name);
		data.put("phone", phone);
		data.put("email",email);
		return data;
	}
	
	
}
