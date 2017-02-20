package com.inc.gtc.fire.dao.impl;


import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.ReplyMessageDao;
import com.inc.gtc.fire.domain.ReplyMessage;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 回复消息dao
 */
@Repository("replyMessageDao")
public class ReplyMessageDaoImpl extends BaseDaoImpl<ReplyMessage> implements ReplyMessageDao {
}
