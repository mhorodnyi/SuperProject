package super_project.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import super_project.db.models.Contacts;
import super_project.db.services.ContactsService;
import super_project.utils.ContactsObject;

@RestController
@RequestMapping("/users/contacts")
public class UserContactsController {
	@Autowired
	ContactsService userContacts;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping
	public ContactsObject getUserContacts(@PathVariable("id") String id) {
		return mapper.map(userContacts.getUserContacts(id), ContactsObject.class);
	}
	
	@PostMapping("/{id}")
	public ContactsObject setUserContacts(@RequestBody ContactsObject contacts) {
		Contacts tempContacts = mapper.map(contacts, Contacts.class);
		return mapper.map(tempContacts, ContactsObject.class);
	}
	
	@PutMapping
	public ContactsObject putUserContacts(
			@RequestBody ContactsObject contacts, 
			@PathVariable("id") String id) {
		Contacts tempContacts = mapper.map(contacts, Contacts.class);
		return mapper.map(tempContacts, ContactsObject.class);
	}
	
	@DeleteMapping
	public ContactsObject deleteUserContacts(@PathVariable("id") String id) {
		return mapper.map(userContacts.deleteContacts(id), ContactsObject.class);
	}
}
