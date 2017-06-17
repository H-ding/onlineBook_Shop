package com.itheima.service;

public interface RegistService {
	public int buyerRegistdao(String username, String password, String tel,
			String address);

	public int salerRegistdao(String username, String password,
			String Introduce, String address);
}
