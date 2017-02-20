package com.inc.gm.service.task;

import java.util.Collection;

import com.inc.gm.domain.task.Track;
import com.inc.gm.service.BaseService;


/**
 * TrackService
 *
 * @author inc.courser
 * @version 2016-02-23 09:19:29
 */
public interface TrackService extends BaseService<Track>{
	
	Collection<Track> findTrackByStatus(Long limitTime,int status);
	
	/**
	 * 建立路径点索引
	 * @param track
	 */
	void executeIndex(Track track,int maxSize);
}
