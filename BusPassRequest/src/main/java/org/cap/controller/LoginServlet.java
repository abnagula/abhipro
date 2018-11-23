package org.cap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cap.model.LoginBean;
import org.cap.service.ILoginService;
import org.cap.service.LoginServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("userpassword");
		LoginBean loginBean=new LoginBean(username,password);
		ILoginService loginService = new LoginServiceImpl();
		if(loginService.checkUser(loginBean)) {
			response.sendRedirect("pages/menu.html");
		}
		else {
			
			pw.println("You have entered wrong username or password");
            RequestDispatcher rd=request.getRequestDispatcher("index1.html");
            rd.include(request, response);    
		}
	}
}
		
	