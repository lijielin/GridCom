package com.inc.gtc.fire.bus.process;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.buf.SendBuffer;
import com.inc.gtc.fire.bus.buf.SendItem;
import com.inc.gtc.fire.bus.msg.Message;
import com.inc.gtc.fire.bus.msg.SuccessMessage;
import com.inc.yun.core.engin.Boot;

@Component("replyProcessor")
@Boot(1)
public class ReplyProcessor  implements Processor{
	
	private Logger logger = Logger.getLogger(ReplyProcessor.class);
	
	@Autowired
	private SendBuffer<SendItem> buf;

	@Override
	public boolean handle(Message arg) {
		if (arg instanceof SuccessMessage)
		{
			SuccessMessage  msg = (SuccessMessage)arg;
			if (msg.getSuccessful().equals("executecmd"))
			{
				logger.info("remove pm from sendbuffer:"+msg.getPm());
				buf.remove(msg.getPm());
			}
			return true;
		}
		return false;
		
	}

}
