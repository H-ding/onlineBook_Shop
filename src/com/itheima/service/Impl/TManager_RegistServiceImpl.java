package com.itheima.service.Impl;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.TManager_Registdao;
import com.itheima.service.TManager_RegistService;

@Transactional
public class TManager_RegistServiceImpl implements TManager_RegistService {
	private TManager_Registdao TManager_registdao;

	public TManager_Registdao getTManager_registdao() {
		return TManager_registdao;
	}

	public void setTManager_registdao(TManager_Registdao tManager_registdao) {
		TManager_registdao = tManager_registdao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int registManager(String username, String password) {
		// TODO Auto-generated method stub
		return TManager_registdao.registManager(username, password);
	}

}
