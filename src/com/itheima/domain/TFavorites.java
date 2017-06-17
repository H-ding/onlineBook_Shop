package com.itheima.domain;

/**
 * TFavorites entity. @author MyEclipse Persistence Tools
 */

public class TFavorites implements java.io.Serializable {

	// Fields

	private Integer FId;
	private String bpicture;
	private String bname;
	private String uname;
	private String favType;
	private Integer BId;

	// Constructors

	/** default constructor */
	public TFavorites() {
	}

	/** minimal constructor */
	public TFavorites(Integer FId) {
		this.FId = FId;
	}

	/** full constructor */
	public TFavorites(Integer FId, String bpicture, String bname, String uname,
			String favType, Integer BId) {
		this.FId = FId;
		this.bpicture = bpicture;
		this.bname = bname;
		this.uname = uname;
		this.favType = favType;
		this.BId = BId;
	}

	// Property accessors

	public Integer getFId() {
		return this.FId;
	}

	public void setFId(Integer FId) {
		this.FId = FId;
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

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getFavType() {
		return this.favType;
	}

	public void setFavType(String favType) {
		this.favType = favType;
	}

	public Integer getBId() {
		return this.BId;
	}

	public void setBId(Integer BId) {
		this.BId = BId;
	}

}