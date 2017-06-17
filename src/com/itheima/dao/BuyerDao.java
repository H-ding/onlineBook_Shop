package com.itheima.dao;

import java.util.List;

import com.itheima.domain.TPay;
import com.itheima.domain.TUser;

public interface BuyerDao {
	// 成为VIP的操作
	public boolean BecomeVip(String username);

	// 购买图书的方法
	public int buyer_Buyingdao(int BId, int SId, int UId, int TCount,
			int package_);

	public int buyer_AddCar(TPay pay, String address);

	// 查看图书详情的方法
	public List buyer_CheckBookdao(int Bid);

	// 查看图书列表的方法
	public List buyer_CheckBookLIstdao(int pageNo);

	// 查看正在进行订单的方法
	public List buyer_CheckOrder_ING(int pageNo);

	// 查看所有订单列表的方法
	public List buyer_CheckOrderListdao(String username, int pageNo);

	// 签收方法
	public int sign(int OId);

	// 更新个人信息的方法
	// 1、先查询出个人信息到页面上
	public TUser queryTUser(String username);

	// 2、修改信息提交
	public int updateMassagedao(String username, String Address, String tel);

	// 修改密码的方法
	public int updatePassworddao(String username, String oldpassword,
			String newpassword);

	// 购物车的相关操作
	public int buyer_AddCardao(int B_Id, int BNumber,
			String package_);

	public int car_Add(int pageNo, int CId);

	public int car_Plus(int pageNo, int CId);

	public List buyer_checkCar(String username, int pageNo);

	public int buyer_DelCar_dao(int CId);

	// 收藏夹的相关操作
	public int buyer_AddCollectiondao(
			int bid);

	public List buyer_CheckCollectionList(int pageNo);

	public int buyer_DelBookCollection(int FId);

	// 买家评价功能
	public int Ev(int OId, String quality, String dispatching,
			String diservice, String sname, String uname, String bname,
			String uevaluate);

	// 页面上查看自己的图书评价信息
	public List pageCheckEV(int BId);

	// 购买的方法
	public int Buyer_Addpay(int BId, int Money, int TCount, int setmeals);
}
