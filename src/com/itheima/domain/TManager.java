package com.itheima.domain;

/**
 * TManager entity. @author MyEclipse Persistence Tools
 */

public class TManager implements java.io.Serializable {

	// Fields

	private Integer MId;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public TManager() {
	}

	/** minimal constructor */
	public TManager(Integer MId) {
		this.MId = MId;
	}

	/** full constructor */
	public TManager(Integer MId, String username, String password) {
		this.MId = MId;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getMId() {
		return this.MId;
	}

	public void setMId(Integer MId) {
		this.MId = MId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}