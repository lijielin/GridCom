package com.inc.gm.dao.task.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gm.dao.task.NodeDetailDao;
import com.inc.gm.domain.task.NodeDetail;
import com.inc.gm.dao.GmBaseDaoImpl;

/**
 * NodeDetailDao
 *
 * @author 
 * @version 2015-12-09 17:40:15
 */
@Repository("nodeDetailDao")
public class NodeDetailDaoImpl extends GmBaseDaoImpl<NodeDetail> implements NodeDetailDao{

	@SuppressWarnings("unchecked")
	public Collection<NodeDetail> findById(String pointNodeId) {
		Criteria criteria = this.getSession().createCriteria(NodeDetail.class);
		criteria.add(Restrictions.eq("pointNode.id",pointNodeId));
		return criteria.list();
	}

}
