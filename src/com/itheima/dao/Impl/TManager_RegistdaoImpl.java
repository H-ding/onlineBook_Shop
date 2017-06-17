package com.itheima.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.TManager_Registdao;
import com.itheima.domain.TManager;
import com.itheima.utils.HibernateUtils;

public class TManager_RegistdaoImpl implements TManager_Registdao {

	@Override
	public int registManager(String username, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		List<TManager> list = session.createQuery("Select ts from TManager ts")
				.list();
		for (TManager tManager : list) {
			String username1 = tManager.getUsername();
			if (username.equals(username1)) {
				return flag;
			}
		}

		Transaction transaction = session.beginTransaction();
		TManager manager = new TManager();
		manager.setUsername(username);
		manager.setPassword(password);
		session.save(manager);
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

}
