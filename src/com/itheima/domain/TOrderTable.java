package com.itheima.domain;

/**
 * TOrderTable entity. @author MyEclipse Persistence Tools
 */

public class TOrderTable implements java.io.Serializable {

	// Fields

	private Integer OId;
	private TSeller TSeller;
	private TBook TBook;
	private Integer UId;
	private String bpicture;
	private String uname;
	private String sname;
	private Integer tcount;
	private Integer package_;
	private String ostate;
	private String logistics;

	// Constructors

	/** default constructor */
	public TOrderTable() {
	}

	/** minimal constructor */
	public TOrderTable(Integer OId) {
		this.OId = OId;
	}

	/** full constructor */
	public TOrderTable(Integer OId, TSeller TSeller, TBook TBook, Integer UId,
			String bpicture, String uname, String sname, Integer tcount,
			Integer package_, String ostate, String logistics) {
		this.OId = OId;
		this.TSeller = TSeller;
		this.TBook = TBook;
		this.UId = UId;
		this.bpicture = bpicture;
		this.uname = uname;
		this.sname = sname;
		this.tcount = tcount;
		this.package_ = package_;
		this.ostate = ostate;
		this.logistics = logistics;
	}

	// Property accessors

	public Integer getOId() {
		return this.OId;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
	}

	public TBook getTBook() {
		return this.TBook;
	}

	public void setTBook(TBook TBook) {
		this.TBook = TBook;
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

	public String getOstate() {
		return this.ostate;
	}

	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	public String getLogistics() {
		return this.logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

}