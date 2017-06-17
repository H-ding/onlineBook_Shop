package com.itheima.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.ShowTypeBooksdao;
import com.itheima.domain.TBook;
import com.itheima.service.ShowTypeBooksService;

@Transactional
public class ShowTypeBooksServiceImpl implements ShowTypeBooksService {

	private ShowTypeBooksdao showTypeBooksdao;

	public ShowTypeBooksdao getShowTypeBooksdao() {
		return showTypeBooksdao;
	}

	public void setShowTypeBooksdao(ShowTypeBooksdao showTypeBooksdao) {
		this.showTypeBooksdao = showTypeBooksdao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<TBook> findTypeBooks(int pageNo, String BType) {
		// TODO Auto-generated method stub
		return showTypeBooksdao.findBTypeBooks(pageNo, BType);
	}

}
