package super_project.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import super_project.db.services.UserService;
import super_project.utils.user.FullUser;
import super_project.utils.user.RegistrationUserInfo;
import super_project.utils.user.UserMainInfo;
import super_project.db.models.User;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService users;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping("/{id}")
	public FullUser getUser(@PathVariable("id") String id) {
		return mapper.map(users.getUser(id), FullUser.class); 
	}
	
	@PostMapping("/registration")
	@ResponseStatus(HttpStatus.CREATED)
	public UserMainInfo setUser(@RequestBody RegistrationUserInfo user) {
		User tempUser = mapper.map(user, User.class);
		return mapper.map(users.setUpdateUser(tempUser), UserMainInfo.class);
	}
	
	@PutMapping("/{id}")
	public FullUser updateUser(@PathVariable("id") String id, @RequestBody FullUser user) {
		User tempUser = mapper.map(user, User.class);
		return mapper.map(users.setUpdateUser(tempUser), FullUser.class);
	}
	
	@DeleteMapping("/{id}")
	public FullUser deleteUser(@PathVariable("id") String id) {
		return mapper.map(users.deleteUser(id), FullUser.class);
	}
}
