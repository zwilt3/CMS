<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="common.*,servlets.*,courses.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>Create Course</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
</head>
<body>

	<h1>Create a Course</h1>
	<br>
	<br>
	<form action="<%=Links.CREATE_COURSE_SERVLET%>" method="post">
		<h3>Course Name:</h3>
		<textarea rows="1" cols="40" name="<%=CreateCourseServlet.COURSE_NAME_PARAM_NAME%>"></textarea><br>
		<input type="submit" value="Create Course" />
	</form>
	
		
	<h3>Course List</h3>
	<ul>
		<%
		for (Course c : new CourseDaoJpaImpl().getAllCourses()){%>
			<li><%=c.toString()%></li>
		<%}%>
	</ul>

</body>
</html>