package com.inc.gtc.fire.bus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.fire.bus.process.ProcessChain;
import com.inc.gtc.fire.bus.process.Processor;
import com.inc.yun.context.BeanFactory;
import com.inc.yun.core.engin.Boot;
import com.inc.yun.core.engin.Dispatcher;
import com.inc.yun.core.engin.Executor;
import com.inc.yun.core.engin.Module;

@Component("messageProcessor")
public class MessageProcessor extends Dispatcher<MessageProcessExecutor> implements Module{
	
	@Autowired
	private ProcessChain chain;
	
	
	@Override
	protected Executor createExecutor() throws Exception
	{
		return (Executor) BeanFactory.getInstance().getBean(MessageProcessExecutor.class);
	}
	
	@Override
	public void initialize() {
		
		super.initialize();
		Collection<Processor> processors = BeanFactory.getInstance().getBeans(Processor.class);
		List<ProcessWrapper> wrappers = new ArrayList<ProcessWrapper>(); 
		processors.forEach(o->{
				Boot bt = o.getClass().getAnnotation(Boot.class);
			if (bt!=null)
			{
				wrappers.add(new ProcessWrapper(o,bt.value()));
			}
			else
			{
				wrappers.add(new ProcessWrapper(o));
			}
		});
	    Collections.sort(wrappers, new Comparator<ProcessWrapper>() {
            public int compare(ProcessWrapper arg0, ProcessWrapper arg1) {
            	if (arg0.bootSeq==arg1.bootSeq)
            		return 0;
            	else if (arg0.bootSeq>arg1.bootSeq)
            		return 1;
            	else
            		return -1;
            }
        });
	   wrappers.forEach(o->{chain.add(o.processor);});
	}
}
class ProcessWrapper
{
	public Processor processor;
	/**
	 * 启动顺序
	 */
	public int bootSeq;
	
	public ProcessWrapper(Processor processor,int seq)
	{
		this.processor = processor;
		this.bootSeq = seq;
	}
	
	public ProcessWrapper(Processor processor)
	{
		this.processor = processor;
		this.bootSeq = Integer.MAX_VALUE;
	}
}
