package com.inc.gtc.dao;

import java.util.Collection;

import com.inc.gtc.domain.Unit;

public interface UnitDao extends BaseJdbcDao<Unit>{

	Unit findByCode(String code);
	
	Collection<Unit> loadAll();
}
