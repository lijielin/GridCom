package com.inc.gm.process;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.inc.gm.domain.task.Track;
import com.inc.gm.service.task.TrackService;
import com.inc.gmgrid.db.DbToken;
import com.inc.gtc.domain.Unit;
import com.inc.yun.core.engin.DefaultExecutorImpl;
import com.itc.Utils;

@Component("trackExecutor")
@Scope("prototype")
public class TrackExecutor extends DefaultExecutorImpl{

	private Logger logger = Logger.getLogger(TrackExecutor.class);

	@Autowired
	private TrackService trackService;
	

	private Unit unit;
	
	@Override
	public void initialize()
	{
		this.setLoopInterval(60*1000);
	}


	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	
	
	@Override
	public void execute(Object...args) {
		try
		{
			DbToken.set(unit.getCode());
			try
			{
				Date limitTime = Utils.addTimeByMinutes(Calendar.getInstance().getTime(), -60);
				Collection<Track> tracks = this.trackService.findTrackByStatus(limitTime.getTime(),Track.STATUS_UNPROCESS);
				for (Track track: tracks)
				{
					try
					{
						logger.info("process track "+track.getId());
						trackService.executeIndex(track, 350);
					}
					catch (Exception e)
					{
						e.printStackTrace();
						continue;
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				DbToken.set(null);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(e);
		}
	
	}
	
}
