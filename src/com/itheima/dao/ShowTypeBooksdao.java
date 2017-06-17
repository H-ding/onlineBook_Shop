package com.itheima.dao;

import java.util.List;

import com.itheima.domain.TBook;

public interface ShowTypeBooksdao {
	public List<TBook> findBTypeBooks(int pageNo,String BType);
}
