package com.itheima.domain;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer UId;
	private String uname;
	private String passwd;
	private String tel;
	private String uaddresss;
	private String vip;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUaddresss() {
		return uaddresss;
	}

	public void setUaddresss(String uaddresss) {
		this.uaddresss = uaddresss;
	}

	/** minimal constructor */
	public TUser(Integer UId, String uname) {
		this.UId = UId;
		this.uname = uname;
	}

	/** full constructor */
	public TUser(Integer UId, String uname, String passwd,String tel,String uaddresss, String vip) {
		this.UId = UId;
		this.uname = uname;
		this.passwd = passwd;
		this.tel=tel;
		this.uaddresss=uaddresss;
		this.vip = vip;
	}

	// Property accessors

	public Integer getUId() {
		return this.UId;
	}

	public void setUId(Integer UId) {
		this.UId = UId;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getVip() {
		return this.vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

}