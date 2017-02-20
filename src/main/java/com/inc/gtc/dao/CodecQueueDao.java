package com.inc.gtc.dao;

import java.util.Collection;

import com.inc.gtc.domain.CodecQueue;

public interface CodecQueueDao extends BaseJdbcDao<CodecQueue>{

	Collection<CodecQueue> getQueueByStatus(Integer status,Integer limit);
}
