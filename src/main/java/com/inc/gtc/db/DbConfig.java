package com.inc.gtc.db;

/**
 *  数据库链接配置
 * @author inc.courser
 *
 */
public class DbConfig {
	
	private String driverClass;
	
	private String url;
	
	private Integer port;
	
	private String userName;
	
	private String pwd;
	
	private String dbName;
	
	public DbConfig()
	{
		
	}
	
	public DbConfig(String driverClass,String url,Integer port,String userName,String pwd,String dbName)
	{
		setDriverClass(driverClass);
		setUrl(url);
		setPort(port);
		setUserName(userName);
		setPwd(pwd);
		setDbName(dbName);
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	
	
}
