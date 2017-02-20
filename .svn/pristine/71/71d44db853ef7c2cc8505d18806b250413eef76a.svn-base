package com.inc.gtc.fire.bus.process;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.msg.Message;
import com.inc.gtc.fire.bus.msg.RecvMessage;
import com.inc.gtc.fire.domain.ReplyMessage;
import com.inc.gtc.fire.service.ReplyMessageService;
import com.inc.yun.core.engin.Boot;

/**
 * 保存历史
 */
@Component("historyProcessor")
@Boot(2)
public class HistoryProcessor  implements Processor{
	
	private static Logger logger = Logger.getLogger(HistoryProcessor.class);
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Autowired
	private ReplyMessageService msgService;
	
	
	@Override
	public boolean handle(Message arg) {
		if (arg instanceof RecvMessage)
		{
			RecvMessage msg = (RecvMessage)arg;
			logger.info("receive message:"+msg.getContent()+" from "+msg.getFrom());
			ReplyMessage rm = new ReplyMessage();
			rm.setMobileNumber(msg.getFrom());
			rm.setSmsContent(msg.getContent());
			rm.setSendTime(format.format(Calendar.getInstance().getTime()));
			msgService.save(rm);
		}
		return false;
	}

}
