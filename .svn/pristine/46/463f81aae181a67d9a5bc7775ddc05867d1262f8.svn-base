package com.inc.gtc.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.inc.gtc.dao.CodecQueueDao;
import com.inc.gtc.domain.CodecQueue;

@Repository("codecQueueDao")
public class CodecQueueDaoImpl extends BaseJdbcDaoImpl<CodecQueue> implements CodecQueueDao{

	public Collection<CodecQueue> getQueueByStatus(Integer status,Integer limit)
	{
		String sql = "select * from "+tableName+" where status=? order by id asc limit 0,"+limit;
		return jdbcTemplate.query(sql,  
				 new Object[]{status},  
	                new int[]{java.sql.Types.INTEGER}, this.getRowMapper()
        );
	}

	
}


