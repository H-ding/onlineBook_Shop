package com.itheima.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.itheima.domain.TOrderTable;
import com.itheima.utils.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class TransformAction extends ActionSupport {
	private int OId;
	private String bname;

	public int getOId() {
		return OId;
	}

	public void setOId(int oId) {
		OId = oId;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String allTransaForm() {
		return SUCCESS;
	}

	public String EVTran() {
		Session session = HibernateUtils.getSession();
		List orderTableList = session
				.createQuery("from TOrderTable where OId=:oid")
				.setParameter("oid", OId).list();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("orderTableList", orderTableList);
		session.close();
		return SUCCESS;
	}
}
