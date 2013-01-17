package common.testing;

import java.util.ArrayList;
import java.util.List;

import users.User;
import users.UserDao;
import users.UserDaoJpaImpl;
import courses.Course;
import courses.CourseDao;
import courses.CourseDaoJpaImpl;

public class DummyData {
	
	public static List<User> fakeUsers = new ArrayList<User>();
	public static List<Course> fakeCourses = new ArrayList<Course>();
	
	static{
		for (int i = 1; i < 6; i++){
			User user = new User("Fake Name " + i, "fake" + i + "@fake.com", "fake" + i);
			fakeUsers.add(user);
		}
		
		for (int i = 1; i < 4; i++){
			Course course = new Course("Fake Course " + i);
			fakeCourses.add(course);
		}
	}
	

	public static void main(String[] args){
		UserDao userDao = new UserDaoJpaImpl();
		CourseDao courseDao = new CourseDaoJpaImpl();
		
		for (User user : fakeUsers){
			userDao.createUser(user);
		}
		System.out.println("Users = " + userDao.getAllUsers());
		
		for (Course course : fakeCourses){
			courseDao.createCourse(course);
		}
				
		courseDao.enrollUsers(fakeCourses.get(0), fakeUsers);
		for (int i = 0; i < fakeUsers.size(); i+=2){
			courseDao.enrollUser(fakeCourses.get(1), fakeUsers.get(i));
		}
		for (int i = 0; i < fakeUsers.size(); i+=3){
			courseDao.enrollUser(fakeCourses.get(2), fakeUsers.get(i));
		}
		
		for (Course c : fakeCourses){
			System.out.println(c);
		}
		
	}
}
