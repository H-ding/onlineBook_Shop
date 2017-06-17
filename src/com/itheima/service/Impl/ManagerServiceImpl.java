package com.itheima.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.ManagerDao;
import com.itheima.service.ManagerService;

@Transactional
public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List checkAllList(int pageNo) {
		// TODO Auto-generated method stub
		return managerDao.checkAllList(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List checkBookList(int pageNo) {
		// TODO Auto-generated method stub
		return managerDao.checkBookList(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean DelOrderdao(int O_Id) {
		// TODO Auto-generated method stub
		return managerDao.DelOrderdao(O_Id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int tManager_UpdatePassworddao(String username, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		return managerDao.tManager_UpdatePassworddao(username, oldpassword,
				newpassword);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List Manager_CheckMount() {
		// TODO Auto-generated method stub
		return managerDao.Manager_CheckMount();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List ManagerChackSlarList(int pageNo) {
		// TODO Auto-generated method stub
		return managerDao.ManagerChackSlarList(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List ManagerChackBuyerList(int pageNo) {
		// TODO Auto-generated method stub
		return managerDao.ManagerChackBuyerList(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List checkSale(int pageNo, String username) {
		// TODO Auto-generated method stub
		return managerDao.checkSale(pageNo, username);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int addMainPageBookList(int BId, int SId) {
		// TODO Auto-generated method stub
		return managerDao.addMainPageBookList(BId, SId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List checkMainPageBookList() {
		// TODO Auto-generated method stub
		return managerDao.checkMainPageBookList();
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int delMainPageBook(int mpId) {
		// TODO Auto-generated method stub
		return managerDao.delMainPageBook(mpId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int updateBookSeconddao(int SId, int Bid, String bname,
			String bauthor, int bprice, int bnumber, String btype,
			String bdate, String bpress, String bintroduce) {
		// TODO Auto-generated method stub
		return managerDao.updateBookSeconddao(SId, Bid, bname, bauthor, bprice,
				bnumber, btype, bdate, bpress, bintroduce);
	}

}
