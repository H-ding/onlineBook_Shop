package com.itheima.dao;

import java.util.List;

public interface ManagerDao {
	// 查看所有订单的信息
	public List checkAllList(int pageNo);

	// 查看所有书籍列表
	public List checkBookList(int pageNo);

	// 删除无用订单
	public boolean DelOrderdao(int O_Id);

	// 管理员修改密码
	public int tManager_UpdatePassworddao(String username, String oldpassword,
			String newpassword);

	// 管理员登陆后查看注册的卖家和买家数量
	public List Manager_CheckMount();

	// 查看买家列表和卖家列表
	public List ManagerChackSlarList(int pageNo);

	public List ManagerChackBuyerList(int pageNo);

	// 查看店铺销售额
	public List checkSale(int pageNo, String username);

	// 将书籍加入到首页列表
	public int addMainPageBookList(int BId, int SId);

	// 查看书籍首页列表
	public List checkMainPageBookList();

	// 下架首页书籍
	public int delMainPageBook(int mpId);
	
	//更新图书信息
	public int updateBookSeconddao(int SId,int Bid, String bname, String bauthor,
			int bprice, int bnumber, String btype, String bdate, String bpress,
			String bintroduce);
}
