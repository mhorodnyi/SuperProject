package super_project.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import super_project.db.models.Contacts;

public interface ContactsRepository extends MongoRepository<Contacts, String> {

}
