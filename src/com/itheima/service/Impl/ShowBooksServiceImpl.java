package com.itheima.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.ShowBooksdao;
import com.itheima.domain.TBook;
import com.itheima.service.ShowBooksService;

@Transactional
public class ShowBooksServiceImpl implements ShowBooksService {
	private ShowBooksdao showBooksdao;

	public ShowBooksdao getShowBooksdao() {
		return showBooksdao;
	}

	public void setShowBooksdao(ShowBooksdao showBooksdao) {
		this.showBooksdao = showBooksdao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<TBook> findBooks(int pageNo, String BName) {
		return showBooksdao.findBooks(pageNo, BName);
	}

}
