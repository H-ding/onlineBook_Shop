package com.itheima.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.service.BuyerService;
import com.itheima.service.LoginDaoService;
import com.itheima.service.ManagerService;
import com.itheima.utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int pageNo;
	private String yzm;
	private BuyerService buyerService;
	private LoginDaoService loginDaoService;
	private ManagerService managerService;

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public LoginDaoService getLoginDaoService() {
		return loginDaoService;
	}

	public void setLoginDaoService(LoginDaoService loginDaoService) {
		this.loginDaoService = loginDaoService;
	}

	public BuyerService getBuyerService() {
		return buyerService;
	}

	public void setBuyerService(BuyerService buyerService) {
		this.buyerService = buyerService;
	}

	public String getYzm() {
		return yzm;
	}

	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String loginCheck() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String trueyzm = (String) request.getSession().getAttribute("random");
		if (trueyzm.equals(yzm)) {
			ActionContext ac = ActionContext.getContext();
			int flag = loginDaoService.salerloginCheck(username, password);
			HttpSession sessionJSP = ServletActionContext.getRequest()
					.getSession();
			sessionJSP.setAttribute("username", username);
			List checkMainPageBookList = managerService.checkMainPageBookList();
			request.getSession().setAttribute("checkMainPageBookList",
					checkMainPageBookList);
			if (flag == 1) {
				List Buyer_list = buyerService.buyer_CheckBookLIstdao(pageNo);
				request.getSession().setAttribute("Buyer_list", Buyer_list);
				ac.getSession().put("identity", "Saler");
				Session session = HibernateUtils.getSession();
				List list = session
						.createQuery(
								"select ts from TOrderTable ts where ts.logistics=:logistics and ts.sname=:username")
						.setParameter("logistics", "等待卖家发货")
						.setParameter("username", username).list();
				int list_Size = list.size();
				request.getSession().setAttribute("list_Size", list_Size);
				return SUCCESS;
			} else if (flag == 0) {
				List Buyer_list = buyerService.buyer_CheckBookLIstdao(pageNo);
				flag = loginDaoService.userloginCheck(username, password);

				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("Buyer_list", Buyer_list);
				if (flag == 1) {
					ac.getSession().put("identity", "Buyer");
					return "TUSERSUCCESS";
				} else {
					return INPUT;
				}
			} else
				return INPUT;
		} else {
			return INPUT;
		}
	}

	public String TManagerLogin() {
		int flag = 0;
		flag = loginDaoService.managerloginCheck(username, password);
		if (flag == 1) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("username", username);
			List managerCheckAmout = managerService.Manager_CheckMount();
			int userList = (Integer) managerCheckAmout.get(0);
			int salerList = (Integer) managerCheckAmout.get(1);
			request.getSession().setAttribute("managerCheckAmout",
					managerCheckAmout);
			request.getSession().setAttribute("userList", userList);
			request.getSession().setAttribute("salerList", salerList);
			return SUCCESS;
		} else
			return INPUT;
	}
}
