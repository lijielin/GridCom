package com.inc.gm.service.task;

import java.util.Collection;

import com.inc.gm.domain.task.PointNode;
import com.inc.gm.service.BaseService;

public interface PointNodeService extends BaseService<PointNode>{
	Collection<PointNode> findPointNode(Integer type);

	PointNode findById(String pointNodeId);

	PointNode savePointNode(PointNode pointNode, Double lng, Double lat, int type, PointNode parent);
	
	void removeNodes(Integer type);

}
