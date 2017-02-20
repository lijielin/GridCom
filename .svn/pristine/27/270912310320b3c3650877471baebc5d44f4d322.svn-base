package com.inc.gtc.fire.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gtc.fire.dao.MessageDao;
import com.inc.gtc.fire.domain.Message;
import com.inc.gtc.fire.service.MessageService;
import com.itc.service.BaseServiceImpl;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午14:13:18
 * 消息service
 */
@Service("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message, MessageDao> implements MessageService {
	@Resource(name="messageDao")
	public void setDao(MessageDao dao){
		super.setDao(dao);
	}
	
}
