package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.TransactionBean;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;
@WebServlet("/MonthlyReportServlet")
public class MonthlyReportServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
			private ILoginService busservice=new LoginServiceImpl();
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
				String fromdate=request.getParameter("fromDate");
				String todate=request.getParameter("toDate");
				
				
				String[] datepart=fromdate.split("-");
				LocalDate from= LocalDate.of(Integer.parseInt(datepart[0]), 
						Integer.parseInt(datepart[1]), Integer.parseInt(datepart[2]));
				
				
				String[] part=todate.split("-");
				LocalDate to= LocalDate.of(Integer.parseInt(part[0]), 
						Integer.parseInt(part[1]), Integer.parseInt(part[2]));
			
				
				List<TransactionBean> list=busservice.getReport(from,to);
				System.out.println(list);
				
				PrintWriter pw=response.getWriter();
				

				pw.println("<html><body><h3 align='center'>PendingRequest Details</h3>");
				pw.println("<table>"
						+ "<tr>"
						+ "<th>Transaction Id </th>"
						+ "<th>Employee Id </th>"
						+"<th>TransactionDate </th>"
						+"<th>Km </th>"
						+"<th>Monthly Fare </th>"
						+"<th>RouteId </th>"
						+ "</tr>");

				for(TransactionBean ts:list) {
					pw.println("<tr>"
							+ "<td>"+ts.getTransaction_id()+"</td>"
							+ "<td>"+ts.getEmp_id()+"</td>"
							+ "<td>"+ts.getTransaction_date()+"</td>"
							+ "<td>"+ts.getTotal_km()+"</td>"
							+ "<td>"+ts.getMonthly_fare()+"</td>"
							+ "<td>"+ts.getRoute_id()+"</td>"
							+"</tr>"
							);
					
				}
				pw.println("</table></body></html>");
				
			} 
		 



}
