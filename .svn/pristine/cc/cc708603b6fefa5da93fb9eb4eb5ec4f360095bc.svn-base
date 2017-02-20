package com.inc.gtc.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.inc.gtc.dao.UserIndexDao;
import com.inc.gtc.db.DbException;
import com.inc.gtc.domain.UserIndex;

@Repository("userIndexDao")
public class UserIndexDaoImpl extends BaseJdbcDaoImpl<UserIndex> implements UserIndexDao {

	public  void removeUnitUser(String unit)
	{
	  String sql = "delete from "+tableName+" where unit=?";
	     try {
			jdbcTemplate.update(sql, new Object[]{unit});
		} catch (Exception e) {
			throw new DbException(e);
		} 
	}
	
	public UserIndex findIndex(String email,String tel)
	{
		String sql = "select * from "+tableName+" where ";
		String con = null;
		if (StringUtils.isNotBlank(email))
			con = "email='"+email+"'";
		if (StringUtils.isNotBlank(tel))
			con = (con!=null)?con=" and phone='"+tel+"'":"phone='"+tel+"'";
		List<UserIndex> ui =  jdbcTemplate.query(sql+con,  
                null,  
                null,getRowMapper()
        );  
	  if (ui.size()>0)
		  return ui.get(0);
	  else
		  return null;
	}
	
}
