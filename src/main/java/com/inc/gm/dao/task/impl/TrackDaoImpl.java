package com.inc.gm.dao.task.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.inc.gm.dao.GmBaseDaoImpl;
import com.inc.gm.dao.task.TrackDao;
import com.inc.gm.domain.task.Track;
import com.inc.gm.domain.task.TrackIndex;
import com.inc.gm.domain.task.TrackNode;
import com.inc.gm.utils.GeoUtils;

/**
 * TrackDao
 *
 * @author inc.courser
 * @version 2016-02-23 09:19:29
 */
@Repository("trackDao")
public class TrackDaoImpl extends GmBaseDaoImpl<Track> implements TrackDao{

	public Collection<Track> findTrackByStatus(Long limitTime,int status)
	{
		Criteria criteria = getSession().createCriteria(Track.class);
		criteria.add(Restrictions.ge("updateTime", limitTime)).add(Restrictions.eq("status", status));
		//criteria.add(Restrictions.eq("id", "cdc95315fbfc4c6cb0bfb4259c522dcf"));
		return criteria.list();
		
	}
	
	public int getNodesSize(Track track)
	{
		Criteria criteria = getSession().createCriteria(TrackNode.class);
		criteria.add(Restrictions.eq("track", track));
		criteria.setProjection(Projections.rowCount());
		return Integer.parseInt(criteria.uniqueResult().toString());
	}
	
	public 	Collection<TrackIndex> indexTrace(Track track,Integer maxNodeSize)
	{
		Collection<TrackIndex> locs = new ArrayList<TrackIndex>();
		int ns = getNodesSize(track);
		if (ns>maxNodeSize)
		{
			double distance = track.getDistance()*1000;
			int avgDistance = (int)(distance/maxNodeSize);//平均索引距离
			SQLQuery query=getSession().createSQLQuery("select lng,lat,id,type,track_id,sequence from task_tracknode where track_id=?  order by sequence asc");  
	        query.setString(0, track.getId());  
	        TrackIndex li = null;
	        double[] tmp = new double[2];
	        ScrollableResults sr=query.scroll();  
	       	while (sr.next())
	       	{
	           if (li==null)
	           {
	        	   li = new TrackIndex((String)sr.get(4),(Integer)sr.get(2),(Integer)sr.get(3),(double)sr.get(0),(double)sr.get(1));
	        	   locs.add(li);
	           }
	           else
	           {
					tmp[0]=(double)sr.get(0);
					tmp[1]=(double)sr.get(1);
					if (GeoUtils.distance(tmp[0], tmp[1],li.getLng(),li.getLat())>=avgDistance
							||  ((Integer)sr.get(3))>TrackNode.TRACKNODETYPE_COMMON)
					{
						 li = new TrackIndex((String)sr.get(4),(Integer)sr.get(2),(Integer)sr.get(3),(double)sr.get(0),(double)sr.get(1));
			        	 locs.add(li);
					}
	           }
	      }  
		}
		else
		{
			Collection<TrackNode> nodes = getChildNodes(track);
			for (TrackNode node : nodes)
			{
				 locs.add(new TrackIndex(track.getId(),node.getId(),node.getType(),node.getLng(),node.getLat()));
			}
		}
		return locs;
	}
	
	public Collection<TrackNode> getChildNodes(Track track)
	{
		Criteria criteria = getSession().createCriteria(TrackNode.class);
		criteria.add(Restrictions.eq("track", track));
		return criteria.list();
	}
	
}
