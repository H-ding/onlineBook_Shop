package com.itheima.service;

public interface LoginDaoService {
	public int managerloginCheck(String username, String password);

	public int salerloginCheck(String username, String password);

	public int userloginCheck(String username, String password);
}
