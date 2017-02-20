package com.inc.gm.dao.task.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gm.dao.task.PointNodeDao;
import com.inc.gm.domain.task.PointNode;
import com.inc.gm.dao.GmBaseDaoImpl;

@Repository("pointNodeDao")
public class PointNodeDaoImpl extends GmBaseDaoImpl<PointNode> implements PointNodeDao{


	@SuppressWarnings("unchecked")
	@Override
	public Collection<PointNode> findPointNodeByType(Integer type) {
		Criteria criteria = getSession().createCriteria(PointNode.class);
    	criteria.add(Restrictions.eq("type", type));
    	return criteria.list();
	}

	@Override
	public PointNode findById(String pointNodeId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void removeNodes(Integer type)
	{
		String hql="delete PointNode as p where p.type=?";
		Query query=getSession().createQuery(hql);
		query.setInteger(0,type);
		query.executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<PointNode> findByType(int type) {
		Criteria criteria = getSession().createCriteria(PointNode.class).add(Restrictions.eq("type", type));
		return criteria.list();
	}


}
