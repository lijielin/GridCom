package com.inc.gmgrid.db;

public class DbToken {
	
	private static final String TOKEN_KEY = "ACTDATASOURCE_BOUND_TOKEN";
	private static final String DEFAULTTOKEN_KEY = "gm";
	private static ThreadLocal<Object> token  = new ThreadLocal<Object>();
	
	public  static Object get()
	{
		try
		{
			if ( token.get()!=null)
			{
				return token.get();
			}
		}
		catch (IllegalStateException e)
		{
			
		}
		return DEFAULTTOKEN_KEY;
	}
	
	public static void set(Object arg)
	{
		token.set(arg);
	}
	

}
