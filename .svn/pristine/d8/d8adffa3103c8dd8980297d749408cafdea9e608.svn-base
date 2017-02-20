package com.inc.gtc.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;
import org.apache.tools.ant.types.EnumeratedAttribute;
import org.springframework.stereotype.Component;

@Component("dbCreator")
public class DbCreatorImpl implements DbCreator {

	@Override
	public  void createDb(DbConfig config,String dbName,String encode,File sqlFile) {
		Connection conn = null;
		try
		{
			Class.forName(config.getDriverClass());  
			conn = DriverManager.getConnection(buildUrl(config),config.getUserName(),config.getPwd());
			Statement statement = conn.createStatement();
			statement.executeUpdate("create database  "+dbName);
			statement.close();
			config.setDbName(dbName);
			SQLExec sqlExec = new SQLExec();   
			sqlExec.setDriver(config.getDriverClass());   
			sqlExec.setUrl(buildUrl(config));  
			sqlExec.setUserid(config.getUserName());   
			sqlExec.setPassword(config.getPwd());  
			sqlExec.setSrc(sqlFile);  
			sqlExec.setOnerror((SQLExec.OnError)(EnumeratedAttribute.getInstance(   
			SQLExec.OnError.class, "abort")));  
			sqlExec.setPrint(true);  
			sqlExec.setProject(new Project());  
			sqlExec.execute();  
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new DbException(e);
		}
		finally
		{
			if (conn!=null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private String buildUrl(DbConfig config)
	{
		return "jdbc:mysql://"+config.getUrl()+":3306/"+config.getDbName()+"?useUnicode=true";
	}

}
