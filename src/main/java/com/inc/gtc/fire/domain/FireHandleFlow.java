package com.inc.gtc.fire.domain;


import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="risk_firehandleflow")
public class FireHandleFlow extends com.itc.domain.Entity{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;	
	
	@ManyToOne
	private District district;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<FireSensor> sensors;
	
	/**当前所处的处置步骤**/
	@ManyToOne
	private DisposalStep step;
	
	private Date addTime;
	
	private String content;
	/**火情1,火险2,火灾3*/
	private Integer type;
	/**提示信息*/
	@ManyToOne
	private Tips tips;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}

	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setStep(DisposalStep step) {
		this.step = step;
	}
	public DisposalStep getStep() {
		return step;
	}
	public void setSensors(Set<FireSensor> sensors) {
		this.sensors = sensors;
	}
	public Set<FireSensor> getSensors() {
		return sensors;
	}
	
	public void addFireSensor(FireSensor sensor)
	{
		if (sensors==null)
			sensors = new HashSet<FireSensor>();
		sensors.add(sensor);
	}
	
	public void addFireSensor(Collection<FireSensor> listSensor)
	{
		if (sensors==null)
			sensors = new HashSet<FireSensor>();
		sensors.addAll(listSensor);
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Tips getTips() {
		return tips;
	}
	public void setTips(Tips tips) {
		this.tips = tips;
	}
	
}
