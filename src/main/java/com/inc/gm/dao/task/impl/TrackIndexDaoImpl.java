package com.inc.gm.dao.task.impl;

import org.springframework.stereotype.Repository;

import com.inc.gm.dao.GmBaseDaoImpl;
import com.inc.gm.dao.task.TrackIndexDao;
import com.inc.gm.domain.task.TrackIndex;

/**
 * TrackIndexDao
 *
 * @author inc.courser
 * @version 2016-02-26 09:58:53
 */
@Repository("trackIndexDao")
public class TrackIndexDaoImpl extends GmBaseDaoImpl<TrackIndex> implements TrackIndexDao{

}
