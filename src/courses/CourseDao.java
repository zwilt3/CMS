package courses;

import java.util.List;

import users.User;

public interface CourseDao {
	
	public void createCourse(Course course);	
	public List<User> getEnrolledUsers(Long courseId);	
	public List<User> getEnrolledUsers(String courseName);
	public void enrollUsers(long courseId, List<User> newUsers);
	public Course getCourse(long courseId);
	public List<Course> getAllCourses();
	public void clearAllCourses();
}
