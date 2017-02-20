package com.inc.gtc.service;

import java.util.Collection;

import com.inc.gtc.domain.Unit;

public interface UnitService extends BaseService<Unit>{

	Unit findByCode(String code);
	
	Collection<Unit> loadAll();
}
