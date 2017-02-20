package com.inc.gm.domain.task;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.inc.gm.domain.BaseObj;

/**
 * 标注点详情
 */
@Entity
@Table(name="task_nodedetail")
public class NodeDetail extends BaseObj{
	private static final long serialVersionUID = 1L;
	@Id
    private String id;
    private String name;// 名称
    private String number;//数量
    private String unit;//单位
    
    @ManyToOne
	private PointNode pointNode;
    
    
    
	public PointNode getPointNode() {
		return pointNode;
	}
	public void setPointNode(PointNode pointNode) {
		this.pointNode = pointNode;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
    
	public NodeDetail(){}
	
	public NodeDetail(Map<String,Object> map,PointNode node){
		this.id = map.get("id").toString();
		this.name = map.get("name").toString();
		this.number = map.get("number").toString();
		if(map.containsKey("unit"))
		this.unit = map.get("unit").toString();
		this.pointNode = node;
	}
    
}
