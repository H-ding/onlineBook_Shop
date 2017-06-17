package com.itheima.dao.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.BuyerDao;
import com.itheima.domain.TBook;
import com.itheima.domain.TCar;
import com.itheima.domain.TEvaluate;
import com.itheima.domain.TFavorites;
import com.itheima.domain.TOrderTable;
import com.itheima.domain.TPay;
import com.itheima.domain.TSeller;
import com.itheima.domain.TSvaeBook;
import com.itheima.domain.TUser;
import com.itheima.utils.HibernateUtils;
import com.opensymphony.xwork2.ActionContext;

public class BuyerDaoImpl implements BuyerDao {

	// 成为VIP的操作

	@Override
	public boolean BecomeVip(String username) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		TUser tUser = (TUser) session
				.createQuery("from TUser where uname = :username")
				.setParameter("username", username).uniqueResult();
		String vip = tUser.getVip();
		if (vip.equals("否")) {
			Transaction transaction = session.beginTransaction();
			String hql = "update TUser tUser set tUser.vip='是' where uname = :username";
			Query queryupdate = session.createQuery(hql).setParameter(
					"username", username);
			int ret = queryupdate.executeUpdate();
			transaction.commit();
			session.close();

			return true;
		} else
			return false;
	}

	// 购买图书的方法

	@Override
	public int buyer_Buyingdao(int BId, int SId, int UId, int TCount,
			int package_) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TUser tuser = (TUser) session
				.createQuery("select tuser from TUser tuser where UId=:UId")
				.setParameter("UId", UId).uniqueResult();
		String uName = tuser.getUname();
		TSeller tseller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where SId=:SId")
				.setParameter("SId", SId).uniqueResult();
		String sname = tseller.getSname();
		TBook tbook = (TBook) session
				.createQuery("select tbook from TBook tbook where BId=:BId")
				.setParameter("BId", BId).uniqueResult();
		String bname = tbook.getBname();
		System.out.println("first:" + bname);
		TSvaeBook tSvaeBook = (TSvaeBook) session
				.createQuery("select ts from TSvaeBook ts where bname=:bname")
				.setParameter("bname", bname).uniqueResult();
		int saveCount = tSvaeBook.getBooksave();
		if (saveCount >= TCount) {
			saveCount = saveCount - TCount;

			String BPicture = tbook.getBpicture();
			Transaction transaction = session.beginTransaction();
			String hql2 = "update TSvaeBook ts set ts.booksave=:booksave"
					+ " where ts.bname=:bname";
			Query queryupdate1 = session.createQuery(hql2)
					.setParameter("booksave", saveCount)
					.setParameter("bname", bname);
			int ret1 = queryupdate1.executeUpdate();
			TOrderTable orderTable = new TOrderTable();
			orderTable.setBpicture(BPicture);
			orderTable.setTBook(tbook);
			orderTable.setTSeller(tseller);
			orderTable.setUId(UId);
			orderTable.setUname(uName);
			orderTable.setSname(sname);
			orderTable.setTcount(TCount);
			orderTable.setPackage_(package_);
			orderTable.setOstate("未完成");
			orderTable.setLogistics("等待卖家发货");
			session.save(orderTable);
			flag = 1;
			transaction.commit();
			session.close();
			return flag;
		} else
			return flag;
	}

	// 在付款页面购买图书的方法
	@Override
	public int buyer_AddCar(TPay pay, String address) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		pay.setPayState("已付款");
		pay.setUaddress(address);
		Transaction transaction = session.beginTransaction();
		session.save(pay);
		transaction.commit();
		return 0;
	}

	// 查看图书详情的方法

	@Override
	public List buyer_CheckBookdao(int Bid) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		List tbook = session
				.createQuery("select tbook from TBook tbook where BId= :Bid")
				.setParameter("Bid", Bid).list();
		session.close();
		return tbook;
	}

	// 查看图书列表的方法

	@Override
	public List buyer_CheckBookLIstdao(int pageNo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		String queryString = "select tbook from TBook tbook";
		Query query = session.createQuery(queryString);
		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

	// 查看正在进行订单的方法
	@Override
	public List buyer_CheckOrder_ING(int pageNo) {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		Session session = HibernateUtils.getSession();
		Query queryObject = (Query) session
				.createQuery(
						"select torder from TOrderTable torder where ostate=:ostate and uname=:username")
				.setParameter("ostate", "未完成")
				.setParameter("username", username);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

	// 查看所有订单列表的方法
	@Override
	public List buyer_CheckOrderListdao(String username, int pageNo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(
				" select a,b.bname from TOrderTable a,TBook b where a.TBook.BId=b.BId"
						+ " and Uname=:username").setParameter("username",
				username);
		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

	// 签收方法
	@Override
	public int sign(int OId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update TOrderTable tseller set tseller.ostate=:ostate,tseller.logistics=:logistics where tseller.OId=:OId";
		Query queryupdate = session.createQuery(hql)
				.setParameter("ostate", "已完成").setParameter("logistics", "已签收")
				.setParameter("OId", OId);
		flag = queryupdate.executeUpdate();

		transaction.commit();
		session.close();
		return flag;
	}

	// 更新个人信息的方法
	// 1、先查询出个人信息到页面上
	@Override
	public TUser queryTUser(String username) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		TUser tuser = (TUser) session
				.createQuery(
						"select tuser from TUser tuser where Uname=:username")
				.setParameter("username", username).uniqueResult();
		session.close();
		return tuser;
	}

	// 2、修改信息提交
	@Override
	public int updateMassagedao(String username, String Address, String tel) {
		// TODO Auto-generated method stub
		int flag = 0;

		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update TUser tseller set tseller.uaddresss="
				+ ":address,tseller.tel=:tel where tseller.uname=:username";
		Query queryupdate = session.createQuery(hql)
				.setParameter("address", Address).setParameter("tel", tel)
				.setParameter("username", username);
		int ret = queryupdate.executeUpdate();
		flag = 1;
		transaction.commit();
		return flag;
	}

	// 修改密码的方法
	@Override
	public int updatePassworddao(String username, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TUser tSeller = (TUser) session
				.createQuery(
						"select tseller from TUser tseller where uname = :username")
				.setParameter("username", username).uniqueResult();
		if (tSeller.getPasswd().equals(oldpassword)) {
			Transaction transaction = session.beginTransaction();
			String hql = "update TUser tseller set tseller.passwd=:newpassword where tseller.uname=:username";
			Query queryupdate = session.createQuery(hql)
					.setParameter("newpassword", newpassword)
					.setParameter("username", username);
			int ret = queryupdate.executeUpdate();
			flag = 1;
			transaction.commit();
			session.close();
			return flag;
		} else
			return flag;
	}

	// 购物车的相关操作
	@Override
	public int buyer_AddCardao( int B_Id,  int BNumber,
			String package_) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		TUser tuser = (TUser) session
				.createQuery(
						"select tuser from TUser tuser where UName=:username")
				.setParameter("username", username).uniqueResult();
		int UId = tuser.getUId();
		TBook tBook = (TBook) session
				.createQuery("select tbook from TBook tbook where B_Id=:BId")
				.setParameter("BId", B_Id).uniqueResult();
		int bprice = tBook.getBprice();
		String Bname = tBook.getBname();
		String bintroduce = tBook.getBintroduce();
		int shouldPay = 0;
		int page = 1;
		if (package_.equals("套餐一")) {
			shouldPay = BNumber * bprice;
			page = 1;
		} else if (package_.equals("套餐二")) {
			shouldPay = BNumber * (bprice + 15);
			page = 2;
		} else {
			shouldPay = BNumber * (bprice + 30);
			page = 3;
		}
		TBook tbook = (TBook) session
				.createQuery("select tbook from TBook tbook where B_Id= :sid")
				.setParameter("sid", B_Id).uniqueResult();
		int SId = tbook.getTSeller().getSId();
		TSeller seller = (TSeller) session
				.createQuery("select ts from TSeller ts where SId=:Sid")
				.setParameter("Sid", SId).uniqueResult();
		Transaction transaction = session.beginTransaction();
		TCar tCar = new TCar();
		String bPicture = tbook.getBpicture();
		String Sname = seller.getSname();
		tCar.setBpicture(bPicture);
		tCar.setUId(UId);
		tCar.setBname(Bname);
		tCar.setBnumber(BNumber);
		tCar.setPackage_(page);
		tCar.setShouldpay(shouldPay);
		tCar.setIntroduce(bintroduce);
		TSvaeBook tSvaeBook = (TSvaeBook) session
				.createQuery(
						"select ts from TSvaeBook ts where bname=:bname and Sname=:Sname")
				.setParameter("bname", Bname).setParameter("Sname", Sname)
				.uniqueResult();
		int saveCount = tSvaeBook.getBooksave();
		if (saveCount > BNumber) {
			tCar.setTBook(tbook);
			session.save(tCar);
			flag = 1;
			transaction.commit();
			session.close();
			return flag;
		} else
			return flag;
	}

	@Override
	public int car_Add(int pageNo, int CId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		TCar tCar = (TCar) session
				.createQuery("select ts from TCar ts where CId=:CId")
				.setParameter("CId", CId).uniqueResult();
		int UId = tCar.getUId();
		String Bname = tCar.getBname();
		int BId = tCar.getTBook().getBId();
		TBook tBook = (TBook) session
				.createQuery(
						"select ts from TBook ts where BId=:BId and Bname=:Bname")
				.setParameter("BId", BId).setParameter("Bname", Bname)
				.uniqueResult();
		int bprice = tBook.getBprice();
		int bnumber = tCar.getBnumber();
		bnumber = bnumber + 1;
		int package_ = tCar.getPackage_();
		int shouldPay = 0;
		if (package_ == 1) {
			shouldPay = bnumber * bprice;
		} else if (package_ == 2) {
			shouldPay = bnumber * (bprice + 15);
		} else {
			shouldPay = bnumber * (bprice + 30);
		}
		tCar.setBnumber(bnumber);
		tCar.setShouldpay(shouldPay);
		session.save(tCar);
		flag = 1;
		transaction.commit();
		Query queryObject = (Query) session.createQuery(
				"select torderTable from TCar torderTable where UId=:UId")
				.setParameter("UId", UId);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("buyer_Car_List", queryObject.list());
		return flag;
	}

	@Override
	public int car_Plus(int pageNo, int CId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		TCar tCar = (TCar) session
				.createQuery("select ts from TCar ts where CId=:CId")
				.setParameter("CId", CId).uniqueResult();
		int UId = tCar.getUId();
		String Bname = tCar.getBname();
		int BId = tCar.getTBook().getBId();
		TBook tBook = (TBook) session
				.createQuery(
						"select ts from TBook ts where BId=:BId and Bname=:Bname")
				.setParameter("BId", BId).setParameter("Bname", Bname)
				.uniqueResult();
		int bprice = tBook.getBprice();
		int bnumber = tCar.getBnumber();
		bnumber = bnumber - 1;
		if (bnumber < 1) {
			return flag;
		}
		int package_ = tCar.getPackage_();
		int shouldPay = 0;
		if (package_ == 1) {
			shouldPay = bnumber * bprice;
		} else if (package_ == 2) {
			shouldPay = bnumber * (bprice + 15);
		} else {
			shouldPay = bnumber * (bprice + 30);
		}
		tCar.setBnumber(bnumber);
		tCar.setShouldpay(shouldPay);
		session.save(tCar);
		flag = 1;
		transaction.commit();
		Query queryObject = (Query) session.createQuery(
				"select torderTable from TCar torderTable where UId=:UId")
				.setParameter("UId", UId);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("buyer_Car_List", queryObject.list());
		return flag;
	}

	@Override
	public List buyer_checkCar(String username, int pageNo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		TUser tuser = (TUser) session
				.createQuery("select tuser from TUser tuser where uname=:uname")
				.setParameter("uname", username).uniqueResult();
		int id = tuser.getUId();
		Query queryObject = (Query) session.createQuery(
				"select torderTable from TCar torderTable where UId= :UId")
				.setParameter("UId", id);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

	@Override
	public int buyer_DelCar_dao(int CId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String sql = "delete from T_Car  where C_Id=:CId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setInteger("CId", CId);
		int i = query.executeUpdate();
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

	@Override
	public int buyer_AddCollectiondao(
			int bid) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TBook tBook = (TBook) session
				.createQuery("select tbook from TBook tbook where BId=:bid")
				.setParameter("bid", bid).uniqueResult();
		String bname = tBook.getBname();
		String btype = tBook.getBtype();
		session.close();
		HttpServletRequest request = ServletActionContext.getRequest();
		String uname = (String) request.getSession().getAttribute("username");
		
		Transaction transaction = session.beginTransaction();
		TFavorites favorites = new TFavorites();
		TBook book = (TBook) session
				.createQuery("select ts from TBook ts where BId=:bid")
				.setParameter("bid", bid).uniqueResult();
		String bPicture = book.getBpicture();
		favorites.setBpicture(bPicture);
		favorites.setBname(bname);
		favorites.setBId(bid);
		favorites.setFavType(btype);
		favorites.setUname(uname);
		session.save(favorites);
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

	@Override
	public List buyer_CheckCollectionList(int pageNo) {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		Session session = HibernateUtils.getSession();
		Query queryObject = (Query) session
				.createQuery(
						"select torderTable from TFavorites torderTable where Uname= :uname")
				.setParameter("uname", username);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

	@Override
	public int buyer_DelBookCollection(int FId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String sql2 = "delete from T_Favorites  where F_Id=:FId";
		SQLQuery query2 = session.createSQLQuery(sql2);
		query2.setInteger("FId", FId);
		int i2 = query2.executeUpdate();
		flag = i2;

		transaction.commit();
		session.close();
		return flag;
	}

	// 买家评价功能
	@Override
	public int Ev(int OId, String quality, String dispatching,
			String diservice, String sname, String uname, String bname,
			String uevaluate) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TSeller seller = (TSeller) session
				.createQuery("from TSeller where sname=:sname")
				.setParameter("sname", sname).uniqueResult();
		int sid = seller.getSId();
		TUser user = (TUser) session
				.createQuery("from TUser where uname=:uname")
				.setParameter("uname", uname).uniqueResult();
		int uid = user.getUId();
		TBook book = (TBook) session
				.createQuery(
						"from TBook where bname=:bname and TSeller.SId=:sid")
				.setParameter("bname", bname).setParameter("sid", sid)
				.uniqueResult();
		int bid = book.getBId();
		Transaction transaction = session.beginTransaction();
		TEvaluate evaluate = new TEvaluate();
		evaluate.setBId(bid);
		evaluate.setBname(bname);
		evaluate.setDiservice(diservice);
		evaluate.setOId(OId);
		evaluate.setQuality(quality);
		evaluate.setSId(sid);
		evaluate.setSname(sname);
		evaluate.setDispatching(dispatching);
		evaluate.setUevaluate(uevaluate);
		evaluate.setUId(uid);
		evaluate.setUname(uname);
		session.save(evaluate);
		flag = 1;
		TOrderTable orderTable = (TOrderTable) session
				.createQuery("from TOrderTable where OId=:OId")
				.setParameter("OId", OId).uniqueResult();
		orderTable.setLogistics("买家已评价");
		session.save(orderTable);
		transaction.commit();
		session.close();
		return flag;
	}

	@Override
	public List pageCheckEV(int BId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		List query = session.createQuery("from TEvaluate where BId=:BId")
				.setParameter("BId", BId).list();
		return query;
	}

	@Override
	public int Buyer_Addpay(int BId,int Money,int TCount,int setmeals) {
		
		// TODO Auto-generated method stub
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
				.createQuery("select tuser from TBook tuser where BId=:BId")
				.setParameter("BId", BId).uniqueResult();
		String bpicture = tBook.getBpicture();
		int id = tBook.getTSeller().getSId();
		String bname = tBook.getBname();
		TSeller tSeller = (TSeller) session
				.createQuery("select ts from TSeller ts where SId=:id")
				.setParameter("id", id).uniqueResult();
		String Sname = tSeller.getSname();
		session.close();
		
		if ("是".equals(vip)) {
			Money = (int) (Money * 0.9);
		}
		TPay pay = new TPay();
		pay.setBId(BId);
		pay.setBpicture(bpicture);
		pay.setMOney(Money);
		pay.setPackage_(setmeals);
		pay.setPayState("未付款");
		pay.setSId(id);
		pay.setSname(Sname);
		pay.setTcount(TCount);
		pay.setUId(UId);
		pay.setUname(username);
		pay.setBname(bname);
		request.getSession().setAttribute("pay", pay);
		ActionContext ac = ActionContext.getContext();
		ac.getSession().put("vip", vip);
		return 0;
	}

}
