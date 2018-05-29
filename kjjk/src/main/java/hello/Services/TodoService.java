package hello.Services;

import hello.Models.Todo;
import hello.Repositories.EntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService extends EntityService<Todo> {

    public TodoService(EntityRepository<Todo> repository) {
        super(repository);
    }
}
