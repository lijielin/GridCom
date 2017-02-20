package com.inc.gmgrid.db;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = -7835529171318269919L;

	public DbException(String message)
	{
		super(message);
	}
	
	public DbException(Exception e)
	{
		super(e.getMessage());
	}
}
