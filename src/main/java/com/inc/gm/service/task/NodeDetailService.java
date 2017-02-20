package com.inc.gm.service.task;

import java.util.Collection;

import com.inc.gm.domain.task.NodeDetail;
import com.inc.gm.service.BaseService;


/**
 * NodeDetailService
 *
 * @author 
 * @version 2015-12-09 17:40:15
 */
public interface NodeDetailService extends BaseService<NodeDetail>{

	Collection<NodeDetail> findNodeDetail(String pointNodeId);


	

}
