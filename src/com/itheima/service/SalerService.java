package com.itheima.service;

import java.util.List;

import com.itheima.domain.TBook;

public interface SalerService {
	// 查询图书列表
	public List checkBook(int pageNo, int id);

	// 查看店铺销售额
	public List checkSale(int pageNo, String username);

	// 下架图书
	public int deleteBookdao(int BId);

	// 发货功能
	public int delivery(int OId);

	// 查看店铺的所有订单
	public List lookOrderListdao(int pageNo, int id);

	// 更新书籍信息
	public TBook updateBookdao(int id);

	public int updateBookSeconddao(int Bid, String bname, String bauthor,
			int bprice, int bnumber, String btype, String bdate, String bpress,
			String bintroduce);

	// 修改个人信息
	public int updateMassagedao(String username, String Introduce,
			String SAddress);

	// 修改密码
	public int updatePassworddao(String username, String oldpassword,
			String newpassword);

	// 上传书籍
	public int uploadBookdao(String photoFileName, String bname,
			String bauthor, int bprice, int bnumber, String btype,
			String bdate, String bpress, String bintroduce);

	// 等待发货列表
	public List checkDelibery(int pageNo);
}
