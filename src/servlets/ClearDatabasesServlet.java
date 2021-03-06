package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.UserDao;
import users.UserDaoJpaImpl;
import courses.CourseDao;
import courses.CourseDaoJpaImpl;


@WebServlet("/ClearDatabasesServlet")
public class ClearDatabasesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDaoJpaImpl();
		userDao.clearAllUsers();
		CourseDao courseDao = new CourseDaoJpaImpl();
		courseDao.clearAllCourses();
		response.getWriter().println("All databases cleared.");
	}

}
