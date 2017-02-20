package com.inc.gm.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.itc.domain.Entity;

public class GmBaseDaoImpl<T extends Entity> extends com.itc.dao.h4.BaseDaoImpl<T>{

	 
	@Override
	@Resource(name="gmSessionFactory")
	public void setSessionFactory(SessionFactory factory)
	{
		super.setSessionFactory(factory);
	}
	

}
