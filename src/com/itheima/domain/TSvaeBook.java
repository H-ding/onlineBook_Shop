package com.itheima.domain;

/**
 * TSvaeBook entity. @author MyEclipse Persistence Tools
 */

public class TSvaeBook implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sname;
	private String bname;
	private Integer booksave;

	// Constructors

	/** default constructor */
	public TSvaeBook() {
	}

	/** minimal constructor */
	public TSvaeBook(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TSvaeBook(Integer id, String sname, String bname, Integer booksave) {
		this.id = id;
		this.sname = sname;
		this.bname = bname;
		this.booksave = booksave;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getBname() {
		return this.bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Integer getBooksave() {
		return this.booksave;
	}

	public void setBooksave(Integer booksave) {
		this.booksave = booksave;
	}

}