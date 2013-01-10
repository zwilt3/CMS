package users;

import java.util.List;

public interface UserDao {
	
	public List<User> getAllUsers();
	public User getUser(String email);
	public void clearAllUsers();
	public void createUser(User user);
}
