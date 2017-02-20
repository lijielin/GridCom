package com.inc.gm.domain.task;

import java.util.Collection;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.inc.gm.domain.BaseObj;

/**
 * 标注点
 */
@Entity
@Table(name="task_pointnode")
public class PointNode extends BaseObj{
	private static final long serialVersionUID = 1L;
	
	public static final int NODE_TYPE_MATERIAL = 1;//物资
	public static final int NODE_TYPE_EUIP = 2;//设施
	public static final int NODE_TYPE_PERSON = 3;//队伍
	public static final int NODE_TYPE_FS = 4;//防火探测器
	public static final int NODE_TYPE_ES = 5;//环境探测器
	public static final int NODE_TYPE_BASESTATION = 6;//物联网基站
	public static final int NODE_TYPE_NULL = 7;//无类型
	
	@Id
	private String id;
	
	private String number; //编号

	private String name;// 名称

	private String equipNo;// 设备编号、号码
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PointNode parent; //所属网关

	private String remark;//备注

	private String address;
	
	private Double lng;
	private Double lat;
	private String img;
	private Integer type;
	private String contact;//联系人
	private String phone;//联系电话
	private Long createTime;//修改时间
	
	@OneToMany(orphanRemoval = true, mappedBy = "pointNode", fetch = FetchType.LAZY)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Collection<NodeDetail> details;//详情
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEquipNo() {
		return equipNo;
	}
	public void setEquipNo(String equipNo) {
		this.equipNo = equipNo;
	}
	public PointNode getParent() {
		return parent;
	}
	public void setParent(PointNode parent) {
		this.parent = parent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Collection<NodeDetail> getDetails() {
		return details;
	}
	public void setDetails(Collection<NodeDetail> details) {
		this.details = details;
	}
	
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
	public PointNode(){}
	
	public PointNode(Map<String,Object> map){
		this.fromMap(map);
	}
	
	public void fromMap(Map<String,Object> map){
		this.id = map.get("id").toString();
		if(map.containsKey("number")){
		this.number = map.get("number").toString();
		}
		if(map.containsKey("name")){
		this.name = map.get("name").toString();
		}
		if(map.containsKey("equipNo")){
			this.equipNo = map.get("equipNo").toString();
		}
		this.remark = map.get("remark").toString();
		this.address = map.get("address").toString();
		this.lng = Double.parseDouble(map.get("lng").toString());
		this.lat = Double.parseDouble(map.get("lat").toString());
		this.type = Integer.parseInt(map.get("type").toString());
		this.createTime = Long.parseLong(map.get("createTime").toString());
		if(map.containsKey("img")){
			this.img = map.get("img").toString();
		}
		if(map.containsKey("contact")){
		this.contact = map.get("contact").toString();
		}
		if(map.containsKey("phone")){
		this.phone = map.get("phone").toString();
		}
	}
	
}
