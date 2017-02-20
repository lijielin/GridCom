package com.inc.gm.domain;

import javax.persistence.MappedSuperclass;

import com.itc.domain.BaseEntity;

@MappedSuperclass
public abstract class BaseObj extends BaseEntity{
	
	private static final long serialVersionUID = 1L;
	
	private Long token;

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}
	
}
