package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.Routetable;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;

/**
 * Servlet implementation class AddNewRoute
 */
@WebServlet("/AddNewRoute")
public class AddNewRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginService loginService=new LoginServiceImpl();
  
    public AddNewRoute() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String routepath = request.getParameter("routepath");
	String occseats = request.getParameter("occupiedseats");
	String totalseats = request.getParameter("totalseats");
	String busno=request.getParameter("busno");
	String drivername = request.getParameter("drivername");
	String totalkm = request.getParameter("totalkm");
	
	Routetable routeBean = new Routetable();
	routeBean.setRoute_path(routepath);
	routeBean.setNo_of_seats_occupied(Integer.parseInt(occseats));
	routeBean.setTotal_seats(Integer.parseInt(totalseats));
	routeBean.setBus_no(busno);
	routeBean.setDriver_name(drivername);
	routeBean.setTotal_km(Double.parseDouble(totalkm));
	System.out.println(routeBean);
	
	if(loginService.addRoute(routeBean)!= null) {
		response.sendRedirect("pages/addSuccess.html");
	}else {
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Not successfully entered</h1>");
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request, response);
	}
}
}