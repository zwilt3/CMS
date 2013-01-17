package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import users.User;
import users.UserDao;
import users.UserDaoJpaImpl;

import common.Links;

import courses.CourseDao;
import courses.CourseDaoJpaImpl;

/**
 * Servlet implementation class EnrollUsersInCourseServlet
 */
@WebServlet("/EnrollUsersInCourseServlet")
public class EnrollUsersInCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String COURSE_ID_PARAM_NAME = "Course Name";
	public static final String USER_EMAILS_PARAM_NAME = "User Emails";

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long courseId = Long.parseLong(request.getParameter(COURSE_ID_PARAM_NAME));
		String[] emails = request.getParameter(USER_EMAILS_PARAM_NAME).split("(\\s|,)");
		
		CourseDao courseDao = new CourseDaoJpaImpl();
		UserDao userDao = new UserDaoJpaImpl();
				
		List<User> userList = new ArrayList<User>();
		for (String email : emails){
			User user = userDao.getUser(email);
			userList.add(user);
		}
		courseDao.enrollUsers(courseId, userList);

		response.sendRedirect(Links.ENROLL_USERS_IN_COURSE);
	}
}
