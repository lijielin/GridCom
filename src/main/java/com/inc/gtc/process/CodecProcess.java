package com.inc.gtc.process;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.domain.CodecQueue;
import com.inc.gtc.queue.CodecHandleQueue;
import com.inc.gtc.service.CodecQueueService;
import com.inc.yun.context.BeanFactory;
import com.inc.yun.core.engin.Dispatcher;
import com.inc.yun.core.engin.Executor;
import com.inc.yun.core.engin.Module;

/**
 * 音视频压缩进程
 * @author inc.courser
 *
 */
@Component("codecProcess")
public class CodecProcess  extends Dispatcher<CodecProcessExecutor> implements Module{
	
	private static final Integer IDLE_TIME = 1000*30;
	
	@Autowired
	private CodecHandleQueue queue;
	
	@Autowired
	private CodecQueueService queueService;
	
	private Long lastAccessTime;
	
	
	
	@Override
	protected Executor createExecutor() throws Exception
	{
		return (Executor) BeanFactory.getInstance().getBean(CodecProcessExecutor.class);
	}

	public void execute() {
		if (queue.isEmpty()  || (lastAccessTime!=null && (Calendar.getInstance().getTimeInMillis()-lastAccessTime)>IDLE_TIME))
		{
			queueService.getQueueByStatus(CodecQueue.STATUS_WAIT, 20).forEach(queue::add);
			lastAccessTime = Calendar.getInstance().getTimeInMillis();
		}
	}


	@Override
	public String getName() {
	
		return this.getClass().getName();
	}

	

}

