package com.itheima.dao.Impl;

import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.ShowTypeBooksdao;
import com.itheima.domain.TBook;
import com.itheima.utils.HibernateUtils;

public class ShowTypeBooksdaoImpl implements ShowTypeBooksdao {

	@Override
	public List<TBook> findBTypeBooks(int pageNo, String BType) {
		List<TBook> list = null;

		Session session = HibernateUtils.getSession();
		String sql = "from TBook as book where book.btype like :btype";
		// Query queryObject = session.createQuery(
		// "from TBook as book where book.btype=?").setParameter(
		// 0, BType);
		Query queryObject = session.createQuery(sql);
		queryObject.setString("btype", "%" + BType + "%");
		// list = queryObject.list();
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

}
