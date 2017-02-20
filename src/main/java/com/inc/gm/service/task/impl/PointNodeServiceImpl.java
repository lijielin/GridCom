package com.inc.gm.service.task.impl;




import java.util.Calendar;
import java.util.Collection;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.inc.gm.dao.task.PointNodeDao;
import com.inc.gm.domain.task.PointNode;
import com.inc.gm.service.BaseServiceImpl;
import com.inc.gm.service.task.PointNodeService;

@Service("pointNodeService")
public class PointNodeServiceImpl extends BaseServiceImpl<PointNode,PointNodeDao> implements PointNodeService{


	
	@Override
	@Resource(name="pointNodeDao")
	public void setDao(PointNodeDao dao)
	{
		super.setDao(dao);
	}
	


	@Override
	public Collection<PointNode> findPointNode(Integer type) {
		return this.getDao().findPointNodeByType(type);
	}

	@Override
	public PointNode findById(String pointNodeId) {
		return this.getDao().findById(pointNodeId);
	}




	@Transactional
	public PointNode savePointNode(PointNode pointNode, Double lng, Double lat, int type,PointNode parent) {
		pointNode.setCreateTime(Calendar.getInstance().getTimeInMillis());
		pointNode.setLng(lng);
		pointNode.setLat(lat);
		pointNode.setType(type);
		if(parent!=null){
			pointNode.setParent(parent);
		}
		return super.save(pointNode);
	}
	
	public 	void removeNodes(Integer type)
	{
		this.getDao().removeNodes(type);
	}
}
