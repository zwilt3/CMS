<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="common.*,servlets.*,users.*,courses.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<title>Enroll Users in Course</title>
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
</head>
<body>

	<h1>Enroll Users in Course</h1>
	<br>
	<br>
	<form action="<%=Links.ENROLL_USERS_IN_COURSE_SERVLET%>" method="post">
		
		Select a Course:<br>
		<select name="<%=EnrollUsersInCourseServlet.COURSE_ID_PARAM_NAME%>">
			<%for (Course c : new CourseDaoJpaImpl().getAllCourses()){%>
  				<option value="<%=c.getId()%>"><%=c.getName()%></option>
  			<%}%>
		</select>
		<br>
		User Emails:<br>
		<textarea rows="10" cols="60" name="<%=EnrollUsersInCourseServlet.USER_EMAILS_PARAM_NAME%>">(Separated by commas and/or whitespace)</textarea><br>
		<input type="submit" value="Enroll Users" />
	</form>
	<br><br>
	List of enrollments:<br>
	<%for (Course c : new CourseDaoJpaImpl().getAllCourses()){%>
		<h3><%=c.getName() %></h3>
		<ul>
			<%for (User u : c.getEnrolledUsers()){%>
				<%=u.getName()%>
			<%}%>
		</ul>
	<%}%>
			
	
</body>
</html>