package com.inc.gtc.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gtc.dao.CodecQueueDao;
import com.inc.gtc.domain.CodecQueue;
import com.inc.gtc.service.CodecQueueService;

@Service("codecQueueService")
public class CodecQueueServiceImpl extends BaseServiceImpl<CodecQueue,CodecQueueDao> implements CodecQueueService{

	@Override
	@Autowired
	public void setDao(CodecQueueDao dao)
	{
		super.setDao(dao);
	}
	
	public Collection<CodecQueue> getQueueByStatus(Integer status,Integer limit)
	{
		return this.getDao().getQueueByStatus(status, limit);
	}

	

}
