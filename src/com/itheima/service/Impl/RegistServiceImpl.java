package com.itheima.service.Impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.RegistDao;
import com.itheima.service.RegistService;

@Transactional
public class RegistServiceImpl implements RegistService {
	private RegistDao registDao;

	public RegistDao getRegistDao() {
		return registDao;
	}

	public void setRegistDao(RegistDao registDao) {
		this.registDao = registDao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int buyerRegistdao(String username, String password, String tel,
			String address) {
		// TODO Auto-generated method stub
		return registDao.buyerRegistdao(username, password, tel, address);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int salerRegistdao(String username, String password,
			String Introduce, String address) {
		// TODO Auto-generated method stub
		return registDao.salerRegistdao(username, password, Introduce, address);
	}

}
