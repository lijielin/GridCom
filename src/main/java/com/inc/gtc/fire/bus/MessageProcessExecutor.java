package com.inc.gtc.fire.bus;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inc.gateway.flow.cmd.CmdAttrs;
import com.inc.gtc.fire.bus.msg.ErrMessage;
import com.inc.gtc.fire.bus.msg.Message;
import com.inc.gtc.fire.bus.msg.RecvMessage;
import com.inc.gtc.fire.bus.msg.SuccessMessage;
import com.inc.gtc.fire.bus.process.ProcessChain;
import com.inc.yun.core.engin.DefaultExecutorImpl;

/**
 * 	MQ消息处理
 * @author atian
 *
 */
@Component("msgProcessExecutor")
@Scope("prototype")
public class MessageProcessExecutor extends DefaultExecutorImpl{
	
	private Logger logger = Logger.getLogger(MessageProcessExecutor.class);
	
	private static final String QUEUE = "com.inc.gateway.queue";
	
	@Autowired
	private SmsQueue queue;
	
	@Autowired
	private ProcessChain chain;
	
	
	@Override
	public void execute(Object...args) {
		try
		{
			Object wc = queue.get();
			if (wc!=null)
			{	
				if (wc instanceof String)
				{
					ObjectMapper mapper = new ObjectMapper();
					Map<String,Object> data =mapper.readValue((String)wc, new TypeReference<Map<String,Object>>() { });
					CmdAttrs attr = CmdAttrs.buildAttrs(data);
					Message msg = null;
					if (attr.containsAttr("successful"))
					{
						msg = new SuccessMessage();
					}
					else if (attr.containsAttr("error"))
					{
						msg = new ErrMessage();
					}
					else
					{
						/**
						 * from json to data
						 */
						msg = new RecvMessage();
					}
					msg.buildAttr(attr);
					chain.process(msg);
				}
				else
				{
					chain.process((RecvMessage)wc);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}
		
	}
	
	
}
