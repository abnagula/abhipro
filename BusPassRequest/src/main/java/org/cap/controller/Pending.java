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
 * Servlet implementation class Pending
 */
@WebServlet("/Pending")
public class Pending extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginService busservice=new LoginServiceImpl();
    public Pending() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		List<PassRequestForm> pendingList=busservice.pendingDetails();


		PrintWriter pw=response.getWriter();
		

		pw.println("<html><body><h3 align='center'>All Pending Requests</h3>");
		pw.println("<table>"
				+ "<tr>"
				
			
				+ "</tr>");

		for(PassRequestForm emp:pendingList) {
			
			pw.println("<form action='ListAllPendingRequestsServlet' method='post'>"
					+ "<p>"+emp.getEmployeeid()+"</p>"
					+"<input type='hidden' value="+emp.getEmployeeid()+" name='empid'>"
					+"<input type='submit' value='View' name='view'>"
					+"</form>"
					
					);
		}

		pw.println("</table></body></html>");

		
		
	}

}
