package com.inc.gtc.fire.bus.buf;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component("executeCmdSendBuf")
public class ExecuteSendBuf implements SendBuffer<SendItem> {

	private ConcurrentHashMap<String,SendItem> depot;
	
	public ExecuteSendBuf()
	{
		depot = new ConcurrentHashMap<String,SendItem>();
	}
	
	@Override
	public void add(SendItem item) {
		depot.put(item.getCmd().getPm(), item);
	}

	@Override
	public void remove(String id) {
		depot.remove(id);
		
	}

	@Override
	public Collection<SendItem> getItems() {
		return depot.values();
	}
}
