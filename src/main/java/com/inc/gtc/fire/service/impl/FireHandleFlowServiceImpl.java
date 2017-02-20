package com.inc.gtc.fire.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.FireHandleFlowDao;
import com.inc.gtc.fire.domain.FireHandleFlow;
import com.inc.gtc.fire.service.FireHandleFlowService;
import com.itc.service.BaseServiceImpl;

@Service("fireHandleFlowService")
public class FireHandleFlowServiceImpl extends BaseServiceImpl<FireHandleFlow, FireHandleFlowDao> implements FireHandleFlowService {
	@Resource(name="fireHandleFlowDao")
	public void setDao(FireHandleFlowDao dao){
		super.setDao(dao);
	}
	
}
