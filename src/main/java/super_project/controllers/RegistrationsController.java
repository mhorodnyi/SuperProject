package super_project.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import super_project.db.models.User;
import super_project.db.services.UserService;
import super_project.utils.FullUser;

@RestController
@RequestMapping(path = "/registration")
public class RegistrationsController {
	@Autowired
	UserService users;
	
	@Autowired
	ModelMapper mapper;
	
	@PostMapping
	public FullUser setUser(@RequestBody @Valid FullUser user) {
		User tempUser = mapper.map(user, User.class);
		return mapper.map(users.setUser(tempUser), FullUser.class);
	}
}
