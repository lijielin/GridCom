package com.inc.gm.domain.task;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itc.domain.BaseEntity;

@Entity
@Table(name="task_trackindex")
public class TrackIndex extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String track_id;
	
	
	private Integer node_id;

	private Integer type;
	
	private Double lng;
	
	private Double lat;
	
	public TrackIndex()
	{
		
	}
	
	public TrackIndex(String trackId,Integer nodeId,Integer type,Double lng,Double lat)
	{
		this.track_id = trackId;
		this.node_id = nodeId;
		this.type = type;
		this.lng = lng;
		this.lat = lat;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public String getTrack_id() {
		return track_id;
	}

	public void setTrack_id(String track_id) {
		this.track_id = track_id;
	}

	public Integer getNode_id() {
		return node_id;
	}

	public void setNode_id(Integer node_id) {
		this.node_id = node_id;
	}
	
	
}
