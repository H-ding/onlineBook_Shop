package com.itheima.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.ShowBooksdao;
import com.itheima.domain.TBook;
import com.itheima.utils.HibernateUtils;

public class ShowBooksdaoImpl implements ShowBooksdao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TBook> findBooks(int pageNo, String BName) {
		List<TBook> list = null;

		Session session = HibernateUtils.getSession();
		String sql = "from TBook as book where book.bname like :bname";
		// Query queryObject = session.createQuery(
		// "select book from TBook book where bname like ?").setParameter(
		// 0, "%BName%");
		Query queryObject = session.createQuery(sql);
		// list = queryObject.list();
		queryObject.setString("bname", "%" + BName + "%");
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		list = queryObject.list();
		return list;
	}

}
