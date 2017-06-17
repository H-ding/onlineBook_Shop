package com.itheima.service.Impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.LoginDao;
import com.itheima.service.LoginDaoService;

@Transactional
public class LoginDaoServiceImpl implements LoginDaoService {
	private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int managerloginCheck(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.managerloginCheck(username, password);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int salerloginCheck(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.salerloginCheck(username, password);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int userloginCheck(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.userloginCheck(username, password);
	}

}
