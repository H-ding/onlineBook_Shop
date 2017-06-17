package com.itheima.action;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import com.itheima.domain.TBook;
import com.itheima.domain.TOrderTable;
import com.itheima.domain.TPay;
import com.itheima.domain.TSeller;
import com.itheima.service.SalerService;
import com.itheima.utils.HibernateUtils;
import com.opensymphony.xwork2.ActionSupport;

public class SalerAction extends ActionSupport {
	private int pageNo;
	private Integer BId;
	private TSeller TSeller;
	private String bname;
	private String bauthor;
	private Integer bprice;
	private Integer bnumber;
	private String btype;
	private String bdate;
	private String bpress;
	private String bintroduce;
	private int OId;
	private long UId;
	private String ostate;
	private String logistics;
	private long Sid;
	private String username;
	private String Introduce;
	private String SAddress;
	private String oldpassword;
	private String newpassword;
	private String repeatnewpassword;
	private File photo;
	private String photoFileName;
	private String photoContentType;
	private SalerService salerService;

	public SalerService getSalerService() {
		return salerService;
	}

	public void setSalerService(SalerService salerService) {
		this.salerService = salerService;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
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

	public String getIntroduce() {
		return Introduce;
	}

	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}

	public String getSAddress() {
		return SAddress;
	}

	public void setSAddress(String sAddress) {
		SAddress = sAddress;
	}

	public long getUId() {
		return UId;
	}

	public void setUId(long uId) {
		UId = uId;
	}

	public String getOstate() {
		return ostate;
	}

	public void setOstate(String ostate) {
		this.ostate = ostate;
	}

	public String getLogistics() {
		return logistics;
	}

	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}

	public long getSid() {
		return Sid;
	}

	public void setSid(long sid) {
		Sid = sid;
	}

	public int getOId() {
		return OId;
	}

	public void setOId(int oId) {
		OId = oId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getBId() {
		return BId;
	}

	public void setBId(Integer bId) {
		BId = bId;
	}

	public TSeller getTSeller() {
		return TSeller;
	}

	public void setTSeller(TSeller tSeller) {
		TSeller = tSeller;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public Integer getBprice() {
		return bprice;
	}

	public void setBprice(Integer bprice) {
		this.bprice = bprice;
	}

	public Integer getBnumber() {
		return bnumber;
	}

	public void setBnumber(Integer bnumber) {
		this.bnumber = bnumber;
	}

	public String getBtype() {
		return btype;
	}

	public void setBtype(String btype) {
		this.btype = btype;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getBpress() {
		return bpress;
	}

	public void setBpress(String bpress) {
		this.bpress = bpress;
	}

	public String getBintroduce() {
		return bintroduce;
	}

	public void setBintroduce(String bintroduce) {
		this.bintroduce = bintroduce;
	}

	public String checkList() {

		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		@SuppressWarnings("unchecked")
		TSeller tseller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where sname = :username")
				.setParameter("username", username).uniqueResult();
		int id = tseller.getSId();
		@SuppressWarnings("unchecked")
		List booklist = salerService.checkBook(pageNo, id);
		request.getSession().setAttribute("booklist", booklist);
		return SUCCESS;
	}

	public String deleteBook() {
		int flag = 0;
		flag = salerService.deleteBookdao(BId);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String deleteList() {

		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		TSeller tseller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where SName=:username")
				.setParameter("username", username).uniqueResult();
		int id = tseller.getSId();
		Query queryObject = (Query) session.createQuery(
				"select tbook from TBook tbook where S_Id= :sid").setParameter(
				"sid", id);
		queryObject.setFirstResult((pageNo - 1) * 5);
		queryObject.setMaxResults(5);
		request.getSession().setAttribute("queryList", queryObject.list());

		return SUCCESS;
	}

	public String delivery() {
		int flag = 0;
		flag = salerService.delivery(OId);
		if (flag == 1) {
			HttpServletRequest request = ServletActionContext.getRequest();
			int list_Size = (Integer) request.getSession().getAttribute(
					"list_Size");
			list_Size = list_Size - 1;
			request.getSession().setAttribute("list_Size", list_Size);
			return SUCCESS;
		} else
			return INPUT;
	}

	public String lookOrder() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		Session session = HibernateUtils.getSession();
		TSeller tseller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where sname = :sname")
				.setParameter("sname", username).uniqueResult();
		int id = tseller.getSId();
		@SuppressWarnings("unchecked")
		List<TOrderTable> list = salerService.lookOrderListdao(pageNo, id);
		request.setAttribute("list", list);
		return SUCCESS;
	}

	public String updateList() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("BId", BId);
		@SuppressWarnings("unchecked")
		TBook book = salerService.updateBookdao(BId);
		String bookNoUpdateName = book.getBname();
		request.getSession().setAttribute("bookNoUpdateName", bookNoUpdateName);
		request.getSession().setAttribute("book", book);
		return SUCCESS;
	}

	public String updateListSecond() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int BId = (Integer) request.getSession().getAttribute("BId");
		int flag = 0;
		flag = salerService.updateBookSeconddao(BId, bname, bauthor, bprice,
				bnumber, btype, bdate, bpress, bintroduce);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String queryMassage() {

		Session session = HibernateUtils.getSession();
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		@SuppressWarnings("unchecked")
		TSeller tseller = (TSeller) session
				.createQuery(
						"select tseller from TSeller tseller where sname = :username")
				.setParameter("username", username).uniqueResult();
		request.getSession().setAttribute("tseller", tseller);
		session.close();
		return SUCCESS;
	}

	public String updateMassage() {
		int flag = 0;
		flag = salerService.updateMassagedao(username, Introduce, SAddress);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String updatePassword() {
		if (newpassword.equals(repeatnewpassword)) {
			int flag = 0;
			flag = salerService.updatePassworddao(username, oldpassword,
					newpassword);
			if (flag == 1)
				return SUCCESS;
			else
				return INPUT;
		} else
			return INPUT;
	}

	public String upload() throws Exception {

		ServletContext sc = ServletActionContext.getServletContext();
		String directory = sc.getRealPath("/files");

		File target = new File(directory, photoFileName);

		FileUtils.copyFile(photo, target);
		int flag = 0;
		flag = salerService.uploadBookdao(photoFileName, bname, bauthor,
				bprice, bnumber, btype, bdate, bpress, bintroduce);
		if (flag == 1)
			return SUCCESS;
		else
			return INPUT;
	}

	public String checkDelibery() {
		List waitingDeliveryService_list = salerService.checkDelibery(pageNo);
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("waitingDeliveryService_list",
				waitingDeliveryService_list);
		return SUCCESS;
	}

	public String checkSale() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = (String) request.getSession()
				.getAttribute("username");
		List<TPay> Check_Sale_list = salerService.checkSale(pageNo, username);
		request.getSession().setAttribute("Check_Sale_list", Check_Sale_list);
		int CurrentCount = 0;
		for (TPay pay : Check_Sale_list) {
			int money = pay.getMOney();
			CurrentCount = CurrentCount + money;
		}
		request.getSession().setAttribute("CurrentCount", CurrentCount);
		return SUCCESS;
	}
}
