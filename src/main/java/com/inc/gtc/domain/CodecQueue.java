package com.inc.gtc.domain;

import javax.persistence.Id;
import javax.persistence.Table;

import com.itc.domain.BaseEntity;

/**
 * 需编码列表
 * @author inc.courser
 *
 */
@Table(name="bus_codecqueue")
public class CodecQueue extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	public static final Integer STATUS_WAIT = 0;
	public static final Integer STATUS_COMPRESSED = 3;
	public static final Integer STATUS_SKIP = 4;
	public static final int TYPE_IMG_PNG = 01;//图片
	public static final int TYPE_VIDEO_MP4 = 11;//视频
	public static final int TYPE_VOICE_AAC = 21;//音频

	@Id
	private Integer id;
	
	private String uniqueId;
	
	private String path;
	
	private Long createTime;
	
	private Integer type;
	
	private Integer status;
	
	public CodecQueue()
	{
		
	}
	
	public CodecQueue(String path,Integer type)
	{
		this.path = path;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	

}
