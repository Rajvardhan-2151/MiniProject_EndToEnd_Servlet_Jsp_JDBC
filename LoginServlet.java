package com.java.miniproject.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User nuser = new User();
		
		nuser.setUserName(request.getParameter("uname"));
		nuser.setPassword(request.getParameter("pass"));
		
		DBManager db = new DBManager();
		
		if(db.validateUser(nuser) == true)
		{
			//valid user    ...redirect to welcome.jsp
		//	request.setAttribute("user", name);
			HttpSession session = request.getSession();
			session.setAttribute("user", nuser);
			
			ServletContext context = super.getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			//invalid user..... redirect to error.jsp
			ServletContext context = super.getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
