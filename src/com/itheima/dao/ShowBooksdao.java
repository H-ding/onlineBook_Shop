package com.itheima.dao;

import java.util.List;

import com.itheima.domain.TBook;

public interface ShowBooksdao {
	public List<TBook> findBooks(int pageNo, String BName);

}
