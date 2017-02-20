package com.inc.gtc.fire.dao.impl;


import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.MessageDao;
import com.inc.gtc.fire.domain.Message;
import com.itc.dao.h4.BaseDaoImpl;
/**
 * @author itc.tzj
 * @version 创建时间：2011-7-29 下午13:49:24
 * 消息dao
 */
@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {
	public Collection<Message> findLastMessage(final String phone)
	{
        Criteria crit = getSession().createCriteria(Message.class);
        crit.add(Restrictions.like("phones", "%" + phone + "%"));
        return crit.list();
	}
}
