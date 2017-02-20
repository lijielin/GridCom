package com.inc.gtc.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gtc.dao.UnitDao;
import com.inc.gtc.domain.Unit;
import com.inc.gtc.service.UnitService;

@Service("unitService")
public class UnitServiceImpl extends BaseServiceImpl<Unit,UnitDao> implements UnitService{


	@Override
	@Autowired
	public void setDao(UnitDao dao)
	{
		super.setDao(dao);
	}
	
	public Unit findByCode(String code)
	{
		return this.getDao().findByCode(code);
	}
	
	public Collection<Unit> loadAll()
	{
		return this.getDao().loadAll();
	}
}
