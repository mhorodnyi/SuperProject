package super_project.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import super_project.db.models.Contacts;
import super_project.db.repositories.ContactsRepository;

@Service
public class ContactsService {
	@Autowired
	private ContactsRepository userContacts;
	
	public Contacts getUserContacts(String id) {
		return userContacts.findById(id).get();
	}
	
	public Contacts setUpdateUserContacts(Contacts contacts) {
		return userContacts.save(contacts);
	}
	
	public Contacts deleteContacts(String id) {
		Contacts contacts = userContacts.findById(id).get();
		userContacts.delete(contacts);
		return contacts;
	}
	
}
