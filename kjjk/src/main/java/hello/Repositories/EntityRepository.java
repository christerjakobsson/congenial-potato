package hello.Repositories;

import hello.Models.EntityBase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EntityRepository<T extends EntityBase> extends MongoRepository<T, UUID> {
}
