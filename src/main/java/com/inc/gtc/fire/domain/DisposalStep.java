package com.inc.gtc.fire.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author itc.chenzhi
 * @version 创建时间：2013-5-17 上午10:37:08
 * 火险处置步骤定义
 */
@Entity
@Table(name="risk_disposalstep")
public class DisposalStep extends com.itc.domain.Entity{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**步骤名称**/
	private String name;
	
	/**步骤的顺序**/
	private Integer step;
	
	/**步骤代码**/
	private String code;
	
	@Lob
	private String template;

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

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplate() {
		return template;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getStep() {
		return step;
	}
	
	
}
