package com.inc.gtc;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.inc.gtc.domain.SysTask;
import com.inc.gtc.fire.util.GsonUtils;
import com.inc.gtc.task.TaskExecutor;
import com.inc.yun.cfg.ConfigLoader;
import com.inc.yun.context.BeanFactory;

public class ExecutorTest {


	
	public static void main(String[] args) {
		ConfigLoader loader = (ConfigLoader)BeanFactory.getInstance().getBean(ConfigLoader.class);
		loader.initialize();
	
		TaskExecutor  executor = (TaskExecutor)BeanFactory.getInstance().getBean(TaskExecutor.class);
		executor.initialize();
		executor.start();
		///sendJms();
	}
	
	private static void sendJms()
	{
		JmsTemplate jt = (JmsTemplate)BeanFactory.getInstance().getBean("jmsQueueTemplate");
		jt.send("com.inc.gm.task", new MessageCreator() {
		      @Override
		      public Message createMessage(Session session) throws JMSException {
		    	  SysTask st = new SysTask();
		    	  st.setType(SysTask.TASKTYPE_CREATEDB);
		    	  st.setUnit_id(123);
		    	return jt.getMessageConverter().toMessage(st, session);
		    	 
		      }
		    });
	}
}
