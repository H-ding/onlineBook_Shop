package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TBook entity. @author MyEclipse Persistence Tools
 */

public class TBook implements java.io.Serializable {

	// Fields

	private Integer BId;
	private TSeller TSeller;
	private String bpicture;
	private String bname;
	private String bauthor;
	private Integer bprice;
	private Integer bnumber;
	private String btype;
	private String bdate;
	private String bpress;
	private String bintroduce;
	private Set TFavoriteses = new HashSet(0);
	private Set TCars = new HashSet(0);
	private Set TOrderTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public TBook() {
	}

	/** minimal constructor */
	public TBook(Integer BId) {
		this.BId = BId;
	}

	/** full constructor */
	public TBook(Integer BId, TSeller TSeller, String bpicture, String bname,
			String bauthor, Integer bprice, Integer bnumber, String btype,
			String bdate, String bpress, String bintroduce, Set TFavoriteses,
			Set TCars, Set TOrderTables) {
		this.BId = BId;
		this.TSeller = TSeller;
		this.bpicture = bpicture;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bprice = bprice;
		this.bnumber = bnumber;
		this.btype = btype;
		this.bdate = bdate;
		this.bpress = bpress;
		this.bintroduce = bintroduce;
		this.TFavoriteses = TFavoriteses;
		this.TCars = TCars;
		this.TOrderTables = TOrderTables;
	}

	// Property accessors

	public Integer getBId() {
		return this.BId;
	}

	public void setBId(Integer BId) {
		this.BId = BId;
	}

	public TSeller getTSeller() {
		return this.TSeller;
	}

	public void setTSeller(TSeller TSeller) {
		this.TSeller = TSeller;
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

	public Set getTFavoriteses() {
		return this.TFavoriteses;
	}

	public void setTFavoriteses(Set TFavoriteses) {
		this.TFavoriteses = TFavoriteses;
	}

	public Set getTCars() {
		return this.TCars;
	}

	public void setTCars(Set TCars) {
		this.TCars = TCars;
	}

	public Set getTOrderTables() {
		return this.TOrderTables;
	}

	public void setTOrderTables(Set TOrderTables) {
		this.TOrderTables = TOrderTables;
	}

}