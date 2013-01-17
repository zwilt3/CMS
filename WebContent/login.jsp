<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="common.*,servlets.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>Login</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
</head>
<body>

	<h1>Login</h1>
	<br>
	<br>
	<form action="<%=Links.LOGIN_SERVLET%>" method="post">
		<h3>Email or Username:</h3>
		<textarea rows="1" cols="40" name="<%=LoginServlet.USERNAME_PARAM_NAME%>"></textarea><br>
		<h3>Password:</h3>
		<textarea rows="1" cols="40" name="<%=LoginServlet.PASSWORD_PARAM_NAME%>"></textarea><br>
		<input type="submit" value="Log In" />
	</form>
	
		
	<h3>Logged In Users:</h3>
	<ul>

	</ul>

</body>
</html>