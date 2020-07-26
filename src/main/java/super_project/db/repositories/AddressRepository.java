package super_project.db.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import super_project.db.models.Address;

public interface AddressRepository extends MongoRepository<Address, String> {

}
