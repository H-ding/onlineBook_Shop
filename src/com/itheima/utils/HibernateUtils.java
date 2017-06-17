package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	static {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			sessionFactory = (SessionFactory) context.getBean("sessionFactory");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public static void closeSession(Session session) {
		if (session != null) {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}
