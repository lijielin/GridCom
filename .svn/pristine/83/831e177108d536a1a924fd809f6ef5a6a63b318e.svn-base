package com.inc.gtc.fire.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author itc.tzj
 * @version 创建时间：2013-5-21 
 * 火险提示信息
 * 	1.探测器报警
 * 	2.平台预警（短信发出）
 * 	3.护林员现场确认（短信回复）
 * 	4.消警或转火险预案
 * 	1.平台报警（短信发出）
 * 	2.启动X级预案响应
 */
@Entity
@Table(name="risk_tips")
public class Tips extends com.itc.domain.Entity{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**名称**/
	private String name;
	
	/**顺序**/
	private Integer step;
	
	/**代码**/
	private String code;
	/**火情1,火险2,火灾3*/
	private Integer type;
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getStep() {
		return step;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	
}
