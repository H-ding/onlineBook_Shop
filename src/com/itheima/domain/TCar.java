package com.itheima.domain;

/**
 * TCar entity. @author MyEclipse Persistence Tools
 */

public class TCar implements java.io.Serializable {

	// Fields

	private Integer CId;
	private TBook TBook;
	private Integer UId;
	private String bname;
	private Integer bnumber;
	private String bpicture;
	private Integer package_;
	private Integer shouldpay;
	private String introduce;

	// Constructors

	/** default constructor */
	public TCar() {
	}

	/** minimal constructor */
	public TCar(Integer CId) {
		this.CId = CId;
	}

	/** full constructor */
	public TCar(Integer CId, TBook TBook, Integer UId, String bname,
			Integer bnumber, String bpicture, Integer package_,
			Integer shouldpay, String introduce) {
		this.CId = CId;
		this.TBook = TBook;
		this.UId = UId;
		this.bname = bname;
		this.bnumber = bnumber;
		this.bpicture = bpicture;
		this.package_ = package_;
		this.shouldpay = shouldpay;
		this.introduce = introduce;
	}

	// Property accessors

	public Integer getCId() {
		return this.CId;
	}

	public void setCId(Integer CId) {
		this.CId = CId;
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

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getBnumber() {
		return this.bnumber;
	}

	public void setBnumber(Integer bnumber) {
		this.bnumber = bnumber;
	}

	public String getBpicture() {
		return this.bpicture;
	}

	public void setBpicture(String bpicture) {
		this.bpicture = bpicture;
	}

	public Integer getPackage_() {
		return this.package_;
	}

	public void setPackage_(Integer package_) {
		this.package_ = package_;
	}

	public Integer getShouldpay() {
		return this.shouldpay;
	}

	public void setShouldpay(Integer shouldpay) {
		this.shouldpay = shouldpay;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

}