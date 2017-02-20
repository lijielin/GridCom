package com.inc.gm.domain.task;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.inc.gm.domain.BaseObj;
@Entity
@Table(name="task_tracknode")
public class TrackNode extends BaseObj {

	private static final long serialVersionUID = 1L;
	
	public static final Integer TRANSCODE_WAIT = 0;
	
	public static final int TRACKNODETYPE_COMMON = 0;
	public static final int TRACKNODETYPE_IMG = 1;
	public static final int TRACKNODETYPE_VOICE = 2;
	public static final int TRACKNODETYPE_MEDIA = 3;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Double lng;

	private Double lat;

	private String descri;
	
	private String img;

	
	private String voice;

	
	private String media;
	

	private Integer type;

	@ManyToOne
	private Track track;
	
	@Column
	private Integer transCodeStatus = TRANSCODE_WAIT;


	private Integer locType;

	private Integer cordType;

	private Integer sequence;
	private Integer isMilepost;
	
	public TrackNode(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}



	public Integer getLocType() {
		return locType;
	}

	public void setLocType(Integer locType) {
		this.locType = locType;
	}

	public Integer getCordType() {
		return cordType;
	}

	public void setCordType(Integer cordType) {
		this.cordType = cordType;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getIsMilepost() {
		return isMilepost;
	}

	public void setIsMilepost(Integer isMilepost) {
		this.isMilepost = isMilepost;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

	
	public TrackNode(Map<String,Object> map){
		this.id = Integer.parseInt(map.get("id").toString());
		this.lng = Double.parseDouble(map.get("lng").toString());
		this.lat = Double.parseDouble(map.get("lat").toString());
		if(map.containsKey("img")){
			this.img = map.get("img").toString();
		}
		if(map.containsKey("voice")){
			this.voice = map.get("voice").toString();
		}
		if(map.containsKey("media")){
			this.media = map.get("media").toString();
		}
		this.type = Integer.parseInt(map.get("type").toString());
		if(map.containsKey("locType")){
			this.locType = Integer.parseInt(map.get("locType").toString());
		}
		this.sequence = Integer.parseInt(map.get("sequence").toString());
		if(map.containsKey("isMilepost")){
		this.isMilepost = Integer.parseInt(map.get("isMilepost").toString());
		}
	}

	public Integer getTransCodeStatus() {
		return transCodeStatus;
	}

	public void setTransCodeStatus(Integer transCodeStatus) {
		this.transCodeStatus = transCodeStatus;
	}

}
