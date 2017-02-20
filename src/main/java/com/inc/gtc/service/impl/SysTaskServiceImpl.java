package com.inc.gtc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gtc.dao.SysTaskDao;
import com.inc.gtc.domain.SysTask;
import com.inc.gtc.service.SysTaskService;

@Service("sysTaskService")
public class SysTaskServiceImpl extends BaseServiceImpl<SysTask,SysTaskDao> implements SysTaskService {

	@Override
	@Autowired
	public void setDao(SysTaskDao dao)
	{
		super.setDao(dao);
	}
}
