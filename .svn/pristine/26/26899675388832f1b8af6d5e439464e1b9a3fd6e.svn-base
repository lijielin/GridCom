package com.inc.gtc.domain;

import javax.persistence.Id;
import javax.persistence.Table;

import com.itc.domain.BaseEntity;

@Table(name="bus_ptnode")
public class PtNode extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	
	private String keyword;
	
	private String unit;

	public Integer getId() {
		return id;
	}
	
	public PtNode()
	{
		
	}
	
	public PtNode(String keyword,String unit)
	{
		this.keyword = keyword;
		this.unit = unit;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
 
}
