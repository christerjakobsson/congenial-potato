package hello.Repositories;


import hello.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public interface UserRepository extends MongoRepository<User, UUID>, UserRepositoryCustom {

}
