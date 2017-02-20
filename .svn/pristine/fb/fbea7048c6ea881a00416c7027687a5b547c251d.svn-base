package com.inc.gtc.domain;

import javax.persistence.Id;
import javax.persistence.Table;

import com.itc.domain.BaseEntity;

@Table(name="sys_task")
public class SysTask extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	public final static Integer TASKTYPE_CREATEDB = 1;//创建基本数据库
	public final static Integer TASKTYPE_MIGRATE = 2;//从智慧森林迁移数据
	public final static Integer RESULT_WAIT = 0;
	public final static Integer RESULT_ERROR= 3;
	public final static Integer RESULT_SUCCESS = 1;
	
	@Id
	private Integer id;
	
	private Integer unit_id;
	
	private Integer type;
	
	private Long createTime;
	
	private Long executeTime;
	
	private Integer result;
	
	private String errorInfo;
	
	private String param;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(Integer unit_id) {
		this.unit_id = unit_id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Long executeTime) {
		this.executeTime = executeTime;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	

	

}
