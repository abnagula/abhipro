package org.cap.dao;

import java.time.LocalDate;
import java.util.List;

import org.cap.model.LoginBean;
import org.cap.model.PassRequestForm;
import org.cap.model.Routetable;
import org.cap.model.TransactionBean;

public interface ILoginDAO {
	public abstract boolean checkUser(LoginBean loginBean);
	public abstract PassRequestForm createRequest(PassRequestForm passRequestBean) ;
	public abstract List<Routetable> listAllRoutes();
	public abstract Routetable addRoute(Routetable newroute);
	public abstract List<String> PendingReqServlet();
	
	public abstract List<PassRequestForm> pendingDetails();
	public abstract List<PassRequestForm> pendingDetailsOfEmp(String empid);
	public abstract Integer transaction(TransactionBean transaction);
	public abstract List<TransactionBean> monthlyReport(LocalDate fromDate, LocalDate toDate);
	public abstract List<TransactionBean> getReport(LocalDate from, LocalDate to);

}
