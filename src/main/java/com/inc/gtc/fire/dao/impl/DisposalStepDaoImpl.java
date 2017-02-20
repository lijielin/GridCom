package com.inc.gtc.fire.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gtc.fire.dao.DisposalStepDao;
import com.inc.gtc.fire.domain.DisposalStep;
import com.itc.dao.h4.BaseDaoImpl;

/**
 * @author itc.chenzhi
 * @version 创建时间：2013-5-17 上午10:43:16
 * 类说明
 */
@Repository("disposalStepDao")
public class DisposalStepDaoImpl extends BaseDaoImpl<DisposalStep> implements DisposalStepDao{

	public DisposalStep getStepByCode(final  String code)
	{
		Criteria criteria = getSession().createCriteria(DisposalStep.class);
		criteria.add(Restrictions.eq("code", code));
		List<DisposalStep> rs = criteria.list();
		if (rs.size()>0)
			return rs.get(0);
		else
			return null;
				       
	}
}
