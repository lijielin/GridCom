package com.inc.gtc.service;

import java.util.Collection;

import com.inc.gtc.domain.CodecQueue;

public interface CodecQueueService extends BaseService<CodecQueue>{

	Collection<CodecQueue> getQueueByStatus(Integer status,Integer limit);
}
