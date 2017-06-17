package com.itheima.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import com.itheima.domain.TBook;
import com.itheima.domain.TPay;
import com.itheima.domain.TSeller;
import com.itheima.domain.TUser;
import com.itheima.service.BuyerService;
import com.itheima.utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuyerAction extends ActionSupport {
	private int BId;
	private int TCount;
	private String setmeal;
	private int bid;
	private int SId;
	private int setmeals;
	private int pageNo;
	private int FId;
	private int CId;
	private int OId;
	private String username;
	private String address;
	private String tel;
	private String oldpassword;
	private String newpassword;
	private String repeatnewpassword;
	private int shouldPay;
	private String Taddress;
	private String uname;
	private String sname;
	private String quality;
	private String dispatching;
	private String diservice;
	private String uevaluate;
	private String vip;
	private String bname;
	private BuyerService buyerService;

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getDispatching() {
		return dispatching;
	}

	public void setDispatching(String dispatching) {
		this.dispatching = dispatching;
	}

	public String getDiservice() {
		return diservice;
	}

	public void setDiservice(String diservice) {
		this.diservice = diservice;
	}

	public String getUevaluate() {
		return uevaluate;
	}

	public void setUevaluate(String uevaluate) {
		this.uevaluate = uevaluate;
	}

	public BuyerService getBuyerService() {
		return buyerService;
	}

	public void setBuyerService(BuyerService buyerService) {
		this.buyerService = buyerService;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getTaddress() {
		return Taddress;
	}

	public void setTaddress(String taddress) {
		Taddress = taddress;
	}

	public int getShouldPay() {
		return shouldPay;
	}

	public void setShouldPay(int shouldPay) {
		this.shouldPay = shouldPay;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getOId() {
		return OId;
	}

	public void setOId(int oId) {
		OId = oId;
	}

	public int getCId() {
		return CId;
	}

	public void setCId(int CId) {
		this.CId = CId;
	}

	public int getFId() {
		return FId;
	}

	public void setFId(int fId) {
		FId = fId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getSetmeals() {
		return setmeals;
	}

	public void setSetmeals(int setmeals) {
		this.setmeals = setmeals;
	}

	public int getSId() {
		return SId;
	}

	public void setSId(int sId) {
		SId = sId;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBId() {
		return BId;
	}

	public void setBId(int bId) {
		BId = bId;
	}

	public int getTCount() {
		return TCount;
	}

	public void setTCount(int tCount) {
		TCount = tCount;
	}

	public String getSetmeal() {
		return setmeal;
	}

	public void setSetmeal(String setmeal) {
		this.setmeal = setmeal;
	}

	public String addCar() throws UnsupportedEncodingException {
		
		int flag = 0;
		flag = buyerService.buyer_AddCardao(BId,  TCount, setmeal);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String buyer_AddCollection() {

		
		int flag = 0;
		flag = buyerService.buyer_AddCollectiondao(bid);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String buyer_Buying() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");

		Session session = HibernateUtils.getSession();
		TUser tuser = (TUser) session
				.createQuery(
						"select tuser from TUser tuser where UName=:username")
				.setParameter("username", username).uniqueResult();
		int UId = tuser.getUId();
		String vip = tuser.getVip();
		TBook tBook = (TBook) session
				.createQuery("select tbook from TBook tbook where B_Id=:BId")
				.setParameter("BId", BId).uniqueResult();
		int bprice = 0;
		bprice = tBook.getBprice();
		if ("是".equals(vip)) {
			bprice = (int) (bprice * 0.9);
		}
		int shouldPay = 0;
		int flag = 0;
		int page = 1;
		if (setmeal.equals("套餐一")) {
			shouldPay = TCount * bprice;
			page = 1;
		} else if (setmeal.equals("套餐二")) {
			shouldPay = TCount * (bprice + 15);
			page = 2;
		} else {
			shouldPay = TCount * (bprice + 30);
			page = 3;
		}
		String bpicture = tBook.getBpicture();
		int id = tBook.getTSeller().getSId();
		String bname = tBook.getBname();
		TSeller tSeller = (TSeller) session
				.createQuery("select ts from TSeller ts where SId=:id")
				.setParameter("id", id).uniqueResult();
		String Sname = tSeller.getSname();
		session.close();
		int money = this.shouldPay;
		int TCount = this.TCount;
		TPay pay = new TPay();
		pay.setBId(BId);
		pay.setBpicture(bpicture);
		pay.setMOney(shouldPay);
		pay.setPackage_(page);
		pay.setPayState("未付款");
		pay.setSId(id);
		pay.setSname(Sname);
		pay.setTcount(TCount);
		pay.setUId(UId);
		pay.setUname(username);
		pay.setBname(bname);
		request.getSession().setAttribute("pay", pay);
		HttpServletRequest ac = ServletActionContext.getRequest();
		ac.getSession().setAttribute("VIP", vip);
		return SUCCESS;
	}

	public String buyer_Car_Buying() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		TPay pay = (TPay) request.getSession().getAttribute("pay");
		int BId = pay.getBId();
		int id = pay.getSId();
		int UId = pay.getUId();
		int TCount = pay.getTcount();
		int setmeals = pay.getPackage_();
		buyerService.buyer_AddCar(pay, Taddress);
		buyerService.buyer_Buyingdao(BId, id, UId, TCount, setmeals);
		return SUCCESS;

	}

	public String buyer_CHeckBook() {
		List buyer_tbook = buyerService.buyer_CheckBookdao(BId);
		List BookEVList = buyerService.pageCheckEV(BId);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("buyer_tbook", buyer_tbook);
		request.getSession().setAttribute("BookEVList", BookEVList);
		return SUCCESS;
	}

	// 成为VIP
	public String buyer_BecomeVip() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String reqPamrs = request.getQueryString();// 后面的参数
		boolean is = buyerService.BecomeVip(reqPamrs);
		if (is)
			return SUCCESS;
		else
			return INPUT;
	}

	public String buyer_checkCar() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		List buyer_Car_List = buyerService.buyer_checkCar(username, pageNo);
		request.getSession().setAttribute("buyer_Car_List", buyer_Car_List);
		return SUCCESS;
	}

	public String Buyer_CheckCollectionList() {
		List Buyer_CheckCollectionList = buyerService
				.buyer_CheckCollectionList(pageNo);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("Buyer_CheckCollectionList",
				Buyer_CheckCollectionList);
		return SUCCESS;
	}

	public String buyer_CheckOrder_ING() {
		List buyer_CheckOrder_ING_list = buyerService
				.buyer_CheckOrder_ING(pageNo);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("buyer_CheckOrder_ING_list",
				buyer_CheckOrder_ING_list);
		return SUCCESS;
	}

	public String checkOrderList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		List list = buyerService.buyer_CheckOrderListdao(username, pageNo);
		request.getSession().setAttribute("buyer_CheckOrderList", list);
		return SUCCESS;
	}

	public String buyer_DelBookCollection() {
		int flag = 0;
		flag = buyerService.buyer_DelBookCollection(FId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String buyer_DelCar() {

		int flag = 0;
		flag = buyerService.buyer_DelCar_dao(CId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String sign() {
		int flag = 0;
		flag = buyerService.sign(OId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String buyer_updateMassage() {
		int flag = 0;
		flag = buyerService.updateMassagedao(username, address, tel);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String buyer_UpdateMassageFisrt() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		TUser tuser = buyerService.queryTUser(username);
		request.getSession().setAttribute("buyer_updateFirst_tuser", tuser);
		return SUCCESS;
	}

	public String buyer_Updatepassword() {
		if (newpassword.equals(repeatnewpassword)) {
			int flag = 0;
			flag = buyerService.updatePassworddao(username, oldpassword,
					newpassword);
			if (flag == 1)
				return SUCCESS;
			else
				return INPUT;
		} else
			return INPUT;
	}

	public String Buyer_Addpay() {

		buyerService.Buyer_Addpay(BId, this.shouldPay, this.TCount, this.setmeals);
		return SUCCESS;
	}

	public String car_Add() {
		int flag = buyerService.car_Add(pageNo, CId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String car_Plus() {
		int flag = buyerService.car_Plus(pageNo, CId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String Ev() {
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TBook book = (TBook) session.createQuery("from TBook where BId=:BId")
				.setParameter("BId", BId).uniqueResult();
		String bbname = book.getBname();
		flag = buyerService.Ev(OId, quality, dispatching, diservice, sname,
				uname, bbname, uevaluate);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}
}
