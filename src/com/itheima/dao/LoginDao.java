package com.itheima.dao;

public interface LoginDao {
	public int managerloginCheck(String username, String password);

	public int salerloginCheck(String username, String password);

	public int userloginCheck(String username, String password);
}
