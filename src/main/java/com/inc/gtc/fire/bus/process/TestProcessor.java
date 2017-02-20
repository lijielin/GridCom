package com.inc.gtc.fire.bus.process;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.SendMessageService;
import com.inc.gtc.fire.bus.msg.Message;
import com.inc.gtc.fire.bus.msg.RecvMessage;
import com.inc.gtc.fire.vo.SendBeanVO;
import com.inc.yun.core.engin.Boot;

/**
 * 短信平台测试
 * @author courser
 *
 */
@Component("testProcessor")
@Boot(1)
public class TestProcessor implements Processor{
	
	private static Logger logger = Logger.getLogger(TestProcessor.class);

	private static final String TEST_CONTENT = "callincar2406";
	
	@Autowired
	private SendMessageService sendMessageService;

	@Override
	public boolean handle(Message arg) {
		if (arg instanceof RecvMessage)
		{
			RecvMessage msg = (RecvMessage)arg;
			if (msg.getContent().trim().equals(TEST_CONTENT))
			{
				logger.info("receive message:"+msg.getContent()+" from "+msg.getFrom());
				SendBeanVO s = new SendBeanVO();
				s.setType(SendBeanVO.SENDMSG_TYPE_SMS);
				s.setTarget(msg.getFrom());
				s.setContent("测试");
				sendMessageService.sendMessage(s);
				return true;
			}
		}
		return false;
	}
	


}
