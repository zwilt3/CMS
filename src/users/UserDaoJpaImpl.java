package users;

import java.util.*;
import javax.persistence.*;

public class UserDaoJpaImpl implements UserDao{

	private static final String PERSISTENCE_UNIT_NAME = "users";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
			
	public UserDaoJpaImpl(){
		
	}
	
	@Override
	public void createUser(User user){
		EntityManager em = factory.createEntityManager();
	    em.getTransaction().begin();
	    em.persist(user);
	    em.getTransaction().commit();
	    em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clearAllUsers(){
		EntityManager em = factory.createEntityManager();
		Query q	= em.createQuery("select u from User u");
		List<User> userList = q.getResultList();
		for (User u : userList){
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		}
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers(){
		EntityManager em = factory.createEntityManager();
		Query q	= em.createQuery("select u from User u");
		List<User> userList = q.getResultList();
		em.close();
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User getUser(String email){
		EntityManager em = factory.createEntityManager();
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
		q.setParameter("email", email);
		List<User> users = q.getResultList();
		em.close();
		if (users.size() != 1){
			throw new RuntimeException("Could not find user with email " + email + ".");
		}
		return users.get(0);
	}

	public static void main(String[] args) {
		
		UserDao userDao = new UserDaoJpaImpl();
		System.out.println(userDao.getAllUsers());
		userDao.clearAllUsers();
		System.out.println(userDao.getAllUsers());
	}
}
