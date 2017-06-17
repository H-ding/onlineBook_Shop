package com.itheima.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.SalerDao;
import com.itheima.domain.TBook;
import com.itheima.service.SalerService;

public class SalerServiceImpl implements SalerService {
	private SalerDao salerDao;

	public SalerDao getSalerDao() {
		return salerDao;
	}

	public void setSalerDao(SalerDao salerDao) {
		this.salerDao = salerDao;
	}

	@Override
	public List checkBook(int pageNo, int id) {
		// TODO Auto-generated method stub
		return salerDao.checkBook(pageNo, id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List checkSale(int pageNo, String username) {
		// TODO Auto-generated method stub
		return salerDao.checkSale(pageNo, username);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int deleteBookdao(int BId) {
		// TODO Auto-generated method stub
		return salerDao.deleteBookdao(BId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int delivery(int OId) {
		// TODO Auto-generated method stub
		return salerDao.delivery(OId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List lookOrderListdao(int pageNo, int id) {
		// TODO Auto-generated method stub
		return salerDao.lookOrderListdao(pageNo, id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public TBook updateBookdao(int id) {
		// TODO Auto-generated method stub
		return salerDao.updateBookdao(id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int updateBookSeconddao(int Bid, String bname, String bauthor,
			int bprice, int bnumber, String btype, String bdate, String bpress,
			String bintroduce) {
		// TODO Auto-generated method stub
		return salerDao.updateBookSeconddao(Bid, bname, bauthor, bprice,
				bnumber, btype, bdate, bpress, bintroduce);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int updateMassagedao(String username, String Introduce,
			String SAddress) {
		// TODO Auto-generated method stub
		return salerDao.updateMassagedao(username, Introduce, SAddress);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int updatePassworddao(String username, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		return salerDao.updatePassworddao(username, oldpassword, newpassword);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int uploadBookdao(String photoFileName, String bname,
			String bauthor, int bprice, int bnumber, String btype,
			String bdate, String bpress, String bintroduce) {
		// TODO Auto-generated method stub
		return salerDao.uploadBookdao(photoFileName, bname, bauthor, bprice,
				bnumber, btype, bdate, bpress, bintroduce);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List checkDelibery(int pageNo) {
		// TODO Auto-generated method stub
		return salerDao.checkDelibery(pageNo);
	}

}
