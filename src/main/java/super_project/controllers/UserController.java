package super_project.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import super_project.db.services.UserService;
import super_project.utils.FullUser;
import super_project.db.models.User;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	@Autowired
	UserService users;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping("/{id}")
	public FullUser getUser(@PathVariable("id") String id) {
		return mapper.map(users.getUser(id), FullUser.class); 
	}
	
	@PutMapping
	public FullUser updateUser(@RequestBody FullUser user) {
		User tempUser = mapper.map(user, User.class);
		return mapper.map(users.updateUser(tempUser), FullUser.class);
	}
	
	@DeleteMapping("/{id}")
	public FullUser deleteUser(@PathVariable("id") String id) {
		return mapper.map(users.deleteUser(id), FullUser.class);
	}
}
