package com.inc.gm.dao.task;

import java.util.Collection;

import com.inc.gm.domain.task.Track;
import com.inc.gm.domain.task.TrackIndex;
import com.inc.gm.domain.task.TrackNode;
import com.itc.dao.BaseDao;

/**
 * TrackDao
 *
 * @author inc.courser
 * @version 2016-02-23 09:19:28
 */
public interface TrackDao extends BaseDao<Track>{

	/**
	 * 查询未处理的
	 * @param limitTime
	 * @return
	 */
	Collection<Track> findTrackByStatus(Long limitTime,int status);
	
	/**
	 * 索引轨迹
	 * @param track
	 * @param maxLength 索引节点最大数量
	 * @return
	 */
	Collection<TrackIndex> indexTrace(Track track,Integer maxLength);
	 
	/**
	 * 获取子节点
	 * @param track
	 * @return
	 */
	Collection<TrackNode> getChildNodes(Track track);
}
