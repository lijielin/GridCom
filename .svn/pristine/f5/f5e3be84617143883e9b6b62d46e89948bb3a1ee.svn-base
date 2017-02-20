package com.inc.gtc.sms;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.SmsQueue;
import com.inc.gtc.fire.bus.process.ProcessChain;
import com.inc.gtc.sms.req.PullReplyReq;
import com.inc.gtc.sms.resp.RecvSmsMsg;
import com.inc.gtc.sms.resp.SmsResp;
import com.inc.yun.core.engin.AsyncExecutor;
import com.inc.yun.core.engin.Module;

/**
 * SMS接收 从云片网
 * @author atian
 *
 */
@Component("smsReceiver")
public class SmsListener extends AsyncExecutor implements Module{
	
	private static Logger logger = Logger.getLogger(SmsListener.class);
	
	@Autowired
	private SmsAdapter adapter;
	
	@Autowired
	private SmsQueue queue;
	
	@Override
	public void initialize()
	{
		super.initialize();
		/**
		 * 每隔10秒钟激活一次
		 */
		this.setInterval(1000*10);
	}
	
	@Override
	public void start()
	{
		super.start();
	}
	
	@Override
	public void execute(Object...args)
	{
		try
		{
			PullReplyReq req = new PullReplyReq();
			req.setPageSize(100);
		/*	Calendar cal = Calendar.getInstance();
			GetReplyReq req = new GetReplyReq();
			cal.add(Calendar.MINUTE,-30);
			req.setStartTime(cal.getTime());
			cal.add(Calendar.MINUTE,35);
			req.setEndTime(cal.getTime());*/
			SmsClient client = new SmsClient();
			SmsResp resp = client.postReq(req);
			/**
			 *  短信内容
			 */
			List<Map<String,Object>> msgs = (List<Map<String,Object>>)resp.getVal(SmsContants.KEY_REPLY);
			for (Map<String,Object> msg : msgs)
			{
				RecvSmsMsg recvMsg = RecvSmsMsg.create(msg);
				queue.add(adapter.convert(recvMsg));
				//chain.process();
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}
	}
}
