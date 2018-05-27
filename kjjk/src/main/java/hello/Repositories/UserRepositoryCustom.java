package hello.Repositories;

import hello.Models.User;

public interface UserRepositoryCustom {

    User findByEmail(String email);

}
