package com.inc.gtc.task;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inc.gtc.domain.SysTask;
import com.inc.gtc.fire.bus.Constants;

@Component("taskReceiver")
public class TaskReceiver  {

	private static final Logger logger = Logger.getLogger(TaskReceiver.class);
	
	@Autowired
	private TaskQueue queue;
	
	private ObjectMapper mapper;
	
	public TaskReceiver()
	{
		mapper = new ObjectMapper();
	}
	
   	@JmsListener(destination = Constants.RECV_GM_TASKQUEUE_NAME)
    public void recvMessage(String data) {
   		try
   		{
   			SysTask task = mapper.readValue(data, SysTask.class);
   			queue.add(task);
   		}catch (Exception e)
   		{
   			e.printStackTrace();
   			logger.error(e);
   		}

    }

}
