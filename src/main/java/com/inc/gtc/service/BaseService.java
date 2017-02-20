package com.inc.gtc.service;

import java.io.Serializable;

import com.itc.view.PaginationSupport;

public interface BaseService<T> {

	
	T get(Serializable oid);
	

	T save(T entity);
	

	void remove(T entity);
	
	
}
