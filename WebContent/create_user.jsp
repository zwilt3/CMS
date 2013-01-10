<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="common.*,servlets.*,users.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>Create User</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
</head>
<body>

	<h1>Create a User</h1>
	<br>
	<br>
	<form action="<%=Links.CREATE_USER_SERVLET%>" method="post">
		Full Name:<textarea rows="1" cols="40" name="<%=CreateUserServlet.USER_NAME_PARAM_NAME%>"></textarea><br>
		Email:<textarea rows="1" cols="40" name="<%=CreateUserServlet.EMAIL_PARAM_NAME%>"></textarea><br>
		Password:<textarea rows="1" cols="40" name="<%=CreateUserServlet.PASSWORD_PARAM_NAME%>"></textarea><br>
		<input type="submit" value="Create User" />
	</form>
	
	<h3>User List</h3>
	<ul>
		<%
		for (User u : new UserDaoJpaImpl().getAllUsers()){%>
			<li><%=u.toString()%></li>
		<%}%>
	</ul>

</body>
</html>