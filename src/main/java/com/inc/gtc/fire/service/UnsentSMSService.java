package com.inc.gtc.fire.service;

import java.util.Collection;

import com.inc.gtc.fire.domain.UnsentSMS;
import com.itc.service.BaseService;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 消息service
 */
public interface UnsentSMSService extends BaseService<UnsentSMS> {
	Collection<UnsentSMS> loadAll();;
}
