package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.Routetable;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;

/**
 * Servlet implementation class ListAllRoutes
 */
@WebServlet("/ListAllRoutes")
public class ListAllRoutes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILoginService loginService=new LoginServiceImpl();
    public ListAllRoutes() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		List<Routetable>routes = loginService.listAllRoutes();
		PrintWriter out = response.getWriter();
		out.println("<h3>All Route Details</h3>"
				+"<table>"
				+"<tr>"
				+"<th>RouteId</th>"
				+"<th>RoutePath</th>"
				+"<th>No.Of Seats Occupied</th>"
				+"<th>Total Seats</th"
				+"<th>BusNo.</th>"
				+"<th>Driver Name</th>"
				+"<th>Total Km</th>"
				+"</tr>");
		for(Routetable route:routes) {
			out.println("<tr>"
					+"<td>"+route.getRoute_id()+"</td>"
					+"<td>"+route.getRoute_path()+"</td>"
					+"<td>"+route.getNo_of_seats_occupied()+"</td>"
					+"<td>"+route.getTotal_seats()+"</td>"
					+"<td>"+route.getBus_no()+"</td>"
					+"<td>"+route.getDriver_name()+"</td>"
					+"<td>"+route.getTotal_km()+"</td>"
					+"</tr>");
			
			
			
		}
				
				
				
				
				
				
		
	}

}
