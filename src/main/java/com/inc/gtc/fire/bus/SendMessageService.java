package com.inc.gtc.fire.bus;

import com.inc.gtc.fire.vo.SendBeanVO;
import com.inc.yun.bridge.DeliveryTarget;

public interface SendMessageService {

	void sendMessage(SendBeanVO bean);
	
	void send(DeliveryTarget target, Object obj);
}
