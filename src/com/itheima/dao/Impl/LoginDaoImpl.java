package com.itheima.dao.Impl;

import java.util.List;

import org.hibernate.Session;

import com.itheima.dao.LoginDao;
import com.itheima.domain.TManager;
import com.itheima.domain.TSeller;
import com.itheima.domain.TUser;
import com.itheima.utils.HibernateUtils;

public class LoginDaoImpl implements LoginDao {

	@Override
	public int managerloginCheck(String username, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		String tusername = null;
		String tpassword = null;
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		List<TManager> list = session
				.createQuery(
						"select tManager from TManager tManager where username = :username")
				.setParameter("username", username).list();
		if (list.size() == 0) {
			return flag;
		} else if (list.size() == 1) {
			for (TManager tManager : list) {
				tusername = tManager.getUsername();
				tpassword = tManager.getPassword();

			}
		}

		if (username.equals(tusername) && password.equals(tpassword)) {

			flag = 1;
			return flag;
		} else {
			return flag;
		}
	}

	@Override
	public int salerloginCheck(String username, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		String tusername = null;
		String tpassword = null;
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		List<TSeller> list = session
				.createQuery(
						"select tseller from TSeller tseller where sname = :username")
				.setParameter("username", username).list();
		if (list.size() == 0) {
			session.close();
			return flag;
		} else if (list.size() == 1) {
			for (TSeller tSeller : list) {
				tusername = tSeller.getSname();
				tpassword = tSeller.getSpasswd();
			}
		}

		if (username.equals(tusername) && password.equals(tpassword)) {

			flag = 1;
			session.close();
			return flag;
		} else {
			session.close();
			return flag;
		}
	}

	@Override
	public int userloginCheck(String username, String password) {
		// TODO Auto-generated method stub
		int flag = 0;
		String tusername = null;
		String tpassword = null;
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		@SuppressWarnings("unchecked")
		List<TUser> list = session
				.createQuery(
						"select tuser from TUser tuser where uname = :username")
				.setParameter("username", username).list();
		if (list.size() == 0) {
			return flag;
		} else if (list.size() == 1) {
			for (TUser tUser : list) {
				tusername = tUser.getUname();
				tpassword = tUser.getPasswd();
			}
		}

		if (username.equals(tusername) && password.equals(tpassword)) {

			flag = 1;
			return flag;
		} else {
			return flag;
		}
	}

}
