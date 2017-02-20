package com.inc.gtc.fire.bus;

import java.util.Calendar;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.buf.SendBuffer;
import com.inc.gtc.fire.bus.buf.SendItem;
import com.inc.yun.bridge.SimpleDeliveryTarget;
import com.inc.yun.core.engin.DefaultExecutorImpl;
import com.inc.yun.core.engin.Module;

/**
 * 重发检查
 * @author courser
 *
 */
@Component("repeatSendModule")
public class RepeatSendModule extends DefaultExecutorImpl implements Module{
	
	private Logger logger = Logger.getLogger(RepeatSendModule.class);
	
	private final static int TIMEOUT = 1000*20;
	
	private final static int MAX_RETRYCOUNT = 3;
	
	@Autowired
	private SendMessageService sendMsgService;
	@Autowired
	private SendBuffer<SendItem> buf;

	public RepeatSendModule()
	{
		this.setLoopInterval(5*1000);
	}
	
	@Override
	public void execute(Object...args)
	{
		try
		{
			long nt = Calendar.getInstance().getTimeInMillis();
			Collection<SendItem> items = buf.getItems();
			for (SendItem item :items)
			{
				if ((nt-item.getLastSendTime())>TIMEOUT)
				{
					if (item.getRetryCount()>=MAX_RETRYCOUNT)
					{
						buf.remove(item.getCmd().getPm());
					}
					else
					{
						item.setRetryCount(item.getRetryCount()+1);
						item.setLastSendTime(Calendar.getInstance().getTimeInMillis());
						sendMsgService.send(new SimpleDeliveryTarget(Constants.SEND_QUEUE_NAME),item.getCmd());
					}
				}
			}
		}
		catch (Exception e)
		{
			logger.error(e);
		}
	}
}
