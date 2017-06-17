package com.itheima.service;

import java.util.List;

import com.itheima.domain.TBook;

public interface ShowBooksService {
	public List<TBook> findBooks(int pageNo, String BName);
}
