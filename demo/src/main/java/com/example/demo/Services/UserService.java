package com.example.demo.Services;

import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    public UserService(UserRepository userRepository) {

        this.repository = userRepository;
    }

    public User findByLogin(String email) {
        return repository.findByEmail(email);
    }
}
