package com.inc.gtc.fire.bus.process;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.msg.Message;
import com.inc.gtc.fire.bus.msg.SendMessage;

@Component("processChain")
public class ProcessChainImpl implements ProcessChain{
	
	private static Logger logger = Logger.getLogger(ProcessChainImpl.class);
	
	private Collection<Processor> processors; 
	
	public ProcessChainImpl()
	{
		this.processors = new ArrayList<Processor>();
	}

	@Override
	public SendMessage process(Message msg) {
		SendMessage sm = null;
		for (Processor procesor : processors)
		{
			try
			{
				if ( procesor.handle(msg))
				{
					break;
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				logger.error(e);
				continue;
			}
		}
		return sm;
	}

	@Override
	public void add(Processor processor) {
		processors.add(processor);
		
	}

}
