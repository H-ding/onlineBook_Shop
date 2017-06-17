package com.itheima.action;

import com.itheima.dao.Impl.MailUtils;
import com.itheima.service.RegistService;
import com.opensymphony.xwork2.ActionSupport;

public class RegistAction extends ActionSupport {
	/**
	 * 
	 */
	private String username;
	private String password;
	private String repassword;
	private String Introduce;
	private String Address;
	private String tel;
	private String email;
	private RegistService registService;

	public RegistService getRegistService() {
		return registService;
	}

	public void setRegistService(RegistService registService) {
		this.registService = registService;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getIntroduce() {
		return Introduce;
	}

	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String SalerRegist() {
		if (repassword.equals(password)) {
			int flag = 0;
			flag = registService.salerRegistdao(username, password, Introduce,
					Address);
			if (flag == 1)
				return SUCCESS;
			else
				return INPUT;
		} else
			return INPUT;
	}

	public String buyerRegist() {
		int flag = 0;
		if (password.equals(repassword)) {
			flag = registService.buyerRegistdao(username, password, tel,
					Address);
			if (flag == 1) {
				MailUtils ts = new MailUtils();
				ts.sendMail(email);
				return SUCCESS;
			} else
				return INPUT;
		} else
			return INPUT;
	}

}
