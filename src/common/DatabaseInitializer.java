package common;

import users.UserDao;
import users.UserDaoJpaImpl;
import courses.CourseDao;
import courses.CourseDaoJpaImpl;

public class DatabaseInitializer {
	
	public static void main(String[] args){
		UserDao userDao = new UserDaoJpaImpl();
		userDao.clearAllUsers();
		
		CourseDao courseDao = new CourseDaoJpaImpl();
		courseDao.clearAllCourses();
		
		System.out.println("Databases Wiped.");
		
	}

}
