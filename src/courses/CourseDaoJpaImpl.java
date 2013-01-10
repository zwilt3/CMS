package courses;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import users.User;

public class CourseDaoJpaImpl implements CourseDao{

	private static final String PERSISTENCE_UNIT_NAME = "courses";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	
	public CourseDaoJpaImpl(){
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clearAllCourses(){
		EntityManager em = factory.createEntityManager();
		Query q	= em.createQuery("SELECT c FROM Course c");
		List<Course> courseList = q.getResultList();
		for (Course c : courseList){
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
		}
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Course getCourse(long courseId){
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT c from Course AS c where c.id = :courseId");
		q.setParameter("courseId", courseId);
		List<Course> courses = q.getResultList();
		em.close();
		if (courses.size() != 1){
			throw new RuntimeException("Could not find course with id " + courseId + ".");
		}
		return courses.get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> getAllCourses(){
		EntityManager em = factory.createEntityManager();
		Query q	= em.createQuery("SELECT c FROM Course c");
		List<Course> courseList = q.getResultList();
		return courseList;
	}
	
	@Override
	public void enrollUsers(long courseId, List<User> newUsers) {
		Course course = getCourse(courseId);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		course.getEnrolledUsers().addAll(newUsers);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void createCourse(Course course){
		EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(course);
	    em.getTransaction().commit();
	    em.close();
	}
	
	@Override
	public List<User> getEnrolledUsers(Long courseId){
		return getCourse(courseId).getEnrolledUsers();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getEnrolledUsers(String courseName){
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT c from Course AS c where c.name = :courseName");
		q.setParameter("courseName", courseName);
		List<Course> courses = q.getResultList();
		em.close();
		if (courses.size() > 1){
			throw new RuntimeException("Multiple courses with same name.");
		}
		if (courses.isEmpty()){
			throw new RuntimeException("Could not find course with name " + courseName + ".");
		}
		return courses.get(0).getEnrolledUsers();
	}

	public static void main(String[] args){
		CourseDaoJpaImpl courseDao = new CourseDaoJpaImpl();
		System.out.println(courseDao.getAllCourses());
		courseDao.clearAllCourses();
		System.out.println(courseDao.getAllCourses());
	}




}
