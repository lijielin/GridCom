package com.inc.gtc.fire.service;

import java.util.Collection;

import org.hibernate.criterion.DetachedCriteria;

/**
 * @author itc.chenzhi
 * @version 创建时间：2011-3-11 上午11:45:56
 * 类说明
 */
public interface QueryService {
	public Object load(Class cls,java.io.Serializable id);
	
	public Collection<?> query(DetachedCriteria criteria);
}
