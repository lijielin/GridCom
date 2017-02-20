package com.inc.gtc.context;

import org.springframework.stereotype.Component;

import com.inc.yun.cfg.ConfigContext;

@Component("gtcAppContext")
public class AppContext implements  com.inc.yun.context.AppContext{

	private static String APP_DIRECTORY = "";
	
	private static final String SERVERID = "server.id";
	private static final String SERVERADDR = "server.addr";
	private static final String CONFIGDIRECTORY =  "/cfg";
	private static final String CONFIG_GATWAYFILE = "server.cfg";
	
	public String getConfigDirectory()
	{
		return CONFIGDIRECTORY;
	}
	
	public String getConfigFile()
	{
		return CONFIG_GATWAYFILE;
	}
	
	public  String getAppId()
	{
		return ConfigContext.getProperty(SERVERID);
	}
	
	public  String getServerAddr()
	{
		return ConfigContext.getProperty(SERVERADDR);
	}
	
	public String getAppDirectory()
	{
		return APP_DIRECTORY;
	}
	
	public void setAppDirectory(String arg)
	{
		APP_DIRECTORY  = arg;
	}

	@Override
	public Object getContextAttr(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContextAttr(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}


}