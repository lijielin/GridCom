package com.inc.gm.domain.task;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.inc.gm.domain.sys.User;
import com.itc.domain.BaseEntity;

/**
 * 巡检轨迹
 * 
 */
@Entity
@Table(name = "task_track")
public class Track extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	public static final int STATUS_UNPROCESS = 0;//未处理
	public static final int STATUS_PROCESSED = 1;//已处理

	@Id
	private String id;

	private String name;
	private Long startTime;
	private Long endTime;

	@OrderBy("sequence asc")
	@OneToMany(orphanRemoval = true, mappedBy = "track", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Collection<TrackNode> tracknNodes;
	
	private Integer status;
	
	private Long updateTime;
	
	//执行人
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;

	// 1 步行 2 驾车
	private Integer type;

	private Double distance;
	

	public Track() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Collection<TrackNode> getTracknNodes() {
		return tracknNodes;
	}

	public void setTracknNodes(Collection<TrackNode> tracknNodes) {
		this.tracknNodes = tracknNodes;
	}



	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}



	public void addNode(TrackNode node) {
		if (this.tracknNodes == null) {
			this.tracknNodes = new HashSet<TrackNode>();
		}
		node.setTrack(this);
		this.tracknNodes.add(node);
	}


	
	public Track(Map<String,Object> map) {
		try {
			this.id = map.get("id").toString();
			this.name = map.get("name").toString();
			this.startTime = Long.valueOf(map.get("startTime").toString());
			this.endTime = Long.valueOf(map.get("endTime").toString());
			if(map.get("type")!=null){
				this.type = Integer.valueOf(map.get("type").toString());
			}
			this.distance = Double.valueOf(map.get("distance").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
