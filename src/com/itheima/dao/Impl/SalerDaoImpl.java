package com.itheima.dao.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.itheima.dao.SalerDao;
import com.itheima.domain.TBook;
import com.itheima.domain.TSeller;
import com.itheima.domain.TSvaeBook;
import com.itheima.utils.HibernateUtils;

public class SalerDaoImpl implements SalerDao {

	// 查询图书列表

	@Override
	public List checkBook(int pageNo, int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query queryObject = (Query) session.createQuery(
				"select tbook from TBook tbook where S_Id= :sid").setParameter(
				"sid", id);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

	// 查看店铺销售额

	@Override
	public List checkSale(int pageNo, String username) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query query = (Query) session.createQuery(
				"select ts from TPay ts where sname=:sname").setParameter(
				"sname", username);

		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

	// 下架图书
	@Override
	public int deleteBookdao(int BId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TBook tbook = (TBook) session
				.createQuery("select tbook from TBook tbook where B_Id=:BId")
				.setParameter("BId", BId).uniqueResult();
		String bookName = tbook.getBname();
		int SId = tbook.getTSeller().getSId();
		TSeller tSeller = (TSeller) session
				.createQuery("from TSeller where SId=:SId")
				.setParameter("SId", SId).uniqueResult();
		String sname = tSeller.getSname();
		Transaction transaction = session.beginTransaction();
		String sql = "delete from T_Book  where B_Id=:BId";
		SQLQuery query = session.createSQLQuery(sql);
		query.setInteger("BId", BId);
		int i = query.executeUpdate();

		String sql2 = "delete from T_SvaeBook  where BName=:BName and sname=:sname";
		SQLQuery query2 = session.createSQLQuery(sql2);
		query2.setString("BName", bookName).setParameter("sname", sname);
		int i2 = query2.executeUpdate();
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

	// 发货功能
	@Override
	public int delivery(int OId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update TOrderTable tseller set tseller.logistics=:logistics where tseller.OId=:OId";
		Query queryupdate = session.createQuery(hql)
				.setParameter("logistics", "卖家已发货").setParameter("OId", OId);
		int ret = queryupdate.executeUpdate();
		transaction.commit();
		session.close();
		return ret;
	}

	// 查看店铺所有订单信息
	@Override
	public List lookOrderListdao(int pageNo, int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query queryObject = (Query) session
				.createQuery(
						"select torderTable from TOrderTable torderTable where S_Id= :sid")
				.setParameter("sid", id);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

	// 更新图书信息
	// 1 查询出图书的信息
	@Override
	public TBook updateBookdao(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		TBook list = (TBook) session
				.createQuery("select tbook from TBook tbook where B_Id= :sid")
				.setParameter("sid", id).uniqueResult();
		return list;
	}

	// 2 将页面修改的信息提交到数据库
	@Override
	public int updateBookSeconddao(int Bid, String bname, String bauthor,
			int bprice, int bnumber, String btype, String bdate, String bpress,
			String bintroduce) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		TSeller seller = (TSeller) session
				.createQuery("select ts from TSeller ts where sname=:sname")
				.setParameter("sname", username).uniqueResult();
		int id = seller.getSId();
		List<TBook> bookList = session
				.createQuery(
						"select ts from TBook ts where TSeller.SId=:id"
								+ " and BId!=:Bid)").setParameter("id", id)
				.setParameter("Bid", Bid).list();
		for (TBook tBook : bookList) {
			String Bname = tBook.getBname();
			if (bname.equals(Bname)) {
				return flag;
			}
		}
		Transaction transaction = session.beginTransaction();
		String hql = "update TBook tbook set"
				+ " tbook.bname=:bname,tbook.bauthor=:bauthor,tbook.bprice=:bprice, "
				+ "tbook.bnumber=:bnumber,tbook.btype=:btype,tbook.bdate=:bdate,tbook.bpress=:bpress"
				+ ",tbook.bintroduce=:bintroduce where tbook.BId=:Bid";
		Query queryupdate = session.createQuery(hql)
				.setParameter("bname", bname).setParameter("bauthor", bauthor)
				.setParameter("bprice", bprice)
				.setParameter("bnumber", bnumber).setParameter("btype", btype)
				.setParameter("bdate", bdate).setParameter("bpress", bpress)
				.setParameter("bintroduce", bintroduce)
				.setParameter("Bid", Bid);
		int ret = queryupdate.executeUpdate();
		String bookNoUpdateName = (String) request.getSession().getAttribute(
				"bookNoUpdateName");
		String hql2 = "update TSvaeBook t_SvaeBook set t_SvaeBook.bname=:bname"
				+ ",t_SvaeBook.booksave=:bnumber where t_SvaeBook.bname=:Secondbname";
		Query queryupdate1 = session.createQuery(hql2)
				.setParameter("bname", bname).setParameter("bnumber", bnumber)
				.setParameter("Secondbname", bookNoUpdateName);
		int ret1 = queryupdate1.executeUpdate();
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

	@Override
	public int updatePassworddao(String username, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TSeller tSeller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where sname = :username")
				.setParameter("username", username).uniqueResult();
		if (tSeller.getSpasswd().equals(oldpassword)) {
			Transaction transaction = session.beginTransaction();
			String hql = "update TSeller tseller set tseller.spasswd=:newpassword where tseller.sname=:username";
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

	@Override
	public int uploadBookdao(String photoFileName, String bname,
			String bauthor, int bprice, int bnumber, String btype,
			String bdate, String bpress, String bintroduce) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		TSeller tseller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where sname = :sname")
				.setParameter("sname", username).uniqueResult();
		int id = tseller.getSId();
		List<TBook> list = session
				.createQuery(
						"select tbook from TBook tbook where TSeller.SId=:id")
				.setParameter("id", id).list();
		for (TBook tBook : list) {
			if (bname.equals(tBook.getBname())) {
				return flag;
			}
		}
		Transaction transaction = session.beginTransaction();
		TBook tbook = new TBook();
		tbook.setBpicture(photoFileName);
		tbook.setBname(bname);
		tbook.setBauthor(bauthor);
		tbook.setBprice(bprice);
		tbook.setBnumber(bnumber);
		tbook.setBtype(btype);
		tbook.setBdate(bdate);
		tbook.setBpress(bpress);
		tbook.setBintroduce(bintroduce);
		tbook.setTSeller(tseller);
		session.save(tbook);
		TSvaeBook tSvaeBook = new TSvaeBook();
		tSvaeBook.setBname(bname);
		tSvaeBook.setSname(username);
		tSvaeBook.setBooksave(bnumber);
		session.save(tSvaeBook);
		flag = 1;
		transaction.commit();
		return flag;

	}

	@Override
	public List checkDelibery(int pageNo) {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		Session session = HibernateUtils.getSession();
		Query queryObject = (Query) session
				.createQuery(
						"select torderTable from TOrderTable torderTable where sname=:username and logistics=:logistics")
				.setParameter("username", username)
				.setParameter("logistics", "等待卖家发货");
		List list = session
				.createQuery(
						"select ts from TOrderTable ts where ts.logistics=:logistics and ts.sname=:username")
				.setParameter("logistics", "等待卖家发货")
				.setParameter("username", username).list();
		int list_Size = list.size();
		request.getSession().setAttribute("list_Size", list_Size);
		queryObject.setFirstResult((pageNo - 1) * 20);
		queryObject.setMaxResults(20);
		return queryObject.list();
	}

	@Override
	public int updateMassagedao(String username, String Introduce,
			String SAddress) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "update TSeller tseller set tseller.sintroduce=:sintroduce,tseller.saddress=:saddress where tseller.sname=:username";
		Query queryupdate = session.createQuery(hql)
				.setParameter("sintroduce", Introduce)
				.setParameter("saddress", SAddress)
				.setParameter("username", username);
		int ret = queryupdate.executeUpdate();
		flag = 1;
		transaction.commit();
		return flag;
	}

}
