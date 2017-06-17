package com.itheima.service.Impl;

import com.itheima.dao.VerificationCodeUtildao;
import com.itheima.service.VerificationCodeUtilService;

public class VerificationCodeUtilServiceImpl implements
		VerificationCodeUtilService {
	private VerificationCodeUtildao verificationCodeUtildao;

	@Override
	public VerificationCodeUtildao verificationCodeUtilService() {
		// TODO Auto-generated method stub
		return this.verificationCodeUtildao;
	}

	public VerificationCodeUtildao getVerificationCodeUtildao() {
		return verificationCodeUtildao;
	}

	public void setVerificationCodeUtildao(
			VerificationCodeUtildao verificationCodeUtildao) {
		this.verificationCodeUtildao = verificationCodeUtildao;
	}

}
