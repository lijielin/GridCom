package com.inc.gtc.fire.bus;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 报警接收通道 从MQ 
 * 来源：手机网关 基站
 * @author atian
 *
 */
@Component("messsageReceiver")
public class MessageReceiver {
	
	private static final Logger logger = Logger.getLogger(MessageReceiver.class);
	
	@Autowired
	private SmsQueue queue;
	
  @JmsListener(destination = Constants.RECV_QUEUE_NAME)
    public void recvMessage(String data) { 
	  logger.info("receive Queue Message:"+data);
	  queue.add(data);
    }
}
