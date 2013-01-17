package login;

import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;

import users.User;
import users.UserDao;
import users.UserDaoJpaImpl;

public class UserLogin {

	private static final String LOGIN_COOKIE_NAME = "cms-login";

	//Used to keep up with the set of valid cookies for login purposes
	private static Map<String, String> cookieUUIDs = new Hashtable<String, String>();

	/**
	 * Checks that the password matches the username, and returns 
	 * a cookie for successful login.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public static Cookie doLogin(String username, String password){
		UserDao userDao = new UserDaoJpaImpl();
		User user = userDao.getUser(username);

		Cookie cookie = null;
		if (user != null && user.getPassword().equals(password)){
			cookie = new Cookie(LOGIN_COOKIE_NAME, UUID.randomUUID().toString());
			cookie.setComment(username);
			cookieUUIDs.put(username, cookie.getValue());
		}

		return cookie;
	}

	public static boolean loginCookieIsValid(Cookie loginCookie){
		return loginCookie.getValue().equals(cookieUUIDs.get(loginCookie.getComment()));
	}

}
