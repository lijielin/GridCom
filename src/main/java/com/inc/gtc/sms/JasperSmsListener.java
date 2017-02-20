package com.inc.gtc.sms;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.xml.soap.SOAPException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.inc.gtc.sms.jasper.EchoClient;
import com.inc.gtc.sms.jasper.GetSessionInfoClient;
import com.inc.gtc.sms.jasper.GetTerminalDetailsClient;
import com.inc.yun.core.engin.AsyncExecutor;
import com.inc.yun.core.engin.Module;
import com.sun.xml.wss.XWSSecurityException;

import net.sf.ehcache.hibernate.ccs.EhcacheReadOnlyCache;

@Component("jasperSmsReceiver")
public class JasperSmsListener extends AsyncExecutor implements Module {
	
	private static final Logger logger = Logger.getLogger(JasperSmsListener.class);
	
	private String url = "https://api.10646.cn";
	
	private String licenseKey = "c78b4e2e-5271-4c3a-b74e-3ee4e4ad0be1" ;
			
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		super.initialize();
		this.setInterval(1000*10);
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		super.start();
	}
	@Override
	public void execute(Object... args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("excute");
			GetTerminalDetailsClient client = new GetTerminalDetailsClient(url, licenseKey);
//			GetSessionInfoClient client = new GetSessionInfoClient(url, licenseKey);
//			EchoClient client = new EchoClient(url, licenseKey);
			client.callWebService("fengqiang", "fq123456", "89860616090013176993");
//			client.callWebService();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.execute(args);
	}
}
