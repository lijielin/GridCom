package com.inc.gtc.fire.service.impl;


import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.UnsentSMSDao;
import com.inc.gtc.fire.domain.UnsentSMS;
import com.inc.gtc.fire.service.UnsentSMSService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 消息service
 */
@Service("unsentSMSService")
public class UnsentSMSServiceImpl extends BaseServiceImpl<UnsentSMS, UnsentSMSDao> implements UnsentSMSService {
	@Resource(name="unsentSMSDao")
	public void setDao(UnsentSMSDao dao){
		super.setDao(dao);
	}
	public Collection<UnsentSMS> loadAll(){
		return this.getDao().loadAll();
	}
}
