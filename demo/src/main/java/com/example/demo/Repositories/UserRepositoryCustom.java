package com.example.demo.Repositories;

import com.example.demo.Models.User;

public interface UserRepositoryCustom {

    User findByEmail(String email);

}
