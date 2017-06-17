package com.itheima.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.RegistDao;
import com.itheima.domain.TSeller;
import com.itheima.domain.TUser;
import com.itheima.utils.HibernateUtils;

public class RegistDaoImpl implements RegistDao {

	@Override
	public int buyerRegistdao(String username, String password, String tel,
			String address) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		List<TUser> list = session.createQuery("select tuser from TUser tuser")
				.list();
		for (TUser tUser : list) {
			String TUsername = tUser.getUname();
			if (username.equals(TUsername))
				return flag;
			else {
				List<TSeller> lists = session.createQuery(
						"select ts from TSeller ts").list();
				for (TSeller tSeller : lists) {
					String Sname = tSeller.getSname();
					if (username.equals(Sname))
						return 0;
				}
			}
		}
		Transaction transaction = session.beginTransaction();
		TUser tUser = new TUser();
		tUser.setUname(username);
		tUser.setPasswd(password);
		tUser.setTel(tel);
		tUser.setUaddresss(address);
		tUser.setVip("否");
		session.save(tUser);
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

	@Override
	public int salerRegistdao(String username, String password,
			String Introduce, String address) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		List<TSeller> list = session.createQuery(
				"select tseller from TSeller tseller").list();
		for (TSeller tSeller : list) {
			String TUsername = tSeller.getSname();
			if (username.equals(TUsername))
				return flag;
			else {
				List<TUser> list1 = session.createQuery(
						"select ts from TUser ts").list();
				for (TUser tuser : list1) {
					String Uname = tuser.getUname();
					if (username.equals(Uname)) {
						return 0;
					}
				}

			}
		}
		Transaction transaction = session.beginTransaction();
		TSeller tSaler = new TSeller();
		tSaler.setSname(username);
		tSaler.setSpasswd(password);
		tSaler.setSintroduce(Introduce);
		tSaler.setSaddress(address);
		session.save(tSaler);
		TUser tu = new TUser();
		tu.setUname(username);
		tu.setPasswd(password);
		tu.setTel("您是卖家");
		tu.setUaddresss("您是卖家");
		tu.setVip("否");
		session.save(tu);
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

}
