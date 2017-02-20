package com.inc.gm.process;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inc.gtc.domain.Unit;
import com.inc.gtc.service.UnitService;
import com.inc.yun.context.BeanFactory;
import com.inc.yun.core.engin.DefaultExecutorImpl;
import com.inc.yun.core.engin.Module;

/**
 * 建立轨迹采样
 * @author inc.courser
 *
 */
@Component("trackProcessor")
public class TrackProcessor  extends DefaultExecutorImpl implements Module{
	
	private Logger logger = Logger.getLogger(TrackProcessor.class);
	
	@Autowired
	private UnitService unitService;
	
	private Map<String,TrackExecutor> executorMap;
	
	private Long lastRefreshTime;
	
	private static long checkInterval = 1000*60*10;
	
	public TrackProcessor()
	{
		executorMap = new HashMap<String,TrackExecutor>();
	}
	
	@Override
	public void initialize() {
		super.initialize();
		this.setLoopInterval(60*1000*5);
	}
	

	public void execute()
	{
		if ((Calendar.getInstance().getTimeInMillis()-lastRefreshTime)>checkInterval)
		{
			Collection<Unit> units = unitService.loadAll();

			Collection<String> recyle = new ArrayList<String>();
			executorMap.forEach((k,v)->{
				if (!units.contains(k))
				{
					stopExecutor(k);
				}
			});
			recyle.forEach(o->stopExecutor(o));
			for (Unit unit : units)
			{
				if (!executorMap.containsKey(unit.getCode()))
				{
					executorMap.put(unit.getCode(), startExecutor(unit));
				}
			}
		}
		
	}

	@Override
	public void end() {
		super.end();
		executorMap.forEach((k,v)->v.end());
	}

	@Override
	public void start() {
		lastRefreshTime = Calendar.getInstance().getTimeInMillis();
		super.start();
		Collection<Unit> units = unitService.loadAll();
		for (Unit unit : units)
		{
			if (unit.getCode().equals("gm"))
			{
			if (!executorMap.containsKey(unit.getCode()))
			{
				executorMap.put(unit.getCode(), startExecutor(unit));
			}
			}
		}
	}
	
	private void stopExecutor(String unitCode)
	{
		logger.info("stop unit executor "+unitCode);
		TrackExecutor executor = executorMap.remove(unitCode);
		executor.end();
	}
	
	private TrackExecutor startExecutor(Unit unit)
	{
		logger.info("start unit executor "+unit.getCode());
		TrackExecutor executor = (TrackExecutor)BeanFactory.getInstance().getBean(TrackExecutor.class);
		executor.initialize();
		executor.setUnit(unit);
		executor.start();
		return executor;
	}
}
