package com.inc.gm.domain.sys;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.itc.domain.BaseEntity;

@Entity
@Table(name = "sys_user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;
	public static final int SYNC_NOT = 0;
	public static final int SYNC_SUCCESS = 1;
	public static final int SYNC_ERROR = 3;
	public static final int TYPE_OPER = 1;//操作员
	public static final int TYPE_RECEIVER = 2;//短信接收

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String code;
	private String name;
	private String realName;
	private String phone;
	private String email;
	//private String post;
	private int authority;// 1 具有标注点上传权限 0
	private String img;
	@ManyToOne(fetch = FetchType.LAZY)
	private Dept dept;
	private String pwd;
	
	private Integer sync;
	
	private Integer type;

	public Integer getId() {
		return id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAuthority() {
		return authority;
	}
	
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public Dept getDept() {
		return dept;
	}
	
	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSync() {
		return sync;
	}

	public void setSync(Integer sync) {
		this.sync = sync;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	
}
