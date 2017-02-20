package com.inc.gtc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.inc.gtc.dao.UnitDao;
import com.inc.gtc.domain.Unit;

@Repository("unitDao")
public class UnitDaoImpl extends BaseJdbcDaoImpl<Unit> implements UnitDao{

	public 	Unit findByCode(String code)
	{
		try
		{
			return jdbcTemplate.queryForObject("select * from sys_unit where code = ?",  
	                new Object[]{code},  
	                new int[]{java.sql.Types.VARCHAR},   
	                new RowMapper<Unit>() {  
	                    @Override  
	                    public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {  
	                    	Unit unit  = new Unit();  
	                    	unit.setId(rs.getInt("id"));  
	                    	unit.setCode(rs.getString("code"));  
	                    	unit.setName(rs.getString("name"));  
	                    	unit.setDbName(rs.getString("dbname"));
	                    	unit.setDbPwd(rs.getString("dbpwd"));
	                    	unit.setDbUrl(rs.getString("dburl"));
	                    	unit.setDbUser(rs.getString("dbuser"));
	                    	unit.setCity(rs.getString("city"));
	                    	unit.setDeviceSn(rs.getString("deviceSn"));
	                     	unit.setLng(rs.getDouble("lng"));
	                    	unit.setLat(rs.getDouble("lat"));
	                        return unit;  
	                    }  
	                }  
	        );
		}catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}
	
	public Collection<Unit> loadAll()
	{
		try
		{
			return jdbcTemplate.query("select * from sys_unit ",  
	                null,null,   
	                new RowMapper<Unit>() {  
	                    @Override  
	                    public Unit mapRow(ResultSet rs, int rowNum) throws SQLException {  
	                    	Unit unit  = new Unit();  
	                    	unit.setId(rs.getInt("id"));  
	                    	unit.setCode(rs.getString("code"));  
	                    	unit.setName(rs.getString("name"));  
	                    	unit.setDbName(rs.getString("dbname"));
	                    	unit.setDbPwd(rs.getString("dbpwd"));
	                    	
	                    	unit.setDbUrl(rs.getString("dburl"));
	                    	unit.setDbUser(rs.getString("dbuser"));
	                    	unit.setCity(rs.getString("city"));
	                    	unit.setDeviceSn(rs.getString("deviceSn"));
	                     	unit.setLng(rs.getDouble("lng"));
	                    	unit.setLat(rs.getDouble("lat"));
	                        return unit;  
	                    }  
	                }  
	        );
		}catch (EmptyResultDataAccessException e)
		{
			return null;
		}
	}

}
