package com.inc.gm.service.task.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.inc.gm.dao.task.NodeDetailDao;
import com.inc.gm.domain.task.NodeDetail;
import com.inc.gm.service.BaseServiceImpl;
import com.inc.gm.service.task.NodeDetailService;	


/**
 * NodeDetailService
 *
 * @author 
 * @version 2015-12-09 17:40:15
 */
@Service("nodeDetailService")
public class NodeDetailServiceImpl extends BaseServiceImpl<NodeDetail,NodeDetailDao> implements NodeDetailService{
	


	@Resource(name="nodeDetailDao")
	public void setDao(NodeDetailDao dao)
	{
		super.setDao(dao);
	}

	@Override
	public Collection<NodeDetail> findNodeDetail(String pointNodeId) {
		// TODO Auto-generated method stub
		return this.getDao().findById(pointNodeId);
	}


}
