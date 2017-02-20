package com.inc.gmgrid.db;

import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.inc.gtc.domain.Unit;
import com.inc.gtc.service.UnitService;
import com.inc.yun.context.BeanFactory;

/**
 * 数据源仓库
 * 
 * @author inc.courser
 *
 */
public class DsDepot {

	private static DsDepot instance = null;

	private Map<String, DataSource> depot;
	


	public DsDepot() {
		depot = new ConcurrentHashMap<String, DataSource>();
	}

	public static DsDepot getInstance() {
		if (instance == null)
			instance = new DsDepot();
		return instance;
	}



	
	public DataSource getBindDs() {
		if (DbToken.get()!=null)
		{
			if (depot.containsKey(DbToken.get()))
			{
				return (DataSource)depot.get(DbToken.get());
			}
			else
			{
				return bind(DbToken.get());
			}
		}
		else
		{
			return null;
		}
	}

	public DataSource getDataSource(Integer id) {
		return depot.get(id);
	}
	public DataSource bind(Object code) {
		try
		{
			
			UnitService unitService = (UnitService)BeanFactory.getInstance().getBean("unitService");
			if (unitService!=null)
			{
				Unit unit = unitService.findByCode((String)code);
				return register(unit.getCode(),unit.getDbUrl(), unit.getDbName(), unit.getDbUser(), unit.getDbPwd(), null);
			}
			else
			{
				throw new DbException("Not found DataSource for Id with " + code);
			}
			
		}
		
		catch (Exception e)
		{
			throw new DbException("Not found DataSource for Id with " + code);
		}
	
	}

	

	/**
	 * 注册数据源
	 * 
	 * @param url
	 * @param username
	 * @param pws
	 * @param dbType
	 */
	public DataSource register(String id, String url, String db,
			String username, String pws, String dbType) {
		DataSource ds = DataSourceFactory.createDataSource(url, db, username,
				pws, dbType);

		this.depot.put(id, ds);
		return ds;
	}

	public void close(Integer id) {
		BasicDataSource ds = (BasicDataSource) depot.get(id);
		try {
			ds.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		depot.remove(id);
	}
	
	public Map<String, DataSource> getDepot() {
		return depot;
	}

	public void setDepot(Map<String, DataSource> depot) {
		this.depot = depot;
	}
}
