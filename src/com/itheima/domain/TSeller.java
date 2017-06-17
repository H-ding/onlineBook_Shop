package com.itheima.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TSeller entity. @author MyEclipse Persistence Tools
 */

public class TSeller implements java.io.Serializable {

	// Fields

	private Integer SId;
	private String sname;
	private String spasswd;
	private String sintroduce;
	private String saddress;
	private Set TBooks = new HashSet(0);
	private Set TOrderTables = new HashSet(0);

	// Constructors

	/** default constructor */
	public TSeller() {
	}

	/** minimal constructor */
	public TSeller(Integer SId) {
		this.SId = SId;
	}

	/** full constructor */
	public TSeller(Integer SId, String sname, String spasswd,
			String sintroduce, String saddress, Set TBooks, Set TOrderTables) {
		this.SId = SId;
		this.sname = sname;
		this.spasswd = spasswd;
		this.sintroduce = sintroduce;
		this.saddress = saddress;
		this.TBooks = TBooks;
		this.TOrderTables = TOrderTables;
	}

	// Property accessors

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

	public String getSpasswd() {
		return this.spasswd;
	}

	public void setSpasswd(String spasswd) {
		this.spasswd = spasswd;
	}

	public String getSintroduce() {
		return this.sintroduce;
	}

	public void setSintroduce(String sintroduce) {
		this.sintroduce = sintroduce;
	}

	public String getSaddress() {
		return this.saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	public Set getTBooks() {
		return this.TBooks;
	}

	public void setTBooks(Set TBooks) {
		this.TBooks = TBooks;
	}

	public Set getTOrderTables() {
		return this.TOrderTables;
	}

	public void setTOrderTables(Set TOrderTables) {
		this.TOrderTables = TOrderTables;
	}

}