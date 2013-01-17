package login.testing;

import javax.servlet.http.Cookie;

import login.UserLogin;

import org.junit.Test;

import users.User;

import common.testing.DummyData;

public class UserLoginTest{
	
	/**
	 * Test basic successful login
	 */
	@Test
	public void testDoLogin1(){
		User user = DummyData.fakeUsers.get(0);
		Cookie loginCookie = UserLogin.doLogin(user.getEmail(), user.getPassword());
		assert(loginCookie != null && !loginCookie.getValue().isEmpty());
	}
	
	/**
	 * Test invalid password
	 */
	@Test
	public void testDoLogin2(){
		User user = DummyData.fakeUsers.get(0);
		Cookie loginCookie = UserLogin.doLogin(user.getEmail(), user.getPassword() + "x");
		assert(loginCookie == null);
	}
	
	/**
	 * Test invalid username
	 */
	@Test
	public void testDoLogin3(){
		User user = DummyData.fakeUsers.get(0);
		Cookie loginCookie = UserLogin.doLogin(user.getEmail()+"x", user.getPassword());
		assert(loginCookie == null);
	}
	
	
}
