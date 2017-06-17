package com.itheima.domain;

/**
 * TPay entity. @author MyEclipse Persistence Tools
 */

public class TPay implements java.io.Serializable {

	// Fields

	private Integer PId;
	private Integer MOney;
	private Integer UId;
	private String bpicture;
	private Integer BId;
	private String bname;
	private String uname;
	private Integer SId;
	private String sname;
	private Integer tcount;
	private Integer package_;
	private String payState;
	private String uaddress;

	// Constructors

	/** default constructor */
	public TPay() {
	}

	/** minimal constructor */
	public TPay(Integer PId) {
		this.PId = PId;
	}

	/** full constructor */
	public TPay(Integer PId, Integer MOney, Integer UId, String bpicture,
			Integer BId, String bname, String uname, Integer SId, String sname,
			Integer tcount, Integer package_, String payState, String uaddress) {
		this.PId = PId;
		this.MOney = MOney;
		this.UId = UId;
		this.bpicture = bpicture;
		this.BId = BId;
		this.bname = bname;
		this.uname = uname;
		this.SId = SId;
		this.sname = sname;
		this.tcount = tcount;
		this.package_ = package_;
		this.payState = payState;
		this.uaddress = uaddress;
	}

	// Property accessors

	public Integer getPId() {
		return this.PId;
	}

	public void setPId(Integer PId) {
		this.PId = PId;
	}

	public Integer getMOney() {
		return this.MOney;
	}

	public void setMOney(Integer MOney) {
		this.MOney = MOney;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getBpicture() {
		return this.bpicture;
	}

	public void setBpicture(String bpicture) {
		this.bpicture = bpicture;
	}

	public Integer getBId() {
		return this.BId;
	}

	public void setBId(Integer BId) {
		this.BId = BId;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getTcount() {
		return this.tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

	public Integer getPackage_() {
		return this.package_;
	}

	public void setPackage_(Integer package_) {
		this.package_ = package_;
	}

	public String getPayState() {
		return this.payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

	public String getUaddress() {
		return this.uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

}