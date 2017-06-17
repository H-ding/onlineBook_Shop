package com.itheima.service.Impl;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.BuyerDao;
import com.itheima.domain.TPay;
import com.itheima.domain.TUser;
import com.itheima.service.BuyerService;

@Transactional
public class BuyerServiceImpl implements BuyerService {
	private BuyerDao buyerDao;

	public BuyerDao getBuyerDao() {
		return buyerDao;
	}

	public void setBuyerDao(BuyerDao buyerDao) {
		this.buyerDao = buyerDao;
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean BecomeVip(String username) {
		// TODO Auto-generated method stub
		return buyerDao.BecomeVip(username);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int buyer_Buyingdao(int BId, int SId, int UId, int TCount,
			int package_) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_Buyingdao(BId, SId, UId, TCount, package_);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int buyer_AddCar(TPay pay, String address) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_AddCar(pay, address);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List buyer_CheckBookdao(int Bid) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_CheckBookdao(Bid);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List buyer_CheckBookLIstdao(int pageNo) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_CheckBookLIstdao(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List buyer_CheckOrder_ING(int pageNo) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_CheckOrder_ING(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List buyer_CheckOrderListdao(String username, int pageNo) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_CheckOrderListdao(username, pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int sign(int OId) {
		// TODO Auto-generated method stub
		return buyerDao.sign(OId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public TUser queryTUser(String username) {
		// TODO Auto-generated method stub
		return buyerDao.queryTUser(username);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int updateMassagedao(String username, String Address, String tel) {
		// TODO Auto-generated method stub
		return buyerDao.updateMassagedao(username, Address, tel);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int updatePassworddao(String username, String oldpassword,
			String newpassword) {
		// TODO Auto-generated method stub
		return buyerDao.updatePassworddao(username, oldpassword, newpassword);
	}


	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int car_Add(int pageNo, int CId) {
		// TODO Auto-generated method stub
		return buyerDao.car_Add(pageNo, CId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int car_Plus(int pageNo, int CId) {
		// TODO Auto-generated method stub
		return buyerDao.car_Plus(pageNo, CId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List buyer_checkCar(String username, int pageNo) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_checkCar(username, pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int buyer_DelCar_dao(int CId) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_DelCar_dao(CId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int buyer_AddCollectiondao(
			int bid) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_AddCollectiondao( bid);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List buyer_CheckCollectionList(int pageNo) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_CheckCollectionList(pageNo);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int buyer_DelBookCollection(int FId) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_DelBookCollection(FId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int Ev(int OId, String quality, String dispatching,
			String diservice, String sname, String uname, String bname,
			String uevaluate) {
		// TODO Auto-generated method stub
		return buyerDao.Ev(OId, quality, dispatching, diservice, sname, uname,
				bname, uevaluate);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List pageCheckEV(int BId) {
		// TODO Auto-generated method stub
		return buyerDao.pageCheckEV(BId);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int Buyer_Addpay(int BId, int Money, int TCount, int setmeals) {
		// TODO Auto-generated method stub
		return buyerDao.Buyer_Addpay(BId, Money, TCount, setmeals);
	}

	@Override
	public int buyer_AddCardao(int B_Id, int BNumber, String package_) {
		// TODO Auto-generated method stub
		return buyerDao.buyer_AddCardao( B_Id,BNumber, package_);
	}

}
