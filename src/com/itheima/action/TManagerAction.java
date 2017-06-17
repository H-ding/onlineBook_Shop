package com.itheima.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.TOrderTable;
import com.itheima.domain.TPay;
import com.itheima.service.ManagerService;
import com.itheima.service.TManager_RegistService;
import com.opensymphony.xwork2.ActionSupport;

public class TManagerAction extends ActionSupport {
	private int pageNo;
	private int o_id;
	private String username;
	private String password;
	private String repassword;
	private TManager_RegistService tManager_RegistService;
	private String oldpassword;
	private String newpassword;
	private String repeatnewpassword;
	private String sname;
	private int BId;
	private int SId;
	private ManagerService managerService;
	private int mpId;
	private String bname;
	private String bauthor;
	private int bprice;
	private int bnumber;
	private String btype;
	private String bdate;
	private String bpress;
	private String bintroduce;
	static String SSname;
	static int ls;

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public ManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getBprice() {
		return bprice;
	}

	public void setBprice(int bprice) {
		this.bprice = bprice;
	}

	public int getBnumber() {
		return bnumber;
	}

	public void setBnumber(int bnumber) {
		this.bnumber = bnumber;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBpress() {
		return bpress;
	}

	public void setBpress(String bpress) {
		this.bpress = bpress;
	}

	public String getBintroduce() {
		return bintroduce;
	}

	public void setBintroduce(String bintroduce) {
		this.bintroduce = bintroduce;
	}

	public static int getLs() {
		return ls;
	}

	public static void setLs(int ls) {
		TManagerAction.ls = ls;
	}

	public int getO_id() {
		return o_id;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public int getMpId() {
		return mpId;
	}

	public void setMpId(int mpId) {
		this.mpId = mpId;
	}

	public int getBId() {
		return BId;
	}

	public void setBId(int bId) {
		BId = bId;
	}

	public int getSId() {
		return SId;
	}

	public void setSId(int sId) {
		SId = sId;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRepeatnewpassword() {
		return repeatnewpassword;
	}

	public void setRepeatnewpassword(String repeatnewpassword) {
		this.repeatnewpassword = repeatnewpassword;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public TManager_RegistService gettManager_RegistService() {
		return tManager_RegistService;
	}

	public void settManager_RegistService(
			TManager_RegistService tManager_RegistService) {
		this.tManager_RegistService = tManager_RegistService;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String checkAllList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<TOrderTable> tManager_Check_Order_List = managerService
				.checkAllList(pageNo);
		request.getSession().setAttribute("tManager_Check_Order_List",
				tManager_Check_Order_List);
		return SUCCESS;
	}

	public String checkBookList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List TManager_CheckBook_list = managerService.checkBookList(pageNo);
		request.getSession().setAttribute("TManager_CheckBook_list",
				TManager_CheckBook_list);
		return SUCCESS;
	}

	// 删除订单
	public String delOrder() {
		boolean flag;
		flag = false;
		flag = managerService.DelOrderdao(o_id);
		if (flag)
			return SUCCESS;
		else
			return INPUT;
	}

	public String registManager() {
		int flag = 0;
		if (password.equals(repassword)) {
			flag = tManager_RegistService.registManager(username, password);
			if (flag == 1)
				return SUCCESS;
			else
				return INPUT;
		} else
			return INPUT;
	}

	public String tManager_UpdatePassworddao() {
		int flag = 0;
		if (newpassword.equals(repeatnewpassword)) {
			flag = managerService.tManager_UpdatePassworddao(username,
					oldpassword, newpassword);
			if (flag == 1)
				return SUCCESS;
			else
				return INPUT;

		} else
			return INPUT;
	}

	public String checkSalerList() {
		List managerSalerList = managerService.ManagerChackSlarList(pageNo);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("managerSalerList", managerSalerList);
		return SUCCESS;
	}

	public String checkUserList() {
		List managerBuyerList = managerService.ManagerChackBuyerList(pageNo);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("managerBuyerList", managerBuyerList);
		return SUCCESS;
	}

	public String checkSale() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (ls == 0) {
			SSname = sname;
			ls++;
		}

		List<TPay> Check_Sale_list = managerService.checkSale(pageNo, SSname);
		request.getSession().setAttribute("manager_Check_Sale_list",
				Check_Sale_list);
		int CurrentCount = 0;
		for (TPay pay : Check_Sale_list) {
			int money = pay.getMOney();
			CurrentCount = CurrentCount + money;
		}
		request.getSession().setAttribute("managerCurrentCount", CurrentCount);
		return SUCCESS;
	}

	public String addMainPageBookList() {
		int flag = 0;
		flag = managerService.addMainPageBookList(BId, SId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String checkMainPageBookList() {
		List checkMainPageBookList = managerService.checkMainPageBookList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("checkMainPageBookList",
				checkMainPageBookList);
		return SUCCESS;
	}

	public String delMainPageBook() {
		int flag = 0;
		flag = managerService.delMainPageBook(mpId);
		if (flag == 1) {
			List checkMainPageBookList = managerService.checkMainPageBookList();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("checkMainPageBookList",
					checkMainPageBookList);
			return SUCCESS;
		} else
			return INPUT;
	}
	
	public String updateBook()
	{
	     int flag=0;
		 flag=managerService.updateBookSeconddao(SId, BId, bname, bauthor, bprice, bnumber, btype, bdate, bpress, bintroduce);
	     if(flag==1)
	    	 return SUCCESS;
	     else
	    	 return INPUT;
	}
}
