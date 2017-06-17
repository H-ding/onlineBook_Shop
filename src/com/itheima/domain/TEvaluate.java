package com.itheima.domain;

/**
 * TEvaluate entity. @author MyEclipse Persistence Tools
 */

public class TEvaluate implements java.io.Serializable {

	// Fields

	private Integer EId;
	private Integer OId;
	private Integer UId; 
	private Integer SId;
	private Integer BId;
	private String bname;
	private String uname;
	private String sname;
	private String quality;
	private String dispatching;
	private String diservice;
	private String uevaluate;

	// Constructors

	/** default constructor */
	public TEvaluate() {
	}

	/** minimal constructor */
	public TEvaluate(Integer EId) {
		this.EId = EId;
	}

	/** full constructor */
	public TEvaluate(Integer EId, Integer OId, Integer UId, Integer SId,
			Integer BId, String bname, String uname, String sname,
			String quality, String dispatching, String diservice,
			String uevaluate) {
		this.EId = EId;
		this.OId = OId;
		this.UId = UId;
		this.SId = SId;
		this.BId = BId;
		this.bname = bname;
		this.uname = uname;
		this.sname = sname;
		this.quality = quality;
		this.dispatching = dispatching;
		this.diservice = diservice;
		this.uevaluate = uevaluate;
	}

	// Property accessors

	public Integer getEId() {
		return this.EId;
	}

	public void setEId(Integer EId) {
		this.EId = EId;
	}

	public Integer getOId() {
		return this.OId;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public Integer getSId() {
		return this.SId;
	}

	public void setSId(Integer SId) {
		this.SId = SId;
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

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getQuality() {
		return this.quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getDispatching() {
		return this.dispatching;
	}

	public void setDispatching(String dispatching) {
		this.dispatching = dispatching;
	}

	public String getDiservice() {
		return this.diservice;
	}

	public void setDiservice(String diservice) {
		this.diservice = diservice;
	}

	public String getUevaluate() {
		return this.uevaluate;
	}

	public void setUevaluate(String uevaluate) {
		this.uevaluate = uevaluate;
	}

}