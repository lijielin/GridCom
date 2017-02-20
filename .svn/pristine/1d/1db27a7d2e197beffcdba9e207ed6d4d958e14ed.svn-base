package com.inc.gtc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gtc.dao.PtNodeDao;
import com.inc.gtc.domain.PtNode;
import com.inc.gtc.service.PtNodeService;

@Service("ptNodeService")
public class PtNodeServiceImpl extends BaseServiceImpl<PtNode,PtNodeDao> implements PtNodeService {

	@Override
	@Autowired
	public void setDao(PtNodeDao dao)
	{
		super.setDao(dao);
	}
	
	
	public void removeUnitNode(String unit)
	{
		this.getDao().removeUnitNode(unit);
	}
	

}
