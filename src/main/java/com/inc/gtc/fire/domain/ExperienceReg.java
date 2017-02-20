package com.inc.gtc.fire.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author itc.tzj
 * @version 创建时间：2012-3-27 下午03:09:42
 * 体验登记
 */
@Entity
public class ExperienceReg extends com.itc.domain.Entity{

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	/**姓名（提示为：请输入您的真实姓名）*/
	private String name;
	/**单位（提示为：请输入真实有效的单位实名）*/
	private String companyName;
	/**手机（提示为：请输入真实有效的手机号码，此号码将用于模拟演示验证登录和预警短信接收）*/
	private String phone;
	/**邮箱（提示为：请录入有效邮箱地址，我们将向您发送相关资料。）*/
	private String email;
	/**QQ号码（提示为：请录入有效QQ号码，方便我们与你沟通联系）*/
	private String qq;
	/**点火次数*/
	private Integer num;
	/**手机验证码*/
	private String valideCode;
	private Date applyDate;
	private Date sendDate;
	/**状态,默认0，1表示用户请求发验证码，2表示短信平台已经发了验证码，3表示用户已经通过验证*/
	private Integer state;
	

	public ExperienceReg() {
		super();
		this.num = 0;
		this.state = 0;
	}

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getValideCode() {
		return valideCode;
	}

	public void setValideCode(String valideCode) {
		this.valideCode = valideCode;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
}
