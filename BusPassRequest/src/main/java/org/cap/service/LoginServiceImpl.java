package org.cap.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.cap.dao.ILoginDAO;
import org.cap.dao.LoginDAO;
import org.cap.model.LoginBean;
import org.cap.model.PassRequestForm;
import org.cap.model.Routetable;
import org.cap.model.TransactionBean;

public class LoginServiceImpl implements ILoginService {
	ILoginDAO loginDAO = new LoginDAO();
	@Override
	public boolean checkUser(LoginBean loginBean) {
		if(loginDAO.checkUser(loginBean)) {
			return true;
		}else {
			return false;
		}
		
		
	}
	@Override
	public PassRequestForm createRequest(PassRequestForm busBean) {
		if(loginDAO.createRequest(busBean) != null)
			return busBean;
      return null;
		
	}
	@Override
	public List<Routetable> listAllRoutes() {
		List<Routetable> routeList=new ArrayList<>();
		routeList = loginDAO.listAllRoutes();
		return routeList;
	}
	@Override
	public Routetable addRoute(Routetable newroute) {
		if(loginDAO.addRoute(newroute)!=null) {
			return newroute;
		}
		return null;
	}
	@Override
	public List<String> PendingReqServlet() {
		List<String> list=new ArrayList<>();
		list=loginDAO.PendingReqServlet();
		return list;
	}
	@Override
	public List<PassRequestForm> pendingDetails() {
		List<PassRequestForm> pendingList=loginDAO.pendingDetails();
		if(pendingList!=null)
			return pendingList;
		
		return null;
		
	}
	@Override
	public List<PassRequestForm> pendingDetailsOfEmp(String empid) {
		List<PassRequestForm> pendingList=loginDAO.pendingDetailsOfEmp(empid);
		if(pendingList!=null)
			return pendingList;
		return null;
	}
	@Override
	public Integer transaction(TransactionBean transaction) {
		Integer transaction_id=loginDAO.transaction(transaction);
		return transaction_id;
	}
	@Override
	public List<TransactionBean> monthlyReport(LocalDate fromDate, LocalDate toDate) {
		
		List<TransactionBean> tBean=loginDAO.monthlyReport(fromDate, toDate);
		if(tBean!=null)
			return tBean;
		return null;
	}
	@Override
	public List<TransactionBean> getReport(LocalDate from, LocalDate to) {
		return loginDAO.getReport(from,to); 
	
	}

}
