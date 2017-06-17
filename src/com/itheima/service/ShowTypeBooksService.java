package com.itheima.service;

import java.util.List;

import com.itheima.domain.TBook;

public interface ShowTypeBooksService {
	public List<TBook> findTypeBooks(int pageNo, String BType);
}
