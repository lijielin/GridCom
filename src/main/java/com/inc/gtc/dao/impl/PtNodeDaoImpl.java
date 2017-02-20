package com.inc.gtc.dao.impl;

import org.springframework.stereotype.Repository;

import com.inc.gtc.dao.PtNodeDao;
import com.inc.gtc.db.DbException;
import com.inc.gtc.domain.PtNode;

@Repository("ptNodeDao")
public class PtNodeDaoImpl  extends BaseJdbcDaoImpl<PtNode> implements PtNodeDao{

	public  void removeUnitNode(String unit)
	{
	  String sql = "delete from "+tableName+" where unit=?";
	     try {
			jdbcTemplate.update(sql, new Object[]{unit});
		} catch (Exception e) {
			throw new DbException(e);
		} 
	}

}

