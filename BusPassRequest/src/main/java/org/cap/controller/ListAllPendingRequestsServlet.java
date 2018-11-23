package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.PassRequestForm;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;

/**
 * Servlet implementation class ListAllPendingRequestsServlet
 */
@WebServlet("/ListAllPendingRequestsServlet")
public class ListAllPendingRequestsServlet extends HttpServlet {
	private ILoginService busservice=new LoginServiceImpl();

	private static final long serialVersionUID = 1L;
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String empid=request.getParameter("empid");

			System.out.println(empid);
			response.setContentType("text/html");

			List<PassRequestForm> pendingList=busservice.pendingDetailsOfEmp(empid);


			PrintWriter pw=response.getWriter();

			pw.println("<html><body><h3 align='center'>PendingRequest Details</h3>");
			pw.println("<table>"
					+ "<tr>"
					+ "<th>Employee Id:</th>"
					+"<th>First Name:</th>"
					+ "</tr>");

			for(PassRequestForm emp:pendingList) {
				pw.println("<tr>"
						+ "<td>"+emp.getEmployeeid()+"</td>"
						+"<input type='hidden' value="+emp.getEmployeeid()+" name='empid'>"
						+ "<td>"+emp.getFirstname()+"</td>"
						+"<td>"+emp.getLastname()+"</td>"
						+"<td>"+emp.getAddress()+"</td>"
						);
			}
			pw.println("<form action='ApprovedServlet'>"
					+ "Route Number: <input type='text' name='routeno'>"
					+ "Total Kilometers:<input type='text' name='totalkm'>"
					+ "Total Fare:<input type='text' name='totalfare'>"
					+"<input type='submit' name='approve' value='Approve'>"
					+"<input type='hidden' value="+empid+" name='empid'>"
					+"</form>"
					);
			pw.println("</table></body></html>");



		}

	}


