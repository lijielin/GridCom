package com.inc.gm.service.task.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.gm.dao.task.TrackDao;
import com.inc.gm.domain.task.Track;
import com.inc.gm.domain.task.TrackIndex;
import com.inc.gm.service.BaseServiceImpl;
import com.inc.gm.service.task.TrackIndexService;
import com.inc.gm.service.task.TrackService;
import com.inc.gtc.fire.err.ProcessException;


/**
 * TrackService
 *
 * @author inc.courser
 * @version 2016-02-23 09:19:29
 */
@Service("trackService")
public class TrackServiceImpl extends BaseServiceImpl<Track,TrackDao> implements TrackService{
	
	
	@Autowired
	private TrackIndexService indexService;

	@Override
	@Resource(name="trackDao")
	public void setDao(TrackDao dao)
	{
		super.setDao(dao);
	}

	public Collection<Track> findTrackByStatus(Long limitTime,int status)
	{
		return this.getDao().findTrackByStatus(limitTime, status);
	}

	public 	void executeIndex(Track track,int maxSize) 
	{
		try
		{
			Collection<TrackIndex> locs = this.getDao().indexTrace(track, maxSize);
			locs.forEach(o->indexService.save(o));
			track.setStatus(Track.STATUS_PROCESSED);
			super.save(track);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new ProcessException(e);
		}
		
	}

}
