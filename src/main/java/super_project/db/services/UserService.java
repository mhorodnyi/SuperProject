package super_project.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import super_project.db.models.User;
import super_project.db.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository users;
	
	public User getUser(String id) {
		return users.findById(id).get();
	}
	
	public User setUpdateUser(User user) {
		return users.save(user);
	}
	
	public User deleteUser(String id) {
		User user = users.findById(id).get();
		users.delete(user);
		return user;
	}
}
