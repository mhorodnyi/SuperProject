package super_project.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import super_project.db.models.User;

public interface UserRepository extends MongoRepository<User, String> {

}
