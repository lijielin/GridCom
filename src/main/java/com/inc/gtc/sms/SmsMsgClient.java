package com.inc.gtc.sms;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.inc.gtc.sms.req.AbstractReq;
import com.inc.gtc.sms.resp.SmsResp;

public class SmsMsgClient {
	
//	@Value("${SpCode}")
//	private String SpCode;
//	
//	@Value("${LoginName}")
//	private String LoginName;
//	
//	@Value("${Password}")
//	private String Password;
	
	
	private static Logger logger = Logger.getLogger(SmsMsgClient.class);

	private static String ENCODING = "GBK";
	private static String uriAPI = "https://api.ums86.com:9600/sms/Api/Send.do";
	private static String SpCode = "201456";
	private static String LoginName = "cq_ykdz";
	private static String Password = "ad2001";
	
	public SmsResp postReq(AbstractReq req)
	{
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = formatter.format(currentTime);
		System.out.println("dateString"+"cqykdz"+dateString);
		req.setSpCode(SpCode);
		req.setLoginName(LoginName);
		req.setPassword(Password);
		req.setSerialNumber("cqykdz"+dateString);
		req.setF("1");
		req.setScheduleTime("");
		req.setApikey("");
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try
		{
			
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*1000).setConnectTimeout(10*1000).build();
			StringBuffer sb = new StringBuffer(uriAPI);
			HttpPost post = new HttpPost(sb.toString());
			post.setConfig(requestConfig);
			Map<String,String> paramsMap = req.getReqEntity();
			 if (paramsMap != null) {
                 List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                 for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                     NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                     paramList.add(pair);
//                     System.out.println("param.getValue"+param.getValue());
                 }
                 paramList.add(new BasicNameValuePair("SpCode", "201456"));
                 paramList.add(new BasicNameValuePair("LoginName", "cq_ykdz"));
                 paramList.add(new BasicNameValuePair("Password", "ad2001"));
                 paramList.add(new BasicNameValuePair("MessageContent", "您的验证码为1"));
                 paramList.add(new BasicNameValuePair("UserNumber", "15123901329,13640519514"));
                 paramList.add(new BasicNameValuePair("SerialNumber", "12345678912345678911"));
                 paramList.add(new BasicNameValuePair("ScheduleTime", ""));
                 paramList.add(new BasicNameValuePair("f", "1"));
                 post.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
             }
			System.out.println("paramsMap"+paramsMap);
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			SmsResp resp =  SmsResp.build(StreamUtil.convertStreamToString(entity.getContent(),ENCODING));
			if (!resp.getVal("result").equals("0"))
			{
				logger.error("send sms failure");
			}
			return resp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
