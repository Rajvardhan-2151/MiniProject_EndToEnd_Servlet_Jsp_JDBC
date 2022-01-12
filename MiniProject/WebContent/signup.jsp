<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  action="AddUserServlet">

Enter Firstname  :   <input type="text" id="firstname" name="firstname"/><br>
Enter Lastname  :   <input type="text" id="lastname" name="lastname"/><br>
Enter Email-Address  :   <input type="text" id="email"  name="email"/><br>
Enter Mobile.No    :   <input type="text" id="mobile" name="mobile"/><br>
Enter Username    :   <input type="text" id="uname" name="uname"/><br>
Enter PassWord    :    <input type="text" id="pass" name="pass"/><br>

<input type="submit"  value="submit"/>

</form>

</body>
</html>