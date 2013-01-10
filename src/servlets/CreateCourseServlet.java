package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Links;

import courses.Course;
import courses.CourseDaoJpaImpl;

@WebServlet("/CreateCourseServlet")
public class CreateCourseServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public static final String COURSE_NAME_PARAM_NAME = "Course Name";

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseName = request.getParameter(COURSE_NAME_PARAM_NAME);
		Course course = new Course(courseName);
		CourseDaoJpaImpl courseDao = new CourseDaoJpaImpl();
		courseDao.createCourse(course);
		response.sendRedirect(Links.CREATE_COURSE);
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Caches reloaded successfully.");
	}
}
