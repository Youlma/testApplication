package Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import Entity.User;

public interface UserRepository extends MongoRepository<User, String> {
}
