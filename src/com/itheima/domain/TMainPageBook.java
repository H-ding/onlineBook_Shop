package com.itheima.domain;

/**
 * TMainPageBook entity. @author MyEclipse Persistence Tools
 */

public class TMainPageBook implements java.io.Serializable {

	// Fields

	private Integer mpId;
	private TSeller TSeller;
	private Integer BId;
	private String bpicture;
	private String bname;
	private String bauthor;
	private Integer bprice;
	private Integer bnumber;
	private String btype;
	private String bdate;
	private String bpress;
	private String bintroduce;

	// Constructors

	/** default constructor */
	public TMainPageBook() {
	}

	/** minimal constructor */
	public TMainPageBook(Integer mpId) {
		this.mpId = mpId;
	}

	/** full constructor */
	public TMainPageBook(Integer mpId, TSeller TSeller, Integer BId,
			String bpicture, String bname, String bauthor, Integer bprice,
			Integer bnumber, String btype, String bdate, String bpress,
			String bintroduce) {
		this.mpId = mpId;
		this.TSeller = TSeller;
		this.BId = BId;
		this.bpicture = bpicture;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.bnumber = bnumber;
		this.btype = btype;
		this.bdate = bdate;
		this.bpress = bpress;
		this.bintroduce = bintroduce;
	}

	// Property accessors

	public Integer getMpId() {
		return this.mpId;
	}

	public void setMpId(Integer mpId) {
		this.mpId = mpId;
	}

	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
	}

	public Integer getBId() {
		return this.BId;
	}

	public void setBId(Integer BId) {
		this.BId = BId;
	}

	public String getBpicture() {
		return this.bpicture;
	}

	public void setBpicture(String bpicture) {
		this.bpicture = bpicture;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return this.bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public Integer getBprice() {
		return this.bprice;
	}

	public void setBprice(Integer bprice) {
		this.bprice = bprice;
	}

	public Integer getBnumber() {
		return this.bnumber;
	}

	public void setBnumber(Integer bnumber) {
		this.bnumber = bnumber;
	}

	public String getBtype() {
		return this.btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBdate() {
		return this.bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBpress() {
		return this.bpress;
	}

	public void setBpress(String bpress) {
		this.bpress = bpress;
	}

	public String getBintroduce() {
		return this.bintroduce;
	}

	public void setBintroduce(String bintroduce) {
		this.bintroduce = bintroduce;
	}

}