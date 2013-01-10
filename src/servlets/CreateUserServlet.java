package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Links;

import users.User;
import users.UserDao;
import users.UserDaoJpaImpl;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String USER_NAME_PARAM_NAME = "User Name";
	public static final String EMAIL_PARAM_NAME = "Email";
	public static final String PASSWORD_PARAM_NAME = "Password";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(USER_NAME_PARAM_NAME);
		String email = request.getParameter(EMAIL_PARAM_NAME);
		String password = request.getParameter(PASSWORD_PARAM_NAME);
		User user = new User(userName, email, password);
		UserDao userDao = new UserDaoJpaImpl();
		userDao.createUser(user);
		response.sendRedirect(Links.CREATE_USER);
	}

}
