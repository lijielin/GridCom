package com.inc.gtc.fire.dao;

import java.util.Collection;

import com.inc.gtc.fire.domain.Message;
import com.itc.dao.BaseDao;

/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 消息dao
 */
public interface MessageDao extends BaseDao<Message> {
	Collection<Message> findLastMessage(String phone);
}
