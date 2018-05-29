package hello.Repositories;


import hello.Models.User;
import hello.Services.EntityService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;


public interface UserRepository extends EntityRepository<User>, UserRepositoryCustom {

}
