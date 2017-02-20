package com.inc.gtc.sms;

import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.msg.RecvMessage;
import com.inc.gtc.sms.resp.RecvSmsMsg;

@Component
public class DefaultSmsAdapter implements SmsAdapter{

	@Override
	public RecvMessage convert(RecvSmsMsg sms) {
		RecvMessage  msg = new RecvMessage();
		msg.setContent(sms.getText());
		msg.setFrom(sms.getMobile());
		msg.setCreateTime(sms.getReplyTime().getTime());
		return msg;
	}

}
