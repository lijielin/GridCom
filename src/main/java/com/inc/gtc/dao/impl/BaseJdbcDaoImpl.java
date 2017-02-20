package com.inc.gtc.dao.impl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Table;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.inc.gtc.dao.JdbcHelper;
import com.inc.gtc.db.DbException;
import com.itc.view.PaginationSupport;

public abstract class BaseJdbcDaoImpl<T> {
	
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	protected Class<T> entityClass;
	
	protected String tableName;
	
	private RowMapper<T> rowMapper;
	
	PropertyDescriptor[] properties;

	
	@SuppressWarnings("unchecked")
	public BaseJdbcDaoImpl() {
	        entityClass =(Class<T>) ((ParameterizedType) getClass()
	                                .getGenericSuperclass()).getActualTypeArguments()[0];
	        tableName = ((Table)entityClass.getAnnotation(Table.class)).name();
	 }
	 
	/**
	 * 根据ID查询
	 * @param oid
	 * @return
	 */
	public T get(Serializable oid)
	{
		try
		{
			return jdbcTemplate.queryForObject("select * from "+tableName+" where id = ?",  
	            new Object[]{oid},  
	            new int[]{java.sql.Types.INTEGER},   getRowMapper());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}  
	
	
	public RowMapper<T> getRowMapper()
	{
		if (rowMapper==null)
		{
			rowMapper = new RowMapper<T>()
            {
                @Override
                public T mapRow(ResultSet rs, int rowNum) throws SQLException
                {
                	try
                	{
                		T entity = entityClass.newInstance();
                		for (int i=1;i<=rs.getMetaData().getColumnCount();i++)
                		{
                			if (PropertyUtils.getPropertyDescriptor(entity, rs.getMetaData().getColumnName(i))!=null)
                			{
                				PropertyUtils.setProperty(entity, rs.getMetaData().getColumnName(i), JdbcHelper.getItemVal(rs, i));
                			}
                		}
                		return entity;
                	}
                	catch (Exception e)
                	{
                		e.printStackTrace();
                		throw new DbException(e);
                	}
                }
            };
		}
		return rowMapper;
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public T save(T entity)
	{
		try {
			if (PropertyUtils.getProperty(entity, "id")==null)
			{
				 SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);  
				 insert.withTableName(tableName);
				 insert.setGeneratedKeyName("id");
				 PropertyUtils.setProperty(entity, "id", insert.executeAndReturnKey(toMap(entity)).intValue());
				 return entity;
			}
			else	
			{
				List<Object> vals =getVals(entity);
				vals.add(PropertyUtils.getProperty(entity, "id"));
				jdbcTemplate.update(buildUpdateStatment(),vals.toArray());
				return entity;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DbException(e);
		} 
	}

	private String buildUpdateStatment()
	{
		String s = null;
		for (PropertyDescriptor desc : getEntityProperties())
		{
			if (desc.getName().equals("id") || 	desc.getName().equals("class"))
				continue;
			if (s!=null)
			{
				s = s+",";
				s+="  "+desc.getName()+"=?";
			}
			else
			{
				s=" set "+desc.getName()+"=?";
			}
		}
		return "update "+tableName+s+" where id=?";
	}
	
	private List<Object> getVals(T entity) throws Exception
	{
		List<Object> list = new ArrayList<Object>();
	
		for (PropertyDescriptor desc : getEntityProperties())
		{
			if (desc.getName().equals("id") || 	desc.getName().equals("class"))
				continue;
			list.add(PropertyUtils.getProperty(entity, desc.getName()));
		}
		return list;
	}
	
	protected Map<String,Object> toMap(T entity) throws Exception
	{
		Map<String,Object> map = new HashMap<String,Object>();
		for (PropertyDescriptor desc : getEntityProperties())
		{
			if (desc.getName().equals("class"))continue;
			map.put(desc.getName(), PropertyUtils.getProperty(entity, desc.getName()));
		}
		return map;
	}
	
	private PropertyDescriptor[] getEntityProperties()
	{
		if (properties==null)
			properties = PropertyUtils.getPropertyDescriptors(entityClass);
		return properties;
	}
	

	
	/**
	 * 删除
	 * @param entity
	 */
	public void remove(T entity)
	{
        String sql = "delete from "+tableName+" where id =?";
         try {
			jdbcTemplate.update(sql, new Object[]{PropertyUtils.getProperty(entity, "id")});
		} catch (Exception e) {
			throw new DbException(e);
		} 
	}
	
	public 	void batchRemove(Serializable[] ids)
	{
	    String sql = "delete from "+tableName+" where id = ?";
        try {
        	for(int i=0;i<ids.length;i++){
        		jdbcTemplate.update(sql, new Object[]{ids[i]});
        	}
		} catch (Exception e) {
			throw new DbException(e);
		} 
	}

	public PaginationSupport listByPage(final PaginationSupport page)
	{
		String sql = "select * from "+tableName+" order by id asc limit "+page.getCurrentPage()*page.getPageSize()+","+(page.getCurrentPage()*page.getPageSize()+page.getPageSize());
		List<T> rs =  jdbcTemplate.query(sql,  
                null,  
                null, this.getRowMapper()
        );
		page.setItems(rs);
		return page;
	}

}
