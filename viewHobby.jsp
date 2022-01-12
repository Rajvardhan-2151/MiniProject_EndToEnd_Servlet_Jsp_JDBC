<%@page import="java.util.List"%>
<%@page import="com.java.miniproject.db.DBManager"%>
<%@page import="com.java.miniproject.pojo.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Hobby</title>
</head>
<body>

<%
//String uname = (String)request.getAttribute("user");
User nuser = (User)session.getAttribute("user");
String user_name = nuser.getFname() + "  " + nuser.getLname();
%>


Welcome  <%=user_name %>
<br><br>


<h2>Hobby List</h2>
<%

DBManager mgr = new DBManager();
List<String> list = mgr.viewHobby(nuser.getUserid());


for(String s : list)
{%>
	<p><%=s %></p><br>
<%
}
%>


</body>
</html>