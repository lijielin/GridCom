package com.inc.gmgrid.db;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class ActDataSource  implements javax.sql.DataSource{
	

	private DataSource defaultDataSource;
	
	public void setDefaultDataSource(DataSource defaultDataSource) {
		this.defaultDataSource = defaultDataSource;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		try
		{
			DataSource ds = DsDepot.getInstance().getBindDs();
			return (ds!=null)?ds.getConnection():defaultDataSource.getConnection();
		}
		catch (Exception e)
		{
			return defaultDataSource.getConnection();
		}
	}

	@Override
	public Connection getConnection(String username, String password)
			throws SQLException {
		DataSource ds = DsDepot.getInstance().getBindDs();
		return (ds!=null)?ds.getConnection(username, password):null;
	}

}
