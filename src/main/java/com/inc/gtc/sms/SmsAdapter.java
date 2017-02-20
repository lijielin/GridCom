package com.inc.gtc.sms;

import com.inc.gtc.fire.bus.msg.RecvMessage;
import com.inc.gtc.sms.resp.RecvSmsMsg;

/**
 * 短信转其他消息的转换器
 * @author atian
 *
 */
public interface SmsAdapter {

	RecvMessage convert(RecvSmsMsg sms);
}
