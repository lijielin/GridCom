package com.inc.gtc.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.domain.SysTask;
import com.inc.gtc.service.MigrateService;
import com.inc.yun.core.engin.DefaultExecutorImpl;
import com.inc.yun.core.engin.Module;

@Component("taskExecutor")
public class TaskExecutor extends DefaultExecutorImpl implements Module{
	
	private static final Logger logger = Logger.getLogger(TaskExecutor.class);

	@Autowired
	private TaskQueue queue;
	
	@Autowired
	private MigrateService migrateService; 
	
	
	public void execute(Object...args)
	{
		SysTask task = queue.get();
		if (task!=null)
		{
			logger.info("execute task:"+task.getType());
			migrateService.executeTask(task);
		}
	}
	


}
