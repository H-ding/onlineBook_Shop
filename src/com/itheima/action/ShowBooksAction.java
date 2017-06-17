package com.itheima.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.TBook;
import com.itheima.service.ShowBooksService;
import com.itheima.service.ShowTypeBooksService;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBooksAction extends ActionSupport {
	private String BName;
	private int pageNo;
	private int BType;
	private ShowBooksService showBooksService;
	private ShowTypeBooksService showTypeBooksService;

	public ShowTypeBooksService getShowTypeBooksService() {
		return showTypeBooksService;
	}

	public void setShowTypeBooksService(
			ShowTypeBooksService showTypeBooksService) {
		this.showTypeBooksService = showTypeBooksService;
	}

	public int getBType() {
		return BType;
	}

	public void setBType(int bType) {
		BType = bType;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getBName() {
		return BName;
	}

	public void setBName(String bName) {
		BName = bName;
	}

	public ShowBooksService getShowBooksService() {
		return showBooksService;
	}

	public void setShowBooksService(ShowBooksService showBooksService) {
		this.showBooksService = showBooksService;
	}

	public String ShowBooks() {
		List<TBook> list = showBooksService.findBooks(1, BName);
		int is = 0;
		is = list.size();

		if (is != 0) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("list", list);
			return SUCCESS;
		} else {
			return INPUT;
		}

	}

	public String ShowTypeBooks() {

		String btype = null;
		if (BType == 1)
			btype = "历史";
		else if (BType == 2)
			btype = "小说";
		else if (BType == 3)
			btype = "杂志";
		else if (BType == 4)
			btype = "儿童";
		else if (BType == 5)
			btype = "科学";
		else if (BType == 6)
			btype = "教育";
		else if (BType == 7)
			btype = "法律";
		else if (BType == 8)
			btype = "音乐";
		else if (BType == 9)
			btype = "计算机";
		List<TBook> typelist = showTypeBooksService
				.findTypeBooks(pageNo, btype);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("typelist", typelist);
		return SUCCESS;
	}
}
