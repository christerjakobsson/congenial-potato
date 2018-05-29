package hello.Services;

import hello.Models.User;
import hello.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends EntityService<User> {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        repository = userRepository;
    }

    public User findByLogin(String email) {
        return repository.findByEmail(email);
    }

    public User Save(User user) {
        return repository.save(user);
    }
}
