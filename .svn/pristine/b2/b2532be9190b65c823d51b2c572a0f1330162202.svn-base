package com.inc.gmgrid.db;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;




/**
 * 数据源工厂
 * @author inc.courser
 *
 */
public class DataSourceFactory {

	public static DataSource createDataSource(String url,String db,String usrname, String pws,String dbType)
	{
		BasicDataSource ds = new BasicDataSource(); 
		ds.setDriverClassName("com.mysql.jdbc.Driver"); 
		//ds.setUrl("jdbc:mysql://"+url+":3306/"+db+"?useUnicode=true"); 
		ds.setUrl("jdbc:mysql://218.244.142.154:3306/"+db+"?useUnicode=true"); 
		ds.setUsername(usrname);
		ds.setPassword(pws); 
	/*	ds.setMaxActive(2);
		ds.setMaxIdle(maxIdle);*/
		return ds;
	}
}
