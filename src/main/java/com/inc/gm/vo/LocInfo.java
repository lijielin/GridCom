package com.inc.gm.vo;

public class LocInfo implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer t;
	
	private double[] pos;
	
	public LocInfo()
	{
		
	}
	
	public LocInfo(Integer id,Integer t,double[] pos)
	{
		this.id = id;
		this.t = t;
		this.pos = pos;
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getT() {
		return t;
	}

	public void setT(Integer t) {
		this.t = t;
	}

	public double[] getPos() {
		return pos;
	}

	public void setPos(double[] pos) {
		this.pos = pos;
	}
	
	
}	
