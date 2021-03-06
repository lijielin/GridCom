package com.inc.gtc.sms;

import java.io.IOException;
import java.util.ArrayList;
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
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.inc.gtc.sms.req.AbstractReq;
import com.inc.gtc.sms.resp.SmsResp;

public class SmsClient {
	
	private static Logger logger = Logger.getLogger(SmsClient.class);

	private static String ENCODING = "UTF-8";
	private static String API_KEY = "a0aebc708b71d66e87a2cf17cf8bec06";
	
	public SmsResp postReq(AbstractReq req)
	{
		req.setApikey(API_KEY);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try
		{
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(10*1000).setConnectTimeout(10*1000).build();
			HttpPost post = new HttpPost(req.getUrl());
			post.setConfig(requestConfig);
			/*post.addHeader("Content-Type", "application/json; charset=utf-8"); 
			post.addHeader("Accept-Charset", "utf-8"); */
			Map<String,String> paramsMap = req.getReqEntity();
			 if (paramsMap != null) {
                 List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                 for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                     NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                     paramList.add(pair);
                 }
                 post.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
             }
			HttpResponse response = httpClient.execute(post);
			HttpEntity entity = response.getEntity();
			System.out.println("entity"+EntityUtils.toString(entity));
			System.out.println("entity.getContent()"+entity.getContent());
			SmsResp resp =  SmsResp.build(StreamUtil.convertStreamToString(entity.getContent(),ENCODING));
			System.out.println("resp.getVal(\"msg\")"+resp.getVal("msg"));
			if (!resp.getVal("msg").equals("OK"))
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
