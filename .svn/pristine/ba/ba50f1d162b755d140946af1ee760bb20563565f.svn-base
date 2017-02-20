package com.inc.gtc.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.inc.gtc.domain.CodecQueue;

@Component("codecQueue")
public class CodecHandleQueue implements QueueManager<CodecQueue>{
	
	private Queue<CodecQueue> queue;
	
	public CodecHandleQueue()
	{
		this.queue = new ConcurrentLinkedQueue<CodecQueue>();
	}

	public void add(CodecQueue obj) {
		queue.add(obj);
	}

	public CodecQueue get() {
		
		return queue.poll();
	}
	
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}



}
