package com.java.miniproject.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	
    public AddUserServlet() {
     
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		
		User nuser = new User();
	  //Fetching Data Coming from html/jsp
		nuser.setFname(request.getParameter("firstname"));
		nuser.setLname( request.getParameter("lastname") );
		nuser.setEmailID(request.getParameter("email"));
		nuser.setMobileNO(request.getParameter("mobile"));
		nuser.setUserName(request.getParameter("uname"));
		nuser.setPassword(request.getParameter("pass"));
		
		DBManager db = new DBManager();
		
		db.createUser(nuser) ;
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
