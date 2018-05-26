package com.example.demo.Services;

import com.example.demo.Authentication.PasswordHelper;
import com.example.demo.Models.User;
import com.example.demo.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    private UserRepository userRepository;
    private PasswordHelper passwordHelper;

    public SecurityService(UserRepository userRepository, PasswordHelper passwordHelper) {
        this.userRepository = userRepository;
        this.passwordHelper = passwordHelper;
    }

    public boolean authenticate(String username, String password) {
        String hashedPassword = passwordHelper .hash(password);
        User user = userRepository.findByEmail(username);
        if(user != null) {
            return user.getPassword() == hashedPassword;
        }

        return false;
    }
}