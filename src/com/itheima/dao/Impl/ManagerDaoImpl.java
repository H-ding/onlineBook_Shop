package com.itheima.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.dao.ManagerDao;
import com.itheima.domain.TBook;
import com.itheima.domain.TMainPageBook;
import com.itheima.domain.TManager;
import com.itheima.domain.TSeller;
import com.itheima.utils.HibernateUtils;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List checkAllList(int pageNo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query query = (Query) session.createQuery("from TOrderTable");
		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

	@Override
	public List checkBookList(int pageNo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query query = (Query) session.createQuery("select ts from TBook ts");
		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

	@Override
	public boolean DelOrderdao(int O_Id) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory sessionFactory = (SessionFactory) context
				.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		String sql = "delete from T_OrderTable where O_Id='" + O_Id + "'";
		SQLQuery query = session.createSQLQuery(sql);
		// query.setInteger("O_Id", O_Id);
		query.executeUpdate();
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	public int tManager_UpdatePassworddao(String username, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		TManager manager = (TManager) session
				.createQuery(
						"select ts from TManager ts where username=:username")
				.setParameter("username", username).uniqueResult();
		String oldPasswd = manager.getPassword();
		if (oldpassword.equals(oldPasswd)) {
			Transaction transaction = session.beginTransaction();
			manager.setPassword(newpassword);
			session.save(manager);
			flag = 1;
			transaction.commit();
			session.close();
			return flag;
		} else
			return flag;
	}

	@Override
	public List Manager_CheckMount() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		List list = session.createQuery("select ts from TUser ts").list();
		int userList = list.size();
		List list1 = session.createQuery("select ts from TSeller ts").list();
		int salerList = list1.size();
		List list2 = new ArrayList();
		list2.add(userList);
		list2.add(salerList);
		return list2;
	}

	@Override
	public List ManagerChackSlarList(int pageNo) {
		// TODO Auto-generated method stub'
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("from TSeller");
		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

	@Override
	public List ManagerChackBuyerList(int pageNo) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery("from TUser");
		query.setFirstResult((pageNo - 1) * 20);
		query.setMaxResults(20);
		return query.list();
	}

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

	@Override
	public int addMainPageBookList(int BId, int SId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		List<TMainPageBook> list = session.createQuery("from TMainPageBook")
				.list();
		if (list.size() >= 8) {
			return flag;
		}
		for (TMainPageBook tMainPageBook : list) {
			if (BId == tMainPageBook.getBId())
				return flag;
		}
		Transaction transaction = session.beginTransaction();
		TBook book = (TBook) session
				.createQuery("from TBook where TSeller.SId=:SId and BId=:BId")
				.setParameter("SId", SId).setParameter("BId", BId)
				.uniqueResult();
		TSeller tSeller = (TSeller) session
				.createQuery("from TSeller where SId=:SId")
				.setParameter("SId", SId).uniqueResult();
		TMainPageBook mainPageBook = new TMainPageBook();
		mainPageBook.setBId(BId);
		mainPageBook.setBauthor(book.getBauthor());
		mainPageBook.setBdate(book.getBdate());
		mainPageBook.setBintroduce(book.getBintroduce());
		mainPageBook.setBname(book.getBname());
		mainPageBook.setBnumber(book.getBnumber());
		mainPageBook.setBpicture(book.getBpicture());
		mainPageBook.setBpress(book.getBpress());
		mainPageBook.setBprice(book.getBprice());
		mainPageBook.setBtype(book.getBtype());
		mainPageBook.setTSeller(tSeller);
		session.save(mainPageBook);
		flag = 1;
		transaction.commit();
		session.close();
		return flag;
	}

	@Override
	public List checkMainPageBookList() {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		List list = session.createQuery("from TMainPageBook").list();
		return list;
	}

	@Override
	public int delMainPageBook(int mpId) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		String sql2 = "delete from T_MainPageBook  where MP_id=:mpId";
		SQLQuery query2 = session.createSQLQuery(sql2);
		query2.setInteger("mpId", mpId);
		int i2 = query2.executeUpdate();
		transaction.commit();
		session.close();
		return i2;
	}

	@Override
	public int updateBookSeconddao(int SId, int Bid, String bname,
			String bauthor, int bprice, int bnumber, String btype,
			String bdate, String bpress, String bintroduce) {
		// TODO Auto-generated method stub
		int flag = 0;
		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		List<TBook> bookList = session
				.createQuery(
						"select ts from TBook ts where TSeller.SId=:id"
								+ " and BId!=:Bid)").setParameter("id", SId)
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
}
