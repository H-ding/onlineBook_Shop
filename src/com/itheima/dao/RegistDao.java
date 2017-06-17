package com.itheima.dao;

public interface RegistDao {
	public int buyerRegistdao(String username, String password, String tel,
			String address);

	public int salerRegistdao(String username, String password,
			String Introduce, String address);
}
