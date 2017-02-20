package com.inc.gtc.fire.vo;
/**
 * @author itc.tzj
 * @version 创建时间：2011-8-3 下午03:37:45 
 */
public class FireDataVO {
	private String m;
	private String s;
	private String cd;
	private String d;
	private String cr;
	private String glass;
	private String ec;
	private String ed;
	private String ip;
	private String content;
	
	public FireDataVO() {
		super();
	}
	public FireDataVO(String m, String s, String cd, String d, String cr,
			String glass, String ec, String ed,String ip,String content) {
		super();
		this.m = (m!=null)?m.trim():null;
		this.s = (s!=null)?s.trim():null;
		this.cd = (cd!=null)?cd.trim():null;
		this.d = (d!=null)?d.trim():null;
		this.cr = (cr!=null)?cr.trim():null;
		this.glass = (glass!=null)?glass.trim():null;
		this.ec = (ec!=null)?ec.trim():null;
		this.ed = (ed!=null)?ed.trim():null;
		this.ip = (ip!=null)?ip.trim():null;
		this.content = (content!=null)?content.trim():null;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public String getCd() {
		return cd;
	}
	public void setCd(String cd) {
		this.cd = cd;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getCr() {
		return cr;
	}
	public void setCr(String cr) {
		this.cr = cr;
	}
	public String getGlass() {
		return glass;
	}
	public void setGlass(String glass) {
		this.glass = glass;
	}
	public String getEc() {
		return ec;
	}
	public void setEc(String ec) {
		this.ec = ec;
	}
	public String getEd() {
		return ed;
	}
	public void setEd(String ed) {
		this.ed = ed;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
